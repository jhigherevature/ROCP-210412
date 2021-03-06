package com.revature.connectionutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImpl;

public class ConnectionUtility {
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
		/*
		 * This Class.forName invocation is required for your server to know
		 * what driver to use. Maven (under the hood) has an infamous problem
		 * when working with servlets that causes certain drivers and SQL plugins
		 * to be shadowed by internal Maven plugins. This Class.forName() invocation
		 * causes your code to look specifically for the postgre driver that we
		 * want to use for this connection, instead of relying on Maven's
		 * default method for passing information to servlets.
		 */
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String user = "customers";
			String pass = "password";
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static EmployeeDAO getEmployeeDAO() {
		return new EmployeeDAOImpl();
	}
	
	public static LoginDAO getLoginDAO() {
		return new LoginDAOImpl();
	}
}
