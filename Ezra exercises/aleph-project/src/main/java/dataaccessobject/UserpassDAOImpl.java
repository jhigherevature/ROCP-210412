package dataaccessobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectutil.ConnectUtil;
import model.Userpass;

public class UserpassDAOImpl implements UserpassDAO {

	@Override
	public Userpass selectLoginByUserAndPass(String username, String pw) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Userpass userpass = null;
		
		try (Connection conn = ConnectUtil.getConnection()) {

			String query = "SELECT * FROM project.userpass WHERE username=? AND pw=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, username);
			ps.setString(2, pw);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				userpass = new Userpass(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userpass;
	}
	
	public Userpass createUserpass(String username, String pw, String access_lvl) {
		PreparedStatement ps = null;
//		ResultSet rs = null;
		Userpass userpass = null;
		
		try (Connection conn = ConnectUtil.getConnection()) {

			String query = "INSERT INTO project.userpass VALUES (default, ?, ?, ?);";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, username);
			ps.setString(2, pw);
			ps.setString(3, access_lvl);
			
			ps.executeUpdate();
//			rs = ps.executeUpdate();
			
//			while (rs.next()) {
//				userpass = new Userpass(
//						rs.getInt(1),
//						rs.getString(2),
//						rs.getString(3),
//						rs.getString(4)
//						);
//			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userpass;
	}
	
	}