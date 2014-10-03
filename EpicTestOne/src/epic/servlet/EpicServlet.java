package epic.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epic.Epic;
import epic.actions.Act;

/**
 * Servlet implementation class EpicServlet
 */
@WebServlet("/EpicServlet")
public class EpicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EpicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Set response content type
	      response.setContentType("text/html");

	      // Actual logic goes here.
	      PrintWriter out = response.getWriter();
	      out.println("<h1>Epic Servlet of Gilgamesh (GET)</h1>");
	      
	      
	      for(Act a:Epic.getActions()){
	    	  out.println("<p>"+a.write()+"</p>");
			}
	      
	      out.println("<div>");
	      out.println("<p>Typemime de la requête :"
	    	        +request.getContentType()+"</p>");
	    	      out.println("<p>Protocolede la requête :"
	    	        +request.getProtocol()+"</p>");
	    	      out.println("<p>AdresseIP du client :"
	    	        +request.getRemoteAddr()+"</p>");
	    	      out.println("<p>Nom duclient : "
	    	        +request.getRemoteHost()+"</p>");
	    	      out.println("<p>Nom duserveur qui a reçu la requête :"
	    	        +request.getServerName()+"</p>");
	    	      out.println("<p>Port duserveur qui a reçu la requête :"
	    	        +request.getServerPort()+"</p>");
	    	      out.println("<p>scheme: "+request.getScheme()+"</p>");
	    	      out.println("<p>liste des parametres </p>");

	    	      for (Enumeration<String> e =request.getParameterNames() ; e.hasMoreElements() ; ) {

	    	         Object p = e.nextElement();
	    	         out.println("<p>&nbsp;&nbsp;nom : "+p+" valeur :"
	    	            +request.getParameter(""+p)+"</p>");

	    	      }
	    	      out.println("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Set response content type
	      response.setContentType("text/html");

	      // Actual logic goes here.
	      PrintWriter out = response.getWriter();
	      out.println("<h1>Epic Servlet of Gilgamesh (POST)</h1>");
	      
	}

}
