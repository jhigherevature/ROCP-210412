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
		 * The getConnection method of the DriverManager
		 * uses the following syntax:
		 * getConnection(db_url, username, password);
		 * 
		 * The URL Template for our Postgre DB is:
		 * jdbc:postgresql://{host}[:{port}]/[{database}]
		 * 	host - the url/location that contains our DB
		 * 			In our case 'localhost'
		 * 	port - the port number that allows for communication
		 * 			with our DB.
		 * 	database - the name of the database we have established
		 * 				by default 'postgre'
		 * 
		 */
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "customers";
		String pass = "password";
		return DriverManager.getConnection(url, user, pass);
	}
	
	public static Connection getConnectionProperties() throws SQLException, IOException {
		FileInputStream fileStream = new FileInputStream("db-resources/dbconnection.properties");
		Properties props = new Properties();
		props.load(fileStream);
		String url = props.getProperty("CONNECTION_URL");
		String user = props.getProperty("CONNECTION_USERNAME");
		String pass = props.getProperty("CONNECTION_PASSWORD");
		return DriverManager.getConnection(url, user, pass);
	}
	
	public static Connection getConnectionEnvVar() throws SQLException {
		String url = System.getenv("CONN_URL");
		String user = System.getenv("CONN_NAME");
		String pass = System.getenv("CONN_PASS");
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
		 * 		immediately after the keyword 'try', which will
		 * 		establish a resource we will attempt to use 
		 * 		prior to the execution of code within our try-catch
		 * 		block.
		 */
		try (Connection conn = ConnectionUtil.getConnectionEnvVar()){
			System.out.println("[Env Var] The Connection was successful!"); // if this works, our connection was established
		} catch (SQLException e) {
			System.out.println("An Error Occured");
			e.printStackTrace();
		}
		
		try (Connection conn = ConnectionUtil.getConnectionProperties()){
			System.out.println("[Prop File] The Connection was successful!"); // if this works, our connection was established
		} catch (SQLException | IOException e) {
			System.out.println("An Error Occured");
			e.printStackTrace();
		}		
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("[Hard Coded] The Connection was successful!"); // if this works, our connection was established
		} catch(SQLException e) {
			System.out.println("An Error Occured");
			e.printStackTrace();
		}
	}
}
