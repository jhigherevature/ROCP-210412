package dao;

import java.util.List;

import model.Account;

public interface CustomerAccountDAO {
	boolean createCustomerAccount(int customerID, int accountID);

	List<Account> getPendingAccounts(int customerID);

	List<Account> getOpenAccounts(int customerID);
	
	boolean isCustomerAccount(int customerID, int accountID);
	
}
