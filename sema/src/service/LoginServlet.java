package service;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sema.model.AEntry;
import sema.model.IUnitOfWork;
import sema.mongodb.MDBUnitOfWork;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String userName = request.getParameter("username");
	        String password = request.getParameter("password");

	        if((userName != null && userName.equalsIgnoreCase("demo")) && (password != null && password.equalsIgnoreCase("123456"))) {
	            response.sendRedirect("events");
	        } else {
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	        }

	    }
	
	 /**
	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        processRequest(request, response);
	    }

	    /**
	     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	     */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        processRequest(request, response);
	        
	    
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        
	        IUnitOfWork uow = new MDBUnitOfWork("user"); 
	        //AEntry u = uow.find(email);
	        
	        MessageDigest digest;
			try {
				digest = MessageDigest.getInstance("SHA-256");
				 byte[] hash = digest.digest(password.getBytes("UTF-8"));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
	       
	        
	    }
	    

}
