package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.bean.UserBean;
import com.bean.UserLoginBean;
import com.cp.ConnectionProvider;

public class AllUsers {
	
	public static List<UserBean> allUsersList()
	{
		List<UserBean> list = new ArrayList<UserBean>();
		
		Connection con = ConnectionProvider.loadDriver();
		
		String query = "select * from party";
		try(PreparedStatement stmt = con.prepareStatement(query)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				UserBean ub = new UserBean();
				
				ub.setFirstName(rs.getString("firstName"));
				ub.setLastName(rs.getString("lastName"));
				ub.setAddress(rs.getString("address"));
				ub.setCity(rs.getString("city"));
				ub.setState(rs.getString("state"));
				ub.setCountry(rs.getString("country"));
				ub.setZip(rs.getString("zip"));
				ub.setPhone(rs.getString("phone"));
				ub.setPartyId(rs.getInt("partyId"));
				
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
