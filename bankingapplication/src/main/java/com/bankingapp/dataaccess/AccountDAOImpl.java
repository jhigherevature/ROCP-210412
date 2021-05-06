package com.bankingapp.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bankingapp.entities.Account;
import com.bankingapp.entities.AccountTransaction;
import com.bankingapp.entities.AccountType;
import com.bankingapp.entities.Customer;
import com.bankingapp.entities.TransactionType;

public class AccountDAOImpl implements AccountDAO {

	private Logger logger = LogManager.getLogger(AccountDAOImpl.class);
	
	private Connection connection;
	
	public AccountDAOImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public List<AccountType> getAllAccountTypes() throws DAOException {

		List<AccountType> accountTypes = new ArrayList<AccountType>();

		try {

			String sql = "SELECT account_type_id, account_type_name,description FROM account_type";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet results = preparedStatement.executeQuery();
			

			logger.debug("Account type selescted");

			while (results.next()) {

				int accountTypeId = results.getInt(1);
				String accountTypeName = results.getString(2);
				String description = results.getString(3);

				AccountType accountType = new AccountType();

				accountType.setAccountTypeId(accountTypeId);
				accountType.setAccountTypeName(accountTypeName);
				accountType.setDescription(description);

				accountTypes.add(accountType);
			}

		} catch (SQLException e) {

			logger.error("Failed to get all account types",e);
			throw new DAOException("Failed to get all account types", e);
		}
		return accountTypes;
	}

	@Override
	public int getLastAcccountId() throws DAOException {
		int lastAccountId = 0;
		try {

			String sql = "SELECT  max(account_id) FROM account";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet results = preparedStatement.executeQuery();

			logger.debug("Account Id selected successfully");
			
			if (results.next())
				lastAccountId = results.getInt(1);

		} catch (SQLException e) {

			logger.error("Failed to get account Id ,e");
			throw new DAOException("Failed to get accountId", e);
		}
		return lastAccountId;
	}

