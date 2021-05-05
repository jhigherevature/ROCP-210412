package com.bankingapp.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseConnector {
	private static Logger logger = LogManager.getLogger(DatabaseConnector.class);
	
	private static Connection connection = null;
	
	public static Connection getConnection() throws SQLException {
		
		if(connection == null) {
			String url = "jdbc:postgresql://localhost:5432/bankingappdb";
			String user = "postgres";
			String password = "2828";
			connection = DriverManager.getConnection(url, user, password);
			connection.setSchema("bankingappdb");
			logger.debug("Creating connection to postgres");
		}
		
		return connection;
	}
}
