package connectutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectUtil {
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "test_admin";
		String pass = "pw";
		return DriverManager.getConnection(url, user, pass);		
	}

	public static void main(String[] args) {
		try (Connection conn = ConnectUtil.getConnection()) {
			System.out.println("Connection successful");
		} catch (SQLException sqlE) {
			System.out.println("Connection failed");
			sqlE.printStackTrace();
		}
		
	}

}
