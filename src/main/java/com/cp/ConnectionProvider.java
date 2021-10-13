package com.cp;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
static Connection con;
	
	public static Connection loadDriver() {
		
		String dbUrl = "jdbc:mysql://localhost:3306/siddharth";
		String dbUname = "root";
		String dbPassword = "123456";
		
		//Load the Driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//creating connection
			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}


}
