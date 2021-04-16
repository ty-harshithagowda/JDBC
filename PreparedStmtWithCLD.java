package com.jars;
import java.sql.*;

public class PreparedStmtWithCLD {

	public static void main(String[] args) throws ClassNotFoundException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ems","root","root");
			String e_id="select * from employee where e_id=?";
			String e=args[0];
			pstmt=con.prepareStatement(e_id);
			int id=Integer.parseInt(e);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				System.out.println(rs.getInt(1)+"");
				System.out.println(rs.getString(2)+"");
				System.out.println(rs.getInt(3)+"");
				System.out.println(rs.getInt(4)+"");
				System.out.println(rs.getInt(5)+"");
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
		if(pstmt!=null) 
       	 try {
       		 pstmt.close();
       			 }
			 catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


