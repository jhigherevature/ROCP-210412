package connectionutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * this class will contain static methods used to handle the connection with the database
 */

public class ConnectionUtility {
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "example";
		String pass = "password";
		
		return DriverManager.getConnection(url, user, pass);
	}
	
	public static void main(String[] args) {
		try (Connection conn = ConnectionUtility.getConnection()){
			System.out.println("The connection was successful!");
		} catch(SQLException sqlE) {
			System.out.println("The connection failed!");
			sqlE.printStackTrace();
		}
	}
}
