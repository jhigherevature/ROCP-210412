package dataaccessobject;

import java.sql.*;

import connectionutil.ConnectionUtility;
import model.Customer;


public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public Double[] balanceCheck(Integer id) {
		System.out.println("\nRunning balanceCheck...");
		Double savings = null;
		Double checking = null;		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer cus = null;
		boolean balCheck = true;
		
		try(Connection conn = ConnectionUtility.getConnection()) {
			String query = "SELECT cust_savacc,cust_checkacc "
					+ "FROM bank.customers WHERE cust_id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				savings = rs.getDouble(1);
				checking = rs.getDouble(2);
			}


			System.out.println("Savings: " + savings);
			System.out.println("Checking: " + checking);
		} catch(SQLException e) {
			e.printStackTrace();
			balCheck = false;
		}
		System.out.println("balanceCheck complete");

		return new Double[] {savings, checking};
	}

	@Override
	public Double[] depositMoney(Integer id) {
		// Display Current Balances
		Double[] savCheck = balanceCheck(id);
		
		
		
		Double updatedSav = null;
		Double updatedCheck = null;
		System.out.println("\nRunning depositMoney...");
		// Ask how much they want to Deposit
		Double depAmt = 1.1;
		
		// Ask Which account to Deposit to
		int choice = 1;
		
		
		switch(choice) {
		
		//Savings
		case 1: {
			Double currentSav = savCheck[0];
			updatedSav = currentSav+depAmt;
			updatedCheck = savCheck[1];
			break;
		}
		//Checking
		case 2:{
			Double currentCheck = savCheck[1];
			updatedCheck = currentCheck + depAmt;
			updatedSav = savCheck[0];
			break;
		}
		//Invalid Input	
		default:
			depositMoney(id);
			break;
			
		}
		System.out.println("Savings: " + updatedSav);
		System.out.println("Checking: " + updatedCheck);
		
		// Commit final values to Database
		System.out.println("Updating database...");
		
		PreparedStatement ps = null;
		boolean rs = true;
		Customer cus = null;
		boolean depMon = true;
		
		try(Connection conn = ConnectionUtility.getConnection()) {
			String query = "UPDATE bank.customers "
					+ "SET cust_savacc = ?, cust_checkacc = ? "
					+ "WHERE cust_id = ?;";
			ps = conn.prepareStatement(query);
			ps.setDouble(1, updatedSav);
			ps.setDouble(2, updatedCheck);
			ps.setInt(3, id);
			
			rs = ps.execute();
		} catch(SQLException e) {
			e.printStackTrace();
			depMon = false;
		}
		System.out.println("Database updated...");

		
		
		System.out.println("depositMoney complete");
		return new Double[] {updatedSav, updatedCheck};
	}

	@Override
	public Double[] withdrawlMoney(Integer id) {
		
		return new Double[] {1.1,2.2};
	}

}