	@Override
	public void saveNewAccount(Account account, Customer... customers) throws DAOException {

		try {

			String sql = "INSERT INTO account (account_number,account_balance,account_type_id) VALUES (?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, account.getAccountNumber());
			preparedStatement.setDouble(2, account.getAccountBalance());
			preparedStatement.setInt(3, account.getAccountType().getAccountTypeId());

			preparedStatement.executeUpdate();

			logger.debug("Inserting account information successfully");

			sql = "SELECT account_id FROM account WHERE account_number = ?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, account.getAccountNumber());

			ResultSet results = preparedStatement.executeQuery();
			results.next();
			int accountId = results.getInt(1);
			account.setAccountId(accountId);

			logger.debug("Account number location from account Id selected successfully");

			sql = "INSERT INTO account_customer(account_id,customer_id) VALUES (?,?)";

			for (Customer customer : customers) {
				if (customer != null) {
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, accountId);
					preparedStatement.setInt(2, customer.getCustomerId());
					preparedStatement.executeUpdate();
				}
			}

			logger.debug("Account customer Ids successfully inserted");

		} catch (SQLException e) {

			logger.error("Failed to save account",e);
			throw new DAOException("Failed to save new account", e);
		}
	}

	@Override
	public List<Account> findAccountsOfCustomer(Customer customer) throws DAOException {

		List<Account> customerAccounts = new ArrayList<Account>();
		try {
			String sql = "SELECT account.account_id,account_number,account_balance, account_status FROM account JOIN account_customer ON account.account_id =account_customer.account_id JOIN customer ON account_customer.customer_id =customer.customer_id WHERE customer.customer_id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer.getCustomerId());

			ResultSet results = preparedStatement.executeQuery();
			

			logger.debug("Joining account information and account customer and customer successfully");

			while (results.next()) {

				int accountId = results.getInt(1);
				String accountNumber = results.getString(2);
				double accountBalance = results.getDouble(3);
				String status = results.getString(4);

				Account account = new Account();

				account.setAccountId(accountId);
				account.setAccountNumber(accountNumber);
				account.setAccountBalance(accountBalance);
				account.setStatus(status);

				customerAccounts.add(account);
			}

		} catch (SQLException e) {

			logger.error("Failed to find accounts of customer",e);
			throw new DAOException("Failed to find accounts of customer", e);
		}

		return customerAccounts;
	}

	@Override
	public void updateAccount(Account account) throws DAOException {
		try {

			String sql = "UPDATE account SET account_balance=?,account_status=? WHERE account_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, account.getAccountBalance());
			preparedStatement.setString(2, account.getStatus());
			preparedStatement.setInt(3, account.getAccountId());

			preparedStatement.executeUpdate();
			

			logger.debug("updating account successfully");

		} catch (SQLException e) {
			e.printStackTrace();

			logger.debug("Failed to update account",e);
			throw new DAOException("Failed to update account", e);
		}
	}

	@Override
	public void recordTransactions(List<AccountTransaction> transactions) throws DAOException {
		try {
			String sql = "INSERT INTO account_transaction (amount, customer_id, transaction_type_id, source_account_id, target_account_id) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			for (AccountTransaction transaction : transactions) {

				preparedStatement.setDouble(1, transaction.getAmount());
				Integer customerId = transaction.getCustomer() != null ? transaction.getCustomer().getCustomerId()
						: null;
				preparedStatement.setObject(2, customerId);
				preparedStatement.setDouble(3, transaction.getTransactionType().getTransactionTypeId());
				
				preparedStatement.setObject(4,
						transaction.getSourceAccount() != null ? transaction.getSourceAccount().getAccountId() : null);
				preparedStatement.setDouble(5, transaction.getTargetAccount().getAccountId());
				preparedStatement.executeUpdate();
			}
			

			logger.debug("Record transaction inserted successfully");

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Failed to record transaction",e);
			throw new DAOException("Failed to record transaction", e);
		}
	}

	@Override
	public TransactionType getTransactionByName(String name) throws DAOException {
		TransactionType transactionType = null;
		try {

			String sql = "SELECT transaction_type_id, transaction_type_name FROM transaction_type WHERE transaction_type_name=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);

			ResultSet results = preparedStatement.executeQuery();
			
			logger.debug("Transaction types successfully recevied");
			
			if (results.next()) {

				int transactionTypeId = results.getInt(1);
				String transactionTypeName = results.getString(2);

				transactionType = new TransactionType();

				transactionType.setTransactionTypeId(transactionTypeId);
				transactionType.setTransactonTypeName(transactionTypeName);
			}

		} catch (SQLException e) {
			logger.error("Failed to get all transaction types",e);
			throw new DAOException("Failed to get all transaction types", e);
		}
		return transactionType;
	}

	@Override
	public List<AccountTransaction> getAllTransactionByCustomer(Customer customer) throws DAOException {
		List<AccountTransaction> transactions = new ArrayList<AccountTransaction>();
		try {

			String sql = "SELECT a.account_number, amount, transaction_type_name, transaction_date FROM account_transaction JOIN customer ON customer.customer_id = account_transaction.customer_id JOIN account a ON a.account_id = account_transaction.target_account_id JOIN transaction_type ON account_transaction.transaction_type_id = transaction_type.transaction_type_id  WHERE customer.customer_id =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customer.getCustomerId());
			ResultSet results = preparedStatement.executeQuery();
			
			logger.debug("Customer transaction typessuccessfully recevied");

			while (results.next()) {
				AccountTransaction accountTransaction = new AccountTransaction();
				TransactionType transactionType = new TransactionType();
				transactionType.setTransactonTypeName(results.getString(3));
				accountTransaction.setTransactionType(transactionType);
				accountTransaction.setAmount(results.getDouble(2));
				Account account = new Account();
				account.setAccountNumber(results.getString(1));
				accountTransaction.setTargetAccount(account);
				accountTransaction
						.setDate(results.getTimestamp(4).toLocalDateTime());
				transactions.add(accountTransaction);
			}
		} catch (SQLException e) {
			logger.error("Failed to get transaction by customer",e);
			throw new DAOException("Failed to get all transactions by customer", e);
		}
		return transactions;
	}

	@Override
	public List<Account> findAllUnapprovedAccounts() throws DAOException {

		List<Account> customerAccounts = new ArrayList<Account>();
		try {

			String sql = "SELECT account_id, account_number, account_balance FROM account WHERE account_status=?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "pending");

			ResultSet results = preparedStatement.executeQuery();
			logger.debug("Account status ssuccessfully pending");

			while (results.next()) {

				int accountId = results.getInt(1);
				String accountNumber = results.getString(2);
				double accountBalance = results.getDouble(3);

				Account account = new Account();

				account.setAccountId(accountId);
				account.setAccountNumber(accountNumber);
				account.setAccountBalance(accountBalance);

				customerAccounts.add(account);
			}

		} catch (SQLException e) {
			logger.error("Failed to find unpproved accounts",e);
			throw new DAOException("Failed to find unapproved accounts", e);
		}

		return customerAccounts;
	}

	@Override
	public List<Account> findAllAccounts() throws DAOException {
		List<Account> accounts = new ArrayList<Account>();
		try {

			String sql = "SELECT a.account_id, account_number, act.account_type_name, account_balance, account_status FROM account AS a JOIN account_type AS act ON a.account_type_id = act.account_type_id";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet results = preparedStatement.executeQuery();
			logger.debug("Acconts successfully find");

			while (results.next()) {

				int accountId = results.getInt(1);
				String accountNumber = results.getString(2);
				String accountTypeName = results.getString(3);
				double accountBalance = results.getDouble(4);
				String status = results.getString(5);

				AccountType accountType = new AccountType();
				accountType.setAccountTypeName(accountTypeName);

				Account account = new Account();

				account.setAccountId(accountId);
				account.setAccountNumber(accountNumber);
				account.setAccountBalance(accountBalance);
				account.setStatus(status);
				account.setAccountType(accountType);

				accounts.add(account);
			}

		} catch (SQLException e) {
			logger.error("Failed to find accounts");
			throw new DAOException("Failed to find accounts", e);
		}

		return accounts;
	}

	@Override
	public void deleteAccount(Account account) throws DAOException {
		try {
			List<String> queries = new ArrayList<String>();
			queries.add("DELETE FROM account_transaction WHERE source_account_id = ?");
			queries.add("DELETE FROM account_transaction WHERE target_account_id = ?");
			queries.add("DELETE FROM account_customer WHERE account_id = ?");
			queries.add("DELETE FROM account WHERE account_id = ?");

			for (String query : queries) {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, account.getAccountId());
				preparedStatement.executeUpdate();
				
				logger.debug("Account deleted successfully");
			}

		} catch (SQLException e) {
			logger.error("Failed to delete account",e);
			throw new DAOException("Failed to delete account", e);
		}
	}
}
