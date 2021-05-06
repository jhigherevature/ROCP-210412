package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
	private static final String url = "jdbc:postgresql://localhost:5432/postgres";
	private static final String user = "test_user";
	private static final String pass = "testing";
	private static Connection connection;
	
	
	public static synchronized Connection getConnection() throws SQLException{
		if (connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not register driver!");
				e.printStackTrace();
			}
			
			connection = DriverManager.getConnection(url, user, pass);
		}
		
		if (connection.isClosed()){
			connection = DriverManager.getConnection(url, user, pass);
		}
		
		return connection;
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
