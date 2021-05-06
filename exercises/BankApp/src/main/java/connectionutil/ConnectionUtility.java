package connectionutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {

	public static Connection getConnection() throws SQLException 
	{
		
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String pass = "password";
		return DriverManager.getConnection(url, user, pass);
	}
	
	public static void main(String[] args) 
	{
		try(Connection conn = ConnectionUtility.getConnection())
		{
			System.out.println("The Connection Was Successful!");
		} 
		catch(SQLException e) 
		{
			System.out.println("The Connection Failed!");
			e.printStackTrace();
		}
	}
}