package com.user.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class users {
	
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/paf_project", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String readUser()
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {
	 return "Error while connecting to the database for reading.";
	 }
	// Prepare the html table to be displayed
	 output = "<table border='1'><tr><th>firstName</th>"
	 + "<th>lastname</th>"
	 + "<th>userAddress</th>"
	 + "<th>contactNumber</th>"		 
	 + "<th>userDOB</th>"		 
	 + "<th>userAge</th>"		 
	 + "<th>userEmail</th>"
	 + "<th>Update</th>"
	 + "<th>Remove</th></tr> ";
	 		
	 
	 String query = "select * from user";
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query);
			 // iterate through the rows in the result set
			 while (rs.next())
			 {
			 String userId = Integer.toString(rs.getInt("userId"));
			 String firstName = rs.getString("firstName");
			 String lastName = rs.getString("lastName");
			 String userAddress = rs.getString("userAddress");
			 String contactNumber = Integer.toString(rs.getInt("contactNumber"));
			 String userDOB = rs.getString("userDOB");
			 String userAge = Integer.toString(rs.getInt("userAge"));
			 String userEmail = rs.getString("userEmail");
			// Add into the html table
		
			  output += "<tr><td><input id='hiduserIdUpdate'"
			 + "name='hiduserIdUpdate'"
			 + "type='hidden' value='" + userId
			 + "'>" + firstName + "</td>";   
			 	 

			 output += "<td>" + lastName + "</td>";
			 output += "<td>" + userAddress + "</td>";
			 output += "<td>" + contactNumber + "</td>";
			 output += "<td>" + userDOB + "</td>";
			 output += "<td>" + userAge + "</td>";
			 output += "<td>" + userEmail + "</td>"; 
			
			// buttons
			 output += "<td><input name='btnUpdate' type='button' "
			+ "value='Update'"
			 + "class='btnUpdate btn btn-secondary'></td> <td><input name='btnRemove' type='button' "
			  + "value='Remove'"
			 +" class='btnRemove btn btn-danger' data-userId='"
			  + userId + "'>" + "</td></tr>"; 
			 
			 }
			 con.close();
			 // Complete the html table
			 output += "</table><br><br>";
			 }
			 catch (Exception e)
			 {
			 output = "Error while reading the users.";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 }

	public String AddUser(String firstName, String lastName, String userAddress,
			String contactNumber, String userDOB, String userAge, String userEmail ) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into user (`userId`,`firstName`,`lastName`,`userAddress`,`contactNumber`, `userDOB`,`userAge`,`userEmail`)"
					+ " values (?, ?, ?, ?, ?, ?,?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, firstName);
			preparedStmt.setString(3, lastName);
			preparedStmt.setString(4, userAddress);
			preparedStmt.setInt(5,Integer.parseInt(contactNumber) );
			preparedStmt.setString(6, userDOB);
			preparedStmt.setInt(7,Integer.parseInt(userAge) );
			preparedStmt.setString(8, userEmail);

			// execute the statement
			preparedStmt.execute();
			con.close();
			String newUser = readUser();
			output = "{\"status\":\"success\", \"data\": \"" + newUser + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the Payment.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateUser(String userId, String firstName, String lastName, String userAddress,
			String contactNumber, String userDOB, String userAge, String userEmail) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE user SET firstName=?,lastName=?,userAddress=?,contactNumber=?,userDOB=?,userAge=?,userEmail=? WHERE userId=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, firstName);
			preparedStmt.setString(2, lastName);
			preparedStmt.setString(3, userAddress);
			preparedStmt.setString(4,contactNumber);
			preparedStmt.setString(5, userDOB);
			preparedStmt.setString(6,userAge);
			preparedStmt.setString(7, userEmail);
			preparedStmt.setInt(8,Integer.parseInt(userId));


			// execute the statement
			preparedStmt.execute();
			con.close();
			String newUser = readUser();
			output = "{\"status\":\"success\", \"data\": \"" + newUser + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": \"Error while updating the user.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteUser(String userId) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from user where userId=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(userId));
			// execute the statement
			preparedStmt.execute();
			con.close();
			String newUser = readUser();
			output = "{\"status\":\"success\", \"data\": \"" + newUser + "\"}";
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\":\"Error while deleting the item.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
