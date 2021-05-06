package dao;

import java.util.List;

import model.Account;

public interface AccountDAO {
	int createNewAccount();

	List<Account> getAllPendingAccounts();
	
	List<Account> getAllOpenAccounts();
	
	int approveAllPendingAccounts(int employeeID);

	boolean approvePendingAccountByID(int employeeID, int accountID);

	boolean checkIfAccount(int accountNum);

	double getAccountBalance(int accountNum);

}
