package initialization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectionutil.ConnectionUtility;

public class InitializeData {
	
	public void create() {
		System.out.println("Initizalizing data...");
		

		Statement stmt1 = null;
		Statement stmt2 = null;
		boolean initComplete = true;
		try (Connection conn1 = ConnectionUtility.getConnection()) {
			//* CREATE TABLE *//
			String query1 = "DROP TABLE IF EXISTS bank.customers;"
					+ "DROP SCHEMA IF EXISTS bank;"
					+ "CREATE SCHEMA bank;"
					+ "CREATE TABLE bank.customers"
					+ "(cust_id SERIAL UNIQUE PRIMARY KEY,"
					+ "cust_first varchar(220),"
					+ "cust_last varchar(220),"
					+ "cust_user varchar(220) UNIQUE,"
					+ "cust_pass varchar(220),"
					+ "cust_savacc DECIMAL,"
					+ "cust_checkacc DECIMAL,"
					+ "cust_joindate DATE,"
					+ "cust_logindate DATE);";
			
			stmt1 = conn1.createStatement();
			stmt1.execute(query1);
			System.out.println("Table created...");
			
			//* Populate TABLE *//
			String query2 = "INSERT INTO bank.customers VALUES"
					+ "(DEFAULT,'John','Doe',"
					+ "'jd2021','jdpwd123',"
					+ "12345.67,1234.56,"
					+ "'2015-10-22','2021-04-21'),"
					+ "(DEFAULT,'Wade','Smith',"
					+ "'ws2021','wspwd123',"
					+ "23456.78,2345.60,"
					+ "'2014-10-22','2021-04-01'),"
					+ "(DEFAULT,'Lily','Hester',"
					+ "'lh2021','lhpwd123',"
					+ "34567.80,3456.70,"
					+ "'2013-10-22','2021-03-21'),"
					+ "(DEFAULT,'Wanda','Rosas',"
					+ "'wr2021','wrpwd123',"
					+ "12312.80,4561.70,"
					+ "'2017-10-22','2020-11-30'),"
					+ "(DEFAULT,'Mark','Gonzales',"
					+ "'mg2021','mgpwd123',"
					+ "22222.00,1240.80,"
					+ "'2017-10-22','2020-11-30');";

			
			stmt2 = conn1.createStatement();
			stmt2.execute(query2);
			System.out.println("Table populated...");
			
		} catch (SQLException e) {
			initComplete = false;
			e.printStackTrace();
		}
		if (initComplete == true) {
			System.out.println("Initizalization complete");
		}
		else {
			System.out.println("Initizalization incomplete...");
		}

	}
	
	

}


