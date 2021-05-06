package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import utilities.ConnectionUtility;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public int createNewAccount() {
		PreparedStatement ps = null;
		ResultSet rs;
		int accountNumber = 0;

		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "INSERT INTO bank.accounts VALUES (DEFAULT,DEFAULT,NULL,DEFAULT,NULL,DEFAULT) RETURNING account_number";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();

			if (rs.next()) {
				accountNumber = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.print(accountNumber);
		return accountNumber;
	}

	@Override
	public List<Account> getAllPendingAccounts() {
		PreparedStatement ps = null;
		ResultSet rs;
		List<Account> pendingAccounts = new ArrayList<Account>();

		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "SELECT a.account_number, a.application_date FROM bank.accounts AS a WHERE a.approved = false";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {

				Account account = new Account();

				account.setAccountNumber(rs.getInt(1));
				account.setApplicationDate(rs.getDate(2));
				

				pendingAccounts.add(account);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pendingAccounts;
	}

	@Override
	public int approveAllPendingAccounts(int employeeID) {
		PreparedStatement ps = null;
		ResultSet rs;
		int count = 0;
		
		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "UPDATE bank.accounts SET approval_date = DEFAULT, approved_by = ?, approved = ? WHERE approved = false RETURNING approved";
			ps = conn.prepareStatement(query);
			ps.setInt(1, employeeID);
			ps.setBoolean(2, true);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				count++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;

	}
	
	
	@Override
	public boolean approvePendingAccountByID(int employeeID, int accountID) {
		PreparedStatement ps = null;
		ResultSet rs;
		boolean approved = false;
		
		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "UPDATE bank.accounts SET approval_date = DEFAULT, approved_by = ?, approved = ? WHERE account_number = ? RETURNING approved";
			ps = conn.prepareStatement(query);
			ps.setInt(1, employeeID);
			ps.setBoolean(2, true);
			ps.setInt(3, accountID);	
			
			rs = ps.executeQuery();
			if (rs.next()) {
				approved = rs.getBoolean(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return approved;
	}

	@Override
	public boolean checkIfAccount(int accountNum) {
		PreparedStatement ps = null;
		ResultSet rs;
		boolean isAccount = false;
		
		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "SELECT * FROM bank.accounts WHERE approved = false AND account_number = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, accountNum);	
			
			rs = ps.executeQuery();
			if (rs.next()) {
				isAccount = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isAccount;
	}

	@Override
	public List<Account> getAllOpenAccounts() {
		PreparedStatement ps = null;
		ResultSet rs;
		List<Account> openAccounts = new ArrayList<Account>();

		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "SELECT a.account_number, a.application_date, a.approval_date, a.approved_by, a.balance FROM bank.accounts AS a WHERE a.approved = true";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {

				Account account = new Account();

				account.setAccountNumber(rs.getInt(1));
				account.setApplicationDate(rs.getDate(2));
				account.setApprovalDate(rs.getDate(3));
				account.setApprovedByID(rs.getInt(4));
				account.setBalance(rs.getDouble(5));
				

				openAccounts.add(account);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return openAccounts;
	}
	
	
	@Override
	public double getAccountBalance(int accountNum) {
		PreparedStatement ps = null;
		ResultSet rs;
		double balance = 0;
		
		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "SELECT balance FROM bank.accounts WHERE account_number = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, accountNum);	
			
			rs = ps.executeQuery();
			while (rs.next()) {
				balance = rs.getDouble(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return balance;
	}

}
