package com.bankingapp.business;

import java.util.List;

import com.bankingapp.entities.*;

public interface AccountService {
	Account createNewAccount(AccountType accountType, double balance, Customer...customers) throws BusinessException;
	
	List<AccountType> getAllAccountTypes() throws BusinessException;
	
	void recordTransactions(Account sourceAccount, Account targetAccount, double amount,
			String transactionTypeName, Customer... customers) throws BusinessException;
	
	List<Account> findAccountsOfCustomer(Customer customer) throws BusinessException;
	
	List<Account> findAllUnapprovedAccounts() throws BusinessException;
	
	List<Account> findAllAccounts() throws BusinessException;
	
	void updateAccount(Account account) throws BusinessException;
	
	List<AccountTransaction> getAllTransactionByCustomer(Customer customer) throws BusinessException;

	void depositMoney(Account account, Customer customer, double amount) throws BusinessException;

	void withdrawMoney(Account account, Customer customer, double amount) throws BusinessException;

	void transferMoney(Account sourceAccount, Account targetAccount, Customer customer, double amount)
			throws BusinessException;

	void removeAccount(Account account) throws BusinessException;
	
}
