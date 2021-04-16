package com.jars;

import java.sql.*;

public class DynamicUpdate {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
			for(int i=1;i<=5;i++)
			{
			String query="update employee set name =? where e_id=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,"rahul");
			pstmt.setInt(2,i);
			
			pstmt.executeUpdate();
			System.out.println("successfull!");}
		} catch (Exception e) {
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
		if(pstmt!=null) 
        	 try {
        		 pstmt.close();
        			 }
			 catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


