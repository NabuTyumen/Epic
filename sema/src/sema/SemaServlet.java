package sema;

import java.io.*;
import java.util.Enumeration;






import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SemaServlet extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private ServletConfig cfg;




  public String getServletInfo() {
    return "Servlet Controller Sema";
  }	

  public void destroy() {
  }
  /*@Override
  public void service (ServletRequest req,  ServletResponse res ) 
  throws ServletException, IOException  {
    res.setContentType( "text/html" );
    PrintWriter out = res.getWriter();
    out.println( "<HTML>" );
    out.println( "<HEAD>");
    out.println( "<TITLE>Page generee par une servlet</TITLE>" );
    out.println( "</HEAD>" );
    out.println( "<BODY>" );
    out.println( "<H1>Bonjour</H1>" );
    out.println( "</BODY>" );
    out.println( "</HTML>" );
    out.close();
  }*/
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException,ServletException {
	
	      //setResponse(request, response);
	  getServletContext().getRequestDispatcher("/sema.jsp").forward(request,response);
	   }
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException,ServletException {
	      
	  		String p = request.getParameter("user");
	     // setResponse(request, response);
	  		
	  		getServletContext().getRequestDispatcher("/sema.jsp").forward(request,response);

	   }
	/**
	     protected void setResponse(HttpServletRequest request, HttpServletResponse reponse) 
	 
	      throws IOException {
	 
	      reponse.setContentType("text/html");

	      PrintWriter out =reponse.getWriter();

	      out.println("<html>");
	      out.println("<body>");
	      out.println("<head>");
	      out.println("<title>Informationsa disposition de la servlet</title>");
	      out.println("</head>");
	      out.println("<body>");
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

	      out.println("</body>");
	      out.println("</html>");
	   }**/

	@Override
	public ServletConfig getServletConfig() {
		 return cfg;
	}

	@Override
	  public void init(ServletConfig config) throws ServletException {
		     cfg = config;
		  }


}