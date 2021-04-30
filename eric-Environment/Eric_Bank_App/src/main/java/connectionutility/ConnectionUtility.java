package connectionutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
	
	/*
	 * This class will contain static methods used to
	 * handle the connection with our database
	 */

	public static Connection getConnection(String level) throws SQLException {
			
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String user = null;
			String pass = null;
			
			if (level == "banker") {
				user = "banker";
				pass = "banking";
			}
			
			if (level == "employee") {
				user = "employee";
				pass = "working";
			}
			
			if (level == "customer") {
				user = "customer";
				pass = "transaction";
			}
			
			if (level == "login") {
				user = "login";
				pass = "login";
			}
			
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
			try (Connection conn = ConnectionUtility.getConnection("login")) {
				System.out.println("The Connection Was Successful!");
			} catch (SQLException sqlE) {
				System.out.println("The Connection Failed!");
				sqlE.printStackTrace();
			}
	
		}
		
}
