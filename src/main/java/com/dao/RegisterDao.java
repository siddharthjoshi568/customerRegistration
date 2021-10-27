package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.UserBean;
import com.bean.UserLoginBean;
import com.cp.ConnectionProvider;
import java.sql.Statement;

public class RegisterDao {

	public static boolean userRegistration(UserBean ub, UserLoginBean ulb) {
		boolean bool = false;

		try {
			//Code to insert data into Party
			// jdbc code
			Connection con = ConnectionProvider.loadDriver();

			String query = "insert into Party(firstName, lastName, address, city, zip, state, country, phone) values(?,?,?,?,?,?,?,?)";

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

			// Execute the query
			pstmt.executeUpdate();

			//Code to fetch the partyId of current user
			int max = 0;
			String query2 = "select max(partyId) from Party";
			try (Statement stmt = con.createStatement()) {
				ResultSet rs = stmt.executeQuery(query2);
				if (rs.next()) {
					max = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
			//Code to save user in userlogin table
			String query1 = "insert into userlogin(userLoginId, password, partyId) values(?,?,?)";

			PreparedStatement pstmt1 = con.prepareStatement(query1);

			// Setting values of parameters
			pstmt1.setString(1, ulb.getUserLoginId());
			pstmt1.setString(2, ulb.getPassword());
			pstmt1.setInt(3, max);

			// Execute the query
			pstmt1.executeUpdate();
			bool = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

}
