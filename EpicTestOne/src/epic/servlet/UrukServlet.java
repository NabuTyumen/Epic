package epic.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epic.characters.Person;
import epic.db.DBAccess;

/**
 * Servlet implementation class Uruk
 */
@WebServlet("/Uruk")
public class UrukServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UrukServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = getInteger(request.getParameter("id"));
		String name = getString(request.getParameter("name"));
		String title = getString(request.getParameter("title"));
		boolean mortal = getBoolean(request.getParameter("mortal"));
		char sex = getString(request.getParameter("sex")).charAt(0);
		
		Person p = new Person(id,name,title,mortal,sex,null);
		
		DBAccess.updatePerson(p);
		
	}

	private boolean getBoolean(String parameter) {
		if(parameter==null) return false;
		return "T".equals(parameter)?true:false;
	}

	private int getInteger(String parameter) {
		if(parameter==null) return 0;
		return Integer.parseInt(parameter);
	}

	private String getString(String parameter) {
		if(parameter==null) return "";
		return parameter;
	}

}
