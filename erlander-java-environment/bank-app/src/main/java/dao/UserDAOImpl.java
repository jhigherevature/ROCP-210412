package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utilities.ConnectionUtility;

public class UserDAOImpl implements UserDAO {

	@Override
	public User selectUserByUsernameAndPassword(String username, String user_pass) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;

		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "SELECT * FROM bank.users WHERE username = ? AND userpassword = ?";
			ps = conn.prepareStatement(query);

			ps.setString(1, username);
			ps.setString(2, user_pass);

			rs = ps.executeQuery();

			while (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return user;
	}

	@Override
	public User createNewUser(User user) {
		PreparedStatement ps = null;
		ResultSet rs;
		User newUser = user;

		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "INSERT INTO bank.users VALUES (DEFAULT,?,?,?,?) RETURNING user_id";
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());

			rs = ps.executeQuery();

			if (rs.next()) {
				newUser.setUserID(rs.getInt(1));
			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return newUser;
	}

	@Override
	public boolean checkIfUsernameExists(String username) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "SELECT * FROM bank.users WHERE username = ?";
			ps = conn.prepareStatement(query);

			ps.setString(1, username);

			rs = ps.executeQuery();

			if (rs.next() == true) {
		
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return false;
	}

	@Override
	public boolean checkIfPasswordIsCorrect(String username, String user_pass) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "SELECT * FROM bank.users WHERE username = ? AND userpassword = ?";
			ps = conn.prepareStatement(query);

			ps.setString(1, username);
			ps.setString(2, user_pass);

			rs = ps.executeQuery();

			if (rs.next() != false) {
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return false;
	}

}
