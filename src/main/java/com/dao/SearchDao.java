package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.UserBean;
import com.cp.ConnectionProvider;

public class SearchDao {


	public static List<UserBean> searchQuery(String query)
	{
		List<UserBean> list = new ArrayList<UserBean>();
		
		Connection con = ConnectionProvider.loadDriver();
		
		String query1 = "select firstName, lastName from party where firstName like '"+query+"%' or lastName like '"+query+"%'";
		try(PreparedStatement stmt = con.prepareStatement(query1)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				UserBean ub = new UserBean();
				
				ub.setFirstName(rs.getString("firstName"));
				ub.setLastName(rs.getString("lastName"));
				
				list.add(ub);
				
				//System.out.println(ub);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println(list);
		
		return list;
	}

	
}
