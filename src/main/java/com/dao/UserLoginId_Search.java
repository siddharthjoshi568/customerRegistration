package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.cp.ConnectionProvider;

public class UserLoginId_Search {

	public static boolean findUser(String userLoginId)
	{
		boolean bool = false;		
		String query = "select userLoginId from UserLogin where userLoginId='"+userLoginId + "'";
		
		Connection con = ConnectionProvider.loadDriver();
		try(Statement stmt = con.createStatement()){
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next())
				return true;
			else 
				return false;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in Finding");
		}
		return bool;	
	}
}
