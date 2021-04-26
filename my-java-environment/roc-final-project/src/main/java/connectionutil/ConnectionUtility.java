package connectionutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtility {
	
	public static Connection getConnection() throws SQLException{	
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String pass = "postgres";
		return DriverManager.getConnection(url,user,pass);
	}
	
	public static void main(String[] args) {
		/*
		 * try-with-resources:
		 * 		when creating a try-catch block we can create objects or references in a set of
		 * 		parenthesis immediately after the try keyword, which will establish a resource we
		 * 		will attempt to use prior to the execution of code within our try-catch block
		 */

		try (Connection conn = ConnectionUtility.getConnection()) {
			System.out.println("Connection was successful");
		}
		catch (SQLException sqlE) {
			System.out.println("Connection failed");
			sqlE.printStackTrace();
		}
	
	}
}