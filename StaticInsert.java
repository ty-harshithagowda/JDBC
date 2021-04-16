package com.jars;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticInsert {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		//1.load the driver
		try {
//		 Class.forName("com.mysql.jdbc.Driver");
		Driver driver=new com.mysql.cj.jdbc.Driver();       //interface
		DriverManager.registerDriver(driver);  //class present in java
		
		//2.get connection via driver
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
		
		//3.issue SQL query via connection
		String query="insert into employee values(1,'rahul',5000,11,9956432)";
		String query1="insert into employee values(2,'rohan',7000,22,99564455)";
		String query2="insert into employee values(3,'dutt',9000,33,99896432)";
		String query3="insert into employee values(4,'sam',2000,44,99598532)";
		String query4="insert into employee values(5,'henry',6000,55,9933432)";
		 stmt = con.createStatement();
		
		//4.process the result set
		int count=stmt.executeUpdate(query);
		stmt.executeUpdate(query1);
		stmt.executeUpdate(query2);
		stmt.executeUpdate(query3);
		stmt.executeUpdate(query4);
		
		System.out.println("number of rows effected"+count);
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