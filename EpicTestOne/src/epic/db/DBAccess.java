package epic.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import epic.characters.Person;


public class DBAccess {
	private static String url = "jdbc:mysql://localhost/uruk";//?user=nabu&password=tyumen2014
	private static String login="nabu";
	private static String pw="tyumen2014";
  private static Connection con = null;
  private static Statement stmt = null;
  private static PreparedStatement ptmt = null;
  private static ResultSet rs = null;
  
  public static Connection getConnection(){
	  try {
	      // this will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // setup the connection with the DB.
	      con = DriverManager.getConnection(url,login,pw);

	      return con;
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	  return null;
  }

  
  // you need to close all three to make sure
  private static void close() {
	   try {
		      if (rs != null) {
		        rs.close();
		      }
		    } catch (Exception e) {
		    // don't throw now as it might leave following closables in undefined state
		    }
	   
	   try {
		      if (stmt != null) {
		        stmt.close();
		      }
		    } catch (Exception e) {
		    // don't throw now as it might leave following closables in undefined state
		    }
	   try {
		      if (ptmt != null) {
		        ptmt.close();
		      }
		    } catch (Exception e) {
		    // don't throw now as it might leave following closables in undefined state
		    }
	   try {
		      if (con != null) {
		        con.close();
		      }
		    } catch (Exception e) {
		    // don't throw now as it might leave following closables in undefined state
		    }
  }


public static Person updatePerson(Person p) {
	getConnection();
	
	try {
		if(p==null) return p;
		if(p.getId()==0){
			ptmt = con.prepareStatement("INSERT INTO uruk.person(name,title,mortal,sex) VALUES (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ptmt.setString(1, p.getName());
			ptmt.setString(2, p.getTitle());
			ptmt.setString(3, p.getMortalStr());
			ptmt.setString(4, p.getSexStr());
			ptmt.executeUpdate();
			rs = ptmt.getGeneratedKeys();
			if(rs.next()){
				p.setId(rs.getInt(1));
			} 
		} else{
			ptmt = con.prepareStatement("UPDATE uruk.person SET name=?,title=?,mortal=?,sex=? WHERE id=?");
			ptmt.setString(1, p.getName());
			ptmt.setString(2, p.getTitle());
			ptmt.setString(3, p.getMortalStr());
			ptmt.setString(4, p.getSexStr());
			ptmt.setInt(5, p.getId());
			ptmt.executeUpdate();
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally{
		close();
	}
	
	return p;
}

public static ArrayList<Person> getPersons() {
	ArrayList<Person> ps = new ArrayList<Person>();
getConnection();
	try {
		ptmt = con.prepareStatement("SELECT id,name,title,mortal,sex FROM uruk.person");
		rs=ptmt.executeQuery();
		while(rs.next()){
			ps.add( new Person(rs.getInt("id"),rs.getString("name"), rs.getString("title"), rs.getString("mortal"), rs.getString("sex"), null));
		}
		addParent(ps);
	
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		close();
	}
	return ps;
}

private static void addParent(ArrayList<Person> ps) {
	try {
		int idchild,idparent;
		ptmt = con.prepareStatement("SELECT id,idparent,idchild FROM uruk.parents");
		rs=ptmt.executeQuery();
		while(rs.next()){
			idchild=rs.getInt("idchild");
			for(Person p:ps){
				if(p.getId()==idchild){
					idparent=rs.getInt("idparent");
					for(Person pa:ps){
						if(pa.getId()==idparent){
							p.getParents().add(pa);
							break;
						}
					}
					break;
				}
			}
		}
	
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		close();
	}
	
}
} 
