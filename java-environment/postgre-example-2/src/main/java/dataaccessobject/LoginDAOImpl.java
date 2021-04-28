package dataaccessobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectionutil.ConnectionUtility;
import model.Login;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public Login selectLoginByUserAndPass(String user_name, String user_pass) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Login login = null;
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			/*
			 * The '?' in the String query below is the parameter
			 * marker for our PreparedStatement. We can set the
			 * value used in the parameter markers by referencing
			 * the prepared statement and setting the value of those
			 * markers using the marker's position (the indexing here
			 * also starts at 1.
			 */
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
}
