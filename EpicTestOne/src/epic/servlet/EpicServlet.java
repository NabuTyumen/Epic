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
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<LINK rel=stylesheet type=\"text/css\" href=\"css/epic.css\">");
	      out.println("</head>");
	      out.println("<body>");
	     
	      
	      out.println("<h1>Epic Servlet of Gilgamesh</h1>");
	      
	      out.println("<div>");
	      out.println("<div class=\"left\">");
	      out.println("<div class=\"text\">");
	      for(Act a:Epic.getActions(request.getParameter("ver"))){
	    	  out.println("<p>"+a.write()+"</p>");
			}
	      out.println("</div>");
	      
	      out.println("<div class=\"tech\">");
	    	      out.println("<p>Request protocol :"
	    	        +request.getProtocol()+"</p>");
	    	      out.println("<p>IP adress client :"
	    	        +request.getRemoteAddr()+"</p>");
	    	      out.println("<p>Client name : "
	    	        +request.getRemoteHost()+"</p>");
	    	      out.println("<p>Server name :"
	    	        +request.getServerName()+"</p>");
	    	      out.println("<p>Port :"
	    	        +request.getServerPort()+"</p>");
	    	      out.println("<p>Scheme: "+request.getScheme()+"</p>");
	    	      out.println("<p>List of the parameters </p>");

	    	      for (Enumeration<String> e =request.getParameterNames() ; e.hasMoreElements() ; ) {

	    	         Object p = e.nextElement();
	    	         out.println("<p>&nbsp;&nbsp;name : "+p+", value :"
	    	            +request.getParameter(""+p)+"</p>");

	    	      }
	    	      out.println("</div>");
	    	      out.println("</div>");
	    	      out.println("<div class=\"image\">");
	    	      out.println("<img src=\"img/gilgamesh.jpg\">");
	    	      out.println("</div>");
	    	      out.println("</div>");
	    	      out.println("</body>");
	    	      out.println("</html>");
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
