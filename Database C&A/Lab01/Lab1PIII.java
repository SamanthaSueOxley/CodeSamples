import java.io.*;
import java.sql.*;
/** 
*	Lab1PIII - JDBC Connectivity lab
*     This code will not compile or execute.
*     Locate the following pseudocode in this object and replace
*     it with correct code
* ------------------------------------
*  LOAD Driver
*    // Declare local variables as necessary
*    // Instantiate Connection object
*    // Connect to the database		
*    // Instantiate Statement object
*    // Execute the query (SELECT ? and instantiate ResultSet object
*    // if the result set is not null
*    // get each row from result set
*    // output each evalID, employeeID
*    // quarter, initials, q1 and q2
*    // Close the result set<BR>
*    // Close the statement<BR>		       
*    // Close the connection<BR>
*
* ------------------------------------				
*   Exceptions handled:SQLException, IOException, Exception
*/
public class Lab1PIII{
	public static void main (String[] args)throws SQLException{		
		String url =  "";                    // Northwind w/evaluation table
		String loginName = "admin";         // or ""
		String password = "";	
			
		try {
			// LOAD Driver
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("You have loaded a driver!\n");
		} 
		catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException = JDBC:ODBC Driver: ");
			System.err.println(e.getMessage());
		}
		
		try {
	      // Declare local variables as necessary
         ResultSet myRset = null;
         Statement myStmt = null;
         Connection myCon = null;
         String query = "";
        
         url = "jdbc:odbc:Northwind";
         myCon = DriverManager.getConnection( url); // Instantiate Connection object
  			System.out.println("You have connected to a database with the URL of " + url + "\n"); // Connect to the database
         myStmt = myCon.createStatement(); // Instantiate Statement object
		   // Execute the query (SELECT ? and instantiate ResultSet object
         //query = "SELECT ID, EmployeeID, quarter, initials, Q1, Q2 FROM Evaluations WHERE initials like 'DPB'";
         query = "SELECT EmployeeID from Employees";
         myRset = myStmt.executeQuery(query);
		   // if the result set is not null
         int id = 0;
         int empId = 0;
         int quarter = 0;
         String initials = "";
         int Q1 = 0;
         int Q2 = 0;
         
         while(myRset.next()){
            id = myRset.getInt(1); 
            empId = myRset.getInt(2);
            quarter = myRset.getInt(3);
            initials = myRset.getString(4);
            Q1 = myRset.getInt(5);
            Q2 = myRset.getInt(6);
            
            System.out.printf("%1$4%2$4%3$8%4$4s%5$2%6$2", id, empId, quarter, initials, Q1, Q2);
         }
         myRset.close();
         myStmt.close();
         myCon.close();
			// end if			
		}catch(SQLException e) {
			System.err.println("SQL Error(s) as follows:");
			while (e != null) {
				System.err.println("SQL Return Code: " + e.getSQLState());
				System.err.println("  Error Message: " + e.getMessage());
				System.err.println(" Vendor Message: " + e.getErrorCode());
				e = e.getNextException();
			}		
		}catch(Exception e) {
			System.err.println(e);
		}
	}
}
