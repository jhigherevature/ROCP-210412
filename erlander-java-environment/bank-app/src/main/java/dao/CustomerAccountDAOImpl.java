package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import utilities.ConnectionUtility;

public class CustomerAccountDAOImpl implements CustomerAccountDAO {

	@Override
	public boolean createCustomerAccount(int customerID, int accountID) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "INSERT INTO bank.user_accounts VALUES (?,?,DEFAULT) RETURNING account_number";
			ps = conn.prepareStatement(query);

			ps.setInt(1, customerID);
			ps.setInt(2, accountID);

			rs = ps.executeQuery();

			if (rs.next() != false) {
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return false;
	}

	@Override
	public List<Account> getPendingAccounts(int customerID) {
		List<Account> results = new ArrayList<Account>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "Select a.account_number, application_date FROM bank.user_accounts AS u LEFT JOIN bank.accounts AS a ON u.account_number = a.account_number WHERE u.customer_id = ? AND a.approved = false";
			ps = conn.prepareStatement(query);

			ps.setInt(1, customerID);

			rs = ps.executeQuery();

			while (rs.next()) {
				Account account = new Account();
				
				account.setAccountNumber(rs.getInt(1));
				account.setApplicationDate(rs.getDate(2));
				
				results.add(account);
			}
			
			
			return results;

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return null;
	}
	
	@Override
	public List<Account> getOpenAccounts(int customerID) {
		List<Account> results = new ArrayList<Account>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "Select a.account_number, a.balance FROM bank.user_accounts AS u LEFT JOIN bank.accounts AS a ON u.account_number = a.account_number WHERE u.customer_id = ? AND a.approved = true";
			ps = conn.prepareStatement(query);

			ps.setInt(1, customerID);

			rs = ps.executeQuery();

			while (rs.next()) {
				Account account = new Account();
				
				account.setAccountNumber(rs.getInt(1));
				account.setBalance(rs.getDouble(2));
				
				results.add(account);
			}	

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
		return results;
	}

	@Override
	public boolean isCustomerAccount(int customerID, int accountID) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "SELECT * FROM bank.user_accounts WHERE customer_id = ? AND account_number = ?";
			ps = conn.prepareStatement(query);

			ps.setInt(1, customerID);
			ps.setInt(2, accountID);

			rs = ps.executeQuery();

			if (rs.next() != false) {
				return true;
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
		return false;
	}

}
