package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.connectionutil.ConnectionUtility;
import com.revature.model.Login;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public Login selectLoginByUserAndPass(String user_name, String user_pass) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Login login = null;
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "SELECT * FROM bankapp.login WHERE user_name=? AND user_pass=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, user_name);
			ps.setString(2, user_pass);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				login = new Login(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;
	}

	@Override
	public Boolean insertNewLogin(Login login) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "INSERT INTO bankapp.login VALUES (DEFAULT,?,?)";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, login.getUser_name());
			ps.setString(2, login.getUser_pass());
			ps.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
