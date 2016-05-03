/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import java.util.Collections;
import java.util.LinkedHashMap;

import java.util.Map;

import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.OnMessage;

import servlet.Login;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import javax.servlet.AsyncContext;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author JoKse
 */


/**
 * Servlet implementation class Controller
 */
@WebServlet(name = "WsChatServlet" ,urlPatterns = {"/WsChatServlet"}, asyncSupported=true)
public class WsChatServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

 
   /* notified when the user closes connection */
  private List<AsyncContext> contexts = new LinkedList<>();

    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<AsyncContext> asyncContexts = new ArrayList<>(this.contexts);
        this.contexts.clear();
        HttpSession session = request.getSession();
        Login login = (Login) session.getAttribute("login");
        String name = login.getUserName();
        String message = request.getParameter("message");
        String htmlMessage =  message ;
       
        for (AsyncContext asyncContext : asyncContexts) {
            try (PrintWriter writer = asyncContext.getResponse().getWriter()) {
                writer.println(htmlMessage);
                writer.flush();
                asyncContext.complete();
            } catch (Exception ex) {
            }
        }
         

    }
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final AsyncContext asyncContext = request.startAsync(request, response);
        asyncContext.setTimeout(10 * 60 * 1000);
        contexts.add(asyncContext);
    }
    
        /*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // Set response content type
      response.setContentType("text/html");

      // Actual logic goes here.

        //notifyAdministratorAbout(request);
            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            HttpSession httpSession = request.getSession(true);
            String username =request.getParameter("userID");
            
            httpSession.setAttribute("userID",username );
             String password =request.getParameter("password");
            httpSession.setAttribute("password", password);
             HttpSession session = request.getSession();
            login = (Login) session.getAttribute("login");
            if(username !=null){
                login.setUserName(username);
            if(username.equals("jokse")){ login.setValid("hey");
            
            String nextJSP = "/Login.jsp"; 
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);//sender videre til ny jsp side
            dispatcher.forward(request,response);
            }else login.setValid("hey2");
            }
            List<AsyncContext> asyncContexts = new ArrayList<>(this.contexts);
        this.contexts.clear();
            String name = request.getParameter("name");
        String message = request.getParameter("message");
        String htmlMessage = "<p><b>" + name + "</b><br/>" + message + "</p>";
        ServletContext sc = request.getServletContext();
        if (sc.getAttribute("messages") == null) {
            sc.setAttribute("messages", htmlMessage);
        } else {
            String currentMessages = (String) sc.getAttribute("messages");
            sc.setAttribute("messages", htmlMessage + currentMessages);
        }
        for (AsyncContext asyncContext : asyncContexts) {
            try (PrintWriter writer = asyncContext.getResponse().getWriter()) {
                writer.println(htmlMessage);
                writer.flush();
                asyncContext.complete();
            } catch (Exception ex) {
            }
        }
            if(username.equals("jokse")){
                printWriter.println("<html>");
                printWriter.println("<head><title>Welcome to KatChat</title></head>");
                printWriter.println("<body>");
                printWriter.println("<mark>username: "+username+"</mark><br>");
                printWriter.println("<textarea id=\"messagesTexArea\" readonly=\"readonly\" rows=\"10\" cols=\"45\"></textarea><br/>");
                printWriter.print("<input type=\"text\" id=\"messageText\" size=\"50\" />");
                printWriter.println("<input type=\"button\" value=\"Send\" onclick=\"sendMessage();\" />");
                printWriter.println("<script>");
                printWriter.println("var websocket = new WebSocket(\"ws://localhost:8080/KatWeb/ChatEndPoint\");");
                printWriter.println("websocket.onmessage = function processMessage(message){");
                printWriter.println("var jsonData = message.data;");
                printWriter.println("if (jsonData.message !=null) messagesTextArea.value += jsonData.message + \"\\n\";");
                
                printWriter.println("}");
                printWriter.println("function sendMessage() {");
                printWriter.println("websocket.send(messageText.value);");
                printWriter.println("messageText.value=\"\";");
                printWriter.println("}");
                printWriter.println("</script>");
                printWriter.println("</body>");
                printWriter.println("</html>");
                
            }
       

    
             
        }      
*/
        
      
	

	private void directToErrorPage(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		String nextJSP = "/FailedLogin.jsp";//hvis brugernavn er forkert videresendes til denne side
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);
	}
}

