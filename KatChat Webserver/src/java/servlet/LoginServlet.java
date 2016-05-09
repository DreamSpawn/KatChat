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
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		IKatServer server = null;
		int sessionID = -1;
		//PrintWriter printWriter = response.getWriter();
		HttpSession session = request.getSession();

		String username = request.getParameter("userID");
		String password = request.getParameter("password");

		session.setAttribute("userID", username);
		session.setAttribute("password", password);

		try {
			server = (IKatServer) Naming.lookup(IKatServer.FULL_ADDRESS);
			sessionID = server.login(username, password);
		} catch (NotBoundException | MalformedURLException | RemoteException ex) {
			//TODO fejlbesked
		}

		String nextJSP;
		if (sessionID != -1) {
			session.setAttribute("JavaSessionID", sessionID);
			nextJSP = "/Chat.jsp";
		} else {
			//TODO fejlbesked
			nextJSP = "/Login.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);//sender videre til ny jsp side
		dispatcher.forward(request, response);

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String nextJSP = "/Login.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);//sender videre til ny jsp side
		dispatcher.forward(request, response);

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
