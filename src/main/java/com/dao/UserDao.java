package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bean.UserBean;
import com.bean.UserLoginBean;
import com.cp.ConnectionProvider;

public class UserDao {

	public static UserBean getUserByPartyId(String partyId) {
		UserBean ub = new UserBean();
		String query = "select * from party where partyId='" + partyId + "'";

		Connection con = ConnectionProvider.loadDriver();
		try (PreparedStatement stmt = con.prepareStatement(query)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ub.setFirstName(rs.getString("firstName"));
				ub.setLastName(rs.getString("lastName"));
				ub.setAddress(rs.getString("address"));
				ub.setCity(rs.getString("city"));
				ub.setCountry(rs.getString("country"));
				ub.setZip(rs.getString("zip"));
				ub.setState(rs.getString("state"));
				ub.setPhone(rs.getString("phone"));
				ub.setPartyId(rs.getInt("partyId"));
			}
			System.out.println(ub + "In UserDao Class");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in Finding");
		}
		return ub;
	}

	public static boolean userUpdation(UserBean ub) {
		boolean bool = false;

		try {
			// Code to insert data into Party
			// jdbc code
			Connection con = ConnectionProvider.loadDriver();

			String query = "update Party set firstName=?, lastName=?, address=?, city=?, zip=?, state=?, country=?, phone=? where partyId=?";

			// Preparedstatement
			PreparedStatement pstmt = con.prepareStatement(query);

			// Setting values of parameters
			pstmt.setString(1, ub.getFirstName());
			pstmt.setString(2, ub.getLastName());
			pstmt.setString(3, ub.getAddress());
			pstmt.setString(4, ub.getCity());
			pstmt.setString(5, ub.getZip());
			pstmt.setString(6, ub.getState());
			pstmt.setString(7, ub.getCountry());
			pstmt.setString(8, ub.getPhone());
			pstmt.setInt(9, ub.getPartyId());

			// Execute the query
			pstmt.executeUpdate();

			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			return bool;
	}
	
	
	public static boolean deleteUser(UserBean ub)
	{
		boolean bool = false;
		Connection con = ConnectionProvider.loadDriver();
		String query = "delete from party where partyId="+ub.getPartyId();
		String query1 = "delete from userLogin where partyId="+ub.getPartyId();
		try(Statement stmt = con.createStatement()){
			
			//Deleting from userlogintable
			Statement stmt1 = con.createStatement();
			stmt.executeUpdate(query1);
						
			//deleting from party table
			stmt.executeUpdate(query);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return bool;
	}

}
