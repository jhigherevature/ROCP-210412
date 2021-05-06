package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Transaction;
import utilities.ConnectionUtility;
import utilities.DAOUtility;

public class TransactionDAOImpl implements TransactionDAO{
	
	
	@Override
	public List<Transaction> getAllTransactions() {
		List<Transaction> results = new ArrayList<Transaction>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try (Connection conn = ConnectionUtility.getConnection()) {
			
			String query = "Select t.account_number, t.user_id, t.transaction_type, t.amount, t.transaction_time, t.transaction_id FROM bank.transactions AS t";
			ps = conn.prepareStatement(query);


			rs = ps.executeQuery();

			while (rs.next()) {
				Transaction transaction = new Transaction();
				
				transaction.setAccountID(rs.getInt(1));
				transaction.setUserID(rs.getInt(2));
				transaction.setTransactionType(rs.getString(3));
				transaction.setAmount(rs.getDouble(4));
				transaction.setTimestamp(rs.getTimestamp(5));
				transaction.setTransactionID(rs.getInt(6));
				
				results.add(transaction);
			}
			
			
			return results;

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
		return null;
		
	}

	@Override
	public List<Transaction> getTransanctionsByUser(int userID) {
		List<Transaction> results = new ArrayList<Transaction>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try (Connection conn = ConnectionUtility.getConnection()) {
			
			String query = "Select t.account_number, t.transaction_type, t.amount, t.transaction_time, t.transaction_id FROM bank.transactions AS t WHERE t.user_id = ?";
			ps = conn.prepareStatement(query);

			ps.setInt(1, userID);

			rs = ps.executeQuery();

			while (rs.next()) {
				Transaction transaction = new Transaction();
				
				transaction.setAccountID(rs.getInt(1));
				transaction.setTransactionType(rs.getString(2));
				transaction.setAmount(rs.getDouble(3));
				transaction.setTimestamp(rs.getTimestamp(4));
				transaction.setTransactionID(rs.getInt(5));
				
				results.add(transaction);
			}
			
			
			return results;

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
		return null;
		
	}

	@Override
	public double makeDepositByAccountID(int accountID, int userID, double amount) {
		AccountDAO adao = DAOUtility.getAccountDAO();
		PreparedStatement ps = null;
		double oldBalance;
		double newBalance;
		
		oldBalance = adao.getAccountBalance(accountID);
		newBalance = oldBalance + amount;

		try (Connection conn = ConnectionUtility.getConnection()) {
			
			String query = "INSERT INTO bank.transactions VALUES (DEFAULT, ?, ?, ?, DEFAULT, ?)";
			ps = conn.prepareStatement(query);

			ps.setInt(1, userID);
			ps.setString(2, "deposit");
			ps.setDouble(3, amount);
			ps.setInt(4, accountID);

			ps.executeUpdate();

			

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
		return newBalance;
		
	}

	@Override
	public double makeWithdrawalByAccountID(int accountID, int userID, double amount) {
		AccountDAO adao = DAOUtility.getAccountDAO();
		PreparedStatement ps = null;
		double oldBalance;
		double newBalance;
		
		oldBalance = adao.getAccountBalance(accountID);
		newBalance = oldBalance + amount;

		try (Connection conn = ConnectionUtility.getConnection()) {
			
			String query = "INSERT INTO bank.transactions VALUES (DEFAULT, ?, ?, ?, DEFAULT, ?)";
			ps = conn.prepareStatement(query);

			ps.setInt(1, userID);
			ps.setString(2, "withdrawal");
			ps.setDouble(3, amount);
			ps.setInt(4, accountID);

			ps.executeUpdate();

			

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
		return newBalance;
	}

}
