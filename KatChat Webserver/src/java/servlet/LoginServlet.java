/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import server.IKatServer;

/**
 *
 * @author JoachimØstergaard
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     */
     private Login login;
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html");
         IKatServer server =null;
         try {
             server = (IKatServer) Naming.lookup(IKatServer.FULL_ADDRESS);
         } catch (NotBoundException ex) {
             Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (MalformedURLException ex) {
             Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (RemoteException ex) {
             Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
            PrintWriter printWriter = response.getWriter();
            HttpSession httpSession = request.getSession(true);
            String username =request.getParameter("userID");
            
            httpSession.setAttribute("userID",username );
             String password =request.getParameter("password");
            httpSession.setAttribute("password", password);
             HttpSession session = request.getSession();
            login = (Login) session.getAttribute("login");
            int sessionID = server.login(username, password);
            if(sessionID != -1){
            login.setSessionId(sessionID);
            //TJekker valid og giver session ID 
           
                login.setUserName(username);
                login.setSessionId(sessionID);
                login.setValid(true);
            if(username.equals("jokse")||username.equals("joey")){ 
               
            
            String nextJSP = "/chat.jsp"; 
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);//sender videre til ny jsp side
            dispatcher.forward(request,response);
            }
            }
            
         
        }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
