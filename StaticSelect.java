package com.jars;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticSelect {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		//1.load the driver
		try {
//		 Class.forName("com.mysql.jdbc.Driver");
		Driver driver=new com.mysql.cj.jdbc.Driver();       //interface
		DriverManager.registerDriver(driver);  //class present in java
		
		//2.get connection via driver
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
		
		//3.issue SQL query via connection
		 stmt = con.createStatement();
		 rs= stmt.executeQuery("select*from ems.employee");
		//4.process the result set
			while(rs.next()) {
				System.out.println(rs.getInt("e_id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("sal"));
				System.out.println(rs.getInt("dept"));
				System.out.println(rs.getInt("phn"));
				
			}
				 
				 
			} catch (SQLException e) {
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


