package com.user.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.user.utill.DBConnection;

public class LoginSelect {
	
DBConnection obj = new DBConnection();
	
	public int loginVal(String un, String pass) {
		
		try {
			Statement statement = null;
			Connection con = obj.getConnection();
				if (con == null) {
					System.out.println("error connecting database.......");
				}
				
				String query = "select Type from admin where Username='"+un+"' and Password='"+pass+"' ";
				statement = con.createStatement();
				ResultSet rs = statement.executeQuery(query);
				if (rs.next()) {
					System.out.println(rs.getString("Type"));
					if(rs.getString("Type").equals("1")) {
						return 1;
					}else if(rs.getString("Type").equals("2")) {
						return 2;
					}
				}
							
		} catch (Exception e) {
				System.out.println("Error while logging........."+ e);
			}	
		
		return 0;
	}

}
