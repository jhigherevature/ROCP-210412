package com.bankingapp.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bankingapp.dataaccess.AccountDAO;
import com.bankingapp.dataaccess.CustomerDAOImpl;
import com.bankingapp.dataaccess.DAOException;
import com.bankingapp.entities.*;

public class AccountServiceImpl implements AccountService {

	private AccountDAO accountDAO;
	private Logger logger = LogManager.getLogger(AccountServiceImpl.class);

	public AccountServiceImpl(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	@Override
	public Account createNewAccount(AccountType accountType, double balance, Customer... customers)
			throws BusinessException {
		Account account = null;

		try {
			account = createNewAccount();
			account.setAccountType(accountType);
			account.setAccountBalance(balance);

			accountDAO.saveNewAccount(account, customers);
			logger.debug("Account successfully created");

		} catch (DAOException e) {
			e.printStackTrace();
			logger.error("Faailed to create new account");
			throw new BusinessException("Failed to create new account", e);
		}
		return account;
	}

	private Account createNewAccount() throws DAOException {

		int lastAccountId = accountDAO.getLastAcccountId();
		int newAccountId = lastAccountId + 1;

		Account account = new Account();
		account.setAccountNumber("3000928" + newAccountId);

		return account;

	}

	@Override
	public List<AccountType> getAllAccountTypes() throws BusinessException {
		List<AccountType> accountTypes = null;

		try {
			accountTypes = accountDAO.getAllAccountTypes();
			logger.debug("All account types retrieved successfully");
		} catch (DAOException e) {
			e.printStackTrace();
			logger.error("Failed to retrieve all account types", e);
			throw new BusinessException("Failed to retrieve all account types", e);
		}
		return accountTypes;
	}

	@Override
	public void recordTransactions(Account sourceAccount, Account targetAccount, double amount,
			String transactionTypeName, Customer... customers) throws BusinessException {
		try {
			TransactionType transactionType = accountDAO.getTransactionByName(transactionTypeName);
			List<AccountTransaction> accountTransactions = new ArrayList<AccountTransaction>();

			logger.debug("Transactions recorded successfully");

			for (Customer customer : customers) {
				AccountTransaction transaction = new AccountTransaction();
				transaction.setAmount(amount);
				transaction.setCustomer(customer);
				transaction.setSourceAccount(sourceAccount);
				transaction.setTargetAccount(targetAccount);
				transaction.setTransactionType(transactionType);
				accountTransactions.add(transaction);
				logger.info(customer.getCustomerName() + " requested a " + transactionType.getTransactionTypeName()
						+ "on account " + targetAccount.getAccountNumber());
			}
			accountDAO.recordTransactions(accountTransactions);
		} catch (DAOException e) {
			e.printStackTrace();
			logger.error("failed to record transactions", e);
			throw new BusinessException("Failed to record transactions", e);
		}
	}

	@Override
	public TransactionType getTransactionTypeByName(String name) throws BusinessException {
		TransactionType transactionType = null;
		try {
			transactionType = accountDAO.getTransactionByName(name);
			logger.debug("Transactons successfully received");
		} catch (DAOException e) {
			e.printStackTrace();
			logger.error("failed to get transaction type", e);
			throw new BusinessException("Failed to get transaction type", e);
		}
		return transactionType;
	}

	@Override
	public List<Account> findAccountsOfCustomer(Customer customer) throws BusinessException {
		List<Account> accountList = null;
		try {
			accountList = accountDAO.findAccountsOfCustomer(customer);
			logger.debug("accounts of customer find successfully");
		} catch (DAOException e) {
			logger.error("failed to find accounts of customer", e);
			throw new BusinessException("Failed to find accounts of customer", e);
		}
		return accountList;
	}

	@Override
	public void depositMoney(Account account, Customer customer, double amount) throws BusinessException {

		double newBalance = account.getAccountBalance() + amount;

		account.setAccountBalance(newBalance);
		try {
			accountDAO.updateAccount(account);
			logger.debug("Money deposite successfully");
			recordTransactions(null, account, amount, "Deposit", customer);
		} catch (DAOException e) {
			logger.error("failed to deposit money");
			throw new BusinessException("Failed to deposit money", e);
		}
	}

	@Override
	public void withdrawMoney(Account account, Customer customer, double amount) throws BusinessException {

		double newBalance = account.getAccountBalance() - amount;

		if (newBalance >= 0) {
			account.setAccountBalance(newBalance);
			try {
				accountDAO.updateAccount(account);
				logger.debug("withdraw successful");
				recordTransactions(null, account, amount, "Deposit", customer);
			} catch (DAOException e) {
				logger.error("failed to withdraw money", e);
				throw new BusinessException("Failed to withdraw money", e);
			}
		}
	}

	@Override
	public void transferMoney(Account sourceAccount, Account targetAccount, Customer customer, double amount)
			throws BusinessException {
		try {
			double newSourceBalance = sourceAccount.getAccountBalance() - amount;
			logger.debug("Transfer made successfully");
			if (newSourceBalance >= 0) {
				sourceAccount.setAccountBalance(newSourceBalance);

				accountDAO.updateAccount(sourceAccount);

				double targetAccountBalance = targetAccount.getAccountBalance() + amount;
				targetAccount.setAccountBalance(targetAccountBalance);

				accountDAO.updateAccount(targetAccount);
				recordTransactions(sourceAccount, targetAccount, amount, "Transfer", customer);
			}
		} catch (DAOException e) {
			logger.error("failed to complete transfer", e);
			throw new BusinessException("Failed to complete transfer", e);
		}
	}

	@Override
	public void updateAccount(Account account) throws BusinessException {
		try {
			accountDAO.updateAccount(account);
			logger.debug("Account successfully updated");
		} catch (DAOException e) {
			logger.error("failed to update account", e);
			throw new BusinessException("Failed to update account", e);
		}
	}

	@Override
	public List<AccountTransaction> getAllTransactionByCustomer(Customer customer) throws BusinessException {
		List<AccountTransaction> transactions = null;
		try {
			transactions = accountDAO.getAllTransactionByCustomer(customer);
			logger.debug("tansactons made by customer reveiced");
		} catch (DAOException e) {
			logger.error("failed to get transactions by customer", e);
			throw new BusinessException("Failed to get transactions by customer", e);
		}
		return transactions;
	}

	@Override
	public List<Account> findAllUnapprovedAccounts() throws BusinessException {
		List<Account> accountList = null;
		try {
			accountList = accountDAO.findAllUnapprovedAccounts();
			logger.debug("Unapproved accounts find successfully");
		} catch (DAOException e) {
			e.printStackTrace();
			logger.error("failed to find unapproved accounts", e);
			throw new BusinessException("Failed to find unapproved accounts", e);
		}
		return accountList;
	}

	@Override
	public List<Account> findAllAccounts() throws BusinessException {
		List<Account> accountList = null;
		try {
			accountList = accountDAO.findAllAccounts();
			logger.debug("Accounts find succesfully");
		} catch (DAOException e) {
			logger.error("failed to find accounts");
			throw new BusinessException("Failed to find accounts", e);
		}
		return accountList;
	}

	@Override
	public void removeAccount(Account account) throws BusinessException {
		try {
			accountDAO.deleteAccount(account);
			logger.debug("Accounts deleted successfully");
		} catch (DAOException e) {
			logger.error("failed to delete accounts");
			throw new BusinessException("Failed to delete account", e);
		}
	}
}
