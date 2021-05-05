package dataaccessobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectutil.ConnectUtil;
import model.Pledge;
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userpass;
	}
	
	public boolean updateUserpass(Userpass Userpass) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "UPDATE project.Userpass SET username=?, pw=? WHERE id_userpass=?;";
			ps = conn.prepareStatement(query);
			ps.setString(1, Userpass.getUsername());
			ps.setString(2, Userpass.getPw());
			ps.setInt(3, Userpass.getId_userpass());

	//	does this line work? It will 1. print the number of lines updated and 2. execute the update
			System.out.println("The number of usernames updated are: " + ps.executeUpdate());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	}