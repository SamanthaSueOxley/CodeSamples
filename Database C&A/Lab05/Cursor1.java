/* Lecture Example LBE05
   Completed by Samantha Oxley
   Comparing FORWARD_ONLY cursor with SCROLL_INSENSITIVE cursor
*/
import java.sql.*;

public class Cursor1
{
	private Connection conn = null;
	private Class driver = null;
	
	// the constructor handles the creation of a connection 
	public Cursor1() throws ClassNotFoundException,SQLException
	{
		// load the driver
		driver = Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		// connect to the Northwind database
		// note that this assumes that DSN of "Northwind" is defined
		conn = DriverManager.getConnection("jdbc:odbc:northwind","admin","");
		System.out.println("Driver loaded and connection created");
	}
	
	public void runQuery() throws SQLException
	{
      Statement stmt;
      ResultSet rs;
		
      String query = "select CompanyName, Phone from shippers";
		// create the statement
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = stmt.executeQuery(query);
		System.out.print("Default ResultSet Type is:\t");
      switch(rs.getType()){
         case ResultSet.TYPE_SCROLL_INSENSITIVE:
            break;
         case ResultSet.TYPE_SCROLL_SENSITIVE:
            break;
         case ResultSet.TYPE_FORWARD_ONLY:
            break;
      }
	   DatabaseMetaData dmd = conn.getMetaData();  
		
		// use a cursor to step through the data
		// the data values are both strings
		System.out.println("\nData printed forwards\n");
		while(rs.next())  // go through forward
		{
			pause(10);
			String companyName = rs.getString(1);
			String phone = rs.getString(2);
			System.out.println("Name: " + companyName + " phone: " + phone);
		}
		
		//lbe5 - cursor 1
		// now go through backwards
      System.out.println("\nData printed backwards\n");
      rs.last();
      rs.next();
      while(rs.previous()){
         String companyName = rs.getString(1);
			String phone = rs.getString(2);
			System.out.println("Name: " + companyName + " phone: " + phone);
      }
		
	}
	
	public static void pause(int ms)
	{
		try{
			Thread.sleep(ms);
		}catch(Exception e)
		{
		}
	}
	
	public static void main(String [] args)
	{
		try
		{
			Cursor1 c1 = new Cursor1();
			c1.runQuery();
		}
		catch(ClassNotFoundException cfn)
		{
			System.out.println("Unable to load driver.");
		}
		catch(SQLException se)
		{
			System.out.println("SQL Exception detected");
			se.printStackTrace();
		}
	}
}