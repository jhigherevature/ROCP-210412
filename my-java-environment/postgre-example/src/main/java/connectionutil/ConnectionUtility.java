package connectionutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 *  This class will contain static methods used to handle the connection with our database
 */
public class ConnectionUtility {
	public static Connection getConnection() throws SQLException{
		/*
		 * By default the URL template for our PostgreDb is:
		 * jdbc:postgresql://{host}[:port}]/[database}]
		 * 
		 * host - the url/location that contains our DB - in our case 'localhost'
		 * port - the port number that allows for communication with our DB.
		 * database - the name of the database we have established by default 'postgre'
		 */
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
