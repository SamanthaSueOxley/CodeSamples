/* Completed by Samantha Oxley
   Lecture Example LBE05
   Comparing SCROLL_INSENSITIVE cursor with SCROLL_SENSITIVE
   Setup DSN Northwind before running the program
*/

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;	

public class Cursor2 extends JFrame{		


	final String DEFAULT_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
	final String NORTHWIND = "jdbc:odbc:Northwind";

	private String driver, url, user, password;
	public Cursor2() {
		// build the GUI here
		super("Result Set Demo");					
  		setSize(200,200);
		setLocation(150,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton jbConnect = new JButton("Connect to DataSource");
		add(jbConnect);

		// button event handling
		jbConnect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				testDNS();
			}
		});

		setVisible(true);
	}

	public void testDNS(){

		try {
	 	   Class.forName(DEFAULT_DRIVER);
		}catch (ClassNotFoundException e) {
			// Create a dialog box
	    	JOptionPane.showMessageDialog(null,"Unable to load driver class: \n" +
	    		driver); 
	    	return;
		}

		// get a connection
		boolean connected = true;
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection(NORTHWIND);
		}catch (SQLException se) {
			connected = false;
		}

		if(connected){
			JOptionPane.showMessageDialog(null,"Hurray, your DSN works");
		}else{
			JOptionPane.showMessageDialog(null,"Unable to connect to data source:\n" +
				url); 
		}

		Statement stmt = null;
		Statement stmt2 = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
			stmt2 = conn.createStatement();
			rs = stmt.executeQuery("select CompanyName, Phone from shippers");
         // print forwards
			while(rs.next()){
				pause(10);
				String companyName = rs.getString(1);
				String phone = rs.getString(2);
				System.out.println("Name: " + companyName + " phone: " + phone);
			}
			JOptionPane.showMessageDialog(null, "\nLet's reverse the visit\n");
			rs.afterLast();
         //print backwards
			while(rs.previous()){
				pause(10);
				String companyName = rs.getString(1);
				String phone = rs.getString(2);
				System.out.println("Name: " + companyName + " phone: " + phone);
			}
         //update database
         System.out.println("\nLet's do some update\n");
         rs.absolute(2);
         rs.updateString("Phone", "3333");
         rs.updateRow();
	
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		catch(SQLException se) { se.printStackTrace(); }
	}

	public static void pause(int ms){
		try{
			Thread.sleep(ms);
		}catch(Exception e){ e.printStackTrace(); }
	}

	public static void main(String [] args){
		new Cursor2();
	}
}