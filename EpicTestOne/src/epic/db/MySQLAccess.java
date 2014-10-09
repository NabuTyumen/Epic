package epic.db;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySQLAccess {
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
  
  public static void updDataBase() throws Exception {
	  getConnection();
	   // preparedStatements can use variables and are more efficient
      ptmt = con.prepareStatement("insert into uruk.god(name,title) values (?, ?)");
      ptmt.setString(1, "Enlil");
      ptmt.setString(2, "Lord of the Storm");
      ptmt.executeUpdate();
  }

  public static void readDataBase() throws Exception {
    try {
    	getConnection();
      // statements allow to issue SQL queries to the database
      stmt = con.createStatement();
      // resultSet gets the result of the SQL query
      rs = stmt.executeQuery("select * from uruk.god");
      writeResultSet(rs);


      ptmt = con.prepareStatement("SELECT name,title from uruk.god");
      rs = ptmt.executeQuery();
      writeResultSet(rs);

      /* remove again the insert comment
      ptmt = con
      .prepareStatement("delete from FEEDBACK.COMMENTS where myuser= ? ; ");
      ptmt.setString(1, "Test");
      ptmt.executeUpdate();*/
      
      rs = stmt.executeQuery("select * from uruk.god");
      writeMetaData(rs);
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

  private static void writeMetaData(ResultSet resultSet) throws SQLException {
    // now get some metadata from the database
    System.out.println("The columns in the table are: ");
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private static void writeResultSet(ResultSet resultSet) throws SQLException {
    // resultSet is initialised before the first data set
    while (resultSet.next()) {
    	int id = resultSet.getInt("idgod");
      String god = resultSet.getString("name");
      String title = resultSet.getString("title");
      System.out.println("Id: " + id);
      System.out.println("God: " + god);
      System.out.println("Title: " + title);
    }
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

  public static void main(String[] args) {
	  try {
		updDataBase();
		readDataBase();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  

	}
} 
