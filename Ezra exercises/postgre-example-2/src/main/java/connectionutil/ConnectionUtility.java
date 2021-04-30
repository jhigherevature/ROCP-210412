package connectionutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * This class will contain static methods used to
 * handle the connection with our database
 */
public class ConnectionUtility {
	public static Connection getConnection() throws SQLException {
		/*
		 * By default the URL Template for our Postgre DB is:
		 * jdbc:postgresql://{host}[:{port}]/[{database}]
		 * 
		 * 	host - the url/location that contains our DB
		 * 			In our case 'localhost'
		 * 	port - the port number that allows for communication
		 * 			with our DB.
		 * 	database - the name of the database we have established
		 * 				by default 'postgre'
		 */
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "customers";
		String pass = "password";
		return DriverManager.getConnection(url, user, pass);
	}
	
	/*
	 * We are using the following main method to test if
	 * we can even establish a connection with our DB
	 */
	public static void main(String[] args) {
		/*
		 * try-with-resources:
		 * 		when creating a try-catch block we can create
		 * 		objects or references in a set of parenthesis
		 * 		immediately after the try keyword, which will
		 * 		establish a resource we will attempt to use 
		 * 		prior to the execution of code within our try-catch
		 * 		block.
		 */
		try (Connection conn = ConnectionUtility.getConnection()) {
			System.out.println("The Connection Was Successful!");
		} catch (SQLException sqlE) {
			System.out.println("The Connection Failed!");
			sqlE.printStackTrace();
		}
	}
}
