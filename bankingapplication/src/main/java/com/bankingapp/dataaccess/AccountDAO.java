package com.bankingapp.dataaccess;

import java.util.List;

import com.bankingapp.entities.Account;
import com.bankingapp.entities.AccountTransaction;
import com.bankingapp.entities.AccountType;
import com.bankingapp.entities.Customer;
import com.bankingapp.entities.TransactionType;

public interface AccountDAO {

	List<AccountType> getAllAccountTypes() throws DAOException;

	int getLastAcccountId() throws DAOException;

	void saveNewAccount(Account account, Customer... customers) throws DAOException;

	List<Account> findAccountsOfCustomer(Customer customer) throws DAOException;
	
	TransactionType getTransactionByName(String name) throws DAOException;

	void updateAccount(Account account) throws DAOException;
	
	void recordTransactions(List<AccountTransaction> transactions) throws DAOException;
	
	List<AccountTransaction> getAllTransactionByCustomer(Customer customer) throws DAOException;

	List<Account> findAllUnapprovedAccounts() throws DAOException;
	
	List<Account> findAllAccounts() throws DAOException;

	void deleteAccount(Account account) throws DAOException;
}