package com.jars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StaticDynamic {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root");
			String query = "delete from employee where e_id=5";
			stmt = con.createStatement();
			int count = stmt.executeUpdate(query);
			System.out.println("no. of rows :" + count);
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (con != null)
			try {
				
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}

	}
}
