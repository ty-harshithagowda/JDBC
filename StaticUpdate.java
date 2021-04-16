package com.jars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticUpdate {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
			stmt=con.createStatement();
			stmt.executeUpdate("update employee set name='harshitha' where e_id=3");
			System.out.println("update sucessfull");
	}catch(Exception e) {
		e.printStackTrace();
	}
		finally {
	       	 //close all jdbc object
	       	 if(con!=null) 
	       		 try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
	       	 
	        } 
			if(stmt!=null) 
	       	 try {
	       		 stmt.close();
	       			 }
				 catch (Exception e) {
					e.printStackTrace();
				}
}
}