package epic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import epic.characters.ManagePerson;

/**
 * Servlet implementation class LoadServlet
 */
@WebServlet("/LoadServlet")
public class LoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = getString(request.getParameter("action"));


		if("load".equals(action)){
			JSONObject json = new JSONObject() ;
			JSONArray persons = new JSONArray(); 
			persons.addAll(ManagePerson.getPersons());			 
			json.put("persons", persons);   
			response.setCharacterEncoding("ISO-8859-1");
			response.setContentType("application/json");
			response.setHeader("Cache-Control", "no-cache");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print(json);
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if("upd".equals(action)){
			int id = getInteger(request.getParameter("id"));
			String field=getString(request.getParameter("field"));
			String value=getString(request.getParameter("value"));
			
			id=ManagePerson.saveOrUpdatePerson(id,field,value); 
			
			JSONObject json = new JSONObject() ;
			json.put("id", id);
			response.setCharacterEncoding("ISO-8859-1");
			response.setContentType("application/json");
			response.setHeader("Cache-Control", "no-cache");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print(json);
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if("del".equals(action)){
			int id = getInteger(request.getParameter("id"));
			ManagePerson.delPerson(id);
			JSONObject json = new JSONObject() ;
			json.put("id", id);
			response.setCharacterEncoding("ISO-8859-1");
			response.setContentType("application/json");
			response.setHeader("Cache-Control", "no-cache");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print(json);
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		


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
