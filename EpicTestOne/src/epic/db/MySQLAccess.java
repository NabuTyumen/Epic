package epic.db;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
  private Connection con = null;
  private Statement stmt = null;
  private PreparedStatement ptmt = null;
  private ResultSet rs = null;

  public void readDataBase() throws Exception {
    try {
      // this will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // setup the connection with the DB.
      con = DriverManager
          .getConnection("jdbc:mysql://localhost/feedback?"
              + "user=sqluser&password=sqluserpw");

      // statements allow to issue SQL queries to the database
      stmt = con.createStatement();
      // resultSet gets the result of the SQL query
      rs = stmt
          .executeQuery("select * from FEEDBACK.COMMENTS");
      writeResultSet(rs);

      // preparedStatements can use variables and are more efficient
      ptmt = con
          .prepareStatement("insert into  FEEDBACK.COMMENTS values (default, ?, ?, ?, ? , ?, ?)");
      // "myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
      // parameters start with 1
      ptmt.setString(1, "Test");
      ptmt.setString(2, "TestEmail");
      ptmt.setString(3, "TestWebpage");
      ptmt.setDate(4, new java.sql.Date(2009, 12, 11));
      ptmt.setString(5, "TestSummary");
      ptmt.setString(6, "TestComment");
      ptmt.executeUpdate();

      ptmt = con
          .prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
      rs = ptmt.executeQuery();
      writeResultSet(rs);

      // remove again the insert comment
      ptmt = con
      .prepareStatement("delete from FEEDBACK.COMMENTS where myuser= ? ; ");
      ptmt.setString(1, "Test");
      ptmt.executeUpdate();
      
      rs = stmt
      .executeQuery("select * from FEEDBACK.COMMENTS");
      writeMetaData(rs);
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

  private void writeMetaData(ResultSet resultSet) throws SQLException {
    // now get some metadata from the database
    System.out.println("The columns in the table are: ");
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // resultSet is initialised before the first data set
    while (resultSet.next()) {
      // it is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g., resultSet.getSTring(2);
      String user = resultSet.getString("myuser");
      String website = resultSet.getString("webpage");
      String summary = resultSet.getString("summary");
      Date date = resultSet.getDate("datum");
      String comment = resultSet.getString("comments");
      System.out.println("User: " + user);
      System.out.println("Website: " + website);
      System.out.println("Summary: " + summary);
      System.out.println("Date: " + date);
      System.out.println("Comment: " + comment);
    }
  }

  // you need to close all three to make sure
  private void close() {
    close((Closeable) rs);
    close((Closeable) stmt);
    close((Closeable) con);
  }
  private void close(Closeable c) {
    try {
      if (c != null) {
        c.close();
      }
    } catch (Exception e) {
    // don't throw now as it might leave following closables in undefined state
    }
  }
} 
