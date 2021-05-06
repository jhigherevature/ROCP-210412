package dao;

import java.util.List;

import model.Transaction;

public interface TransactionDAO {
	List<Transaction> getTransanctionsByUser(int userID);
	
	double makeDepositByAccountID(int accountID, int userID, double amount);
	
	double makeWithdrawalByAccountID(int accountID, int userID, double amount);

	List<Transaction> getAllTransactions();
	
	//copy customer transaction methods for admins
}
