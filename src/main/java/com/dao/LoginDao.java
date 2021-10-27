package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bean.UserLoginBean;
import com.cp.ConnectionProvider;

public class LoginDao {
	
	public static boolean userLogin(UserLoginBean ulb)
	{
		boolean bool = false;
		Connection con = ConnectionProvider.loadDriver();
		String query = "select * from UserLogin where userLoginId='"+ulb.getUserLoginId()+"' and password='"+ulb.getPassword()+"'";
		try(Statement stmt = con.createStatement()){
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next())
			{
				System.out.print("LoginDao" + rs.next());
				return true;
			}
			else 
			{
				return false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return bool;
	}
}
