package utilities;

import dao.AccountDAO;
import dao.AccountDAOImpl;
import dao.CustomerAccountDAO;
import dao.CustomerAccountDAOImpl;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import dao.TransactionDAO;
import dao.TransactionDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;

public class DAOUtility {
	public static UserDAO getUserDAO() {
		return new UserDAOImpl();
	}
	
	public static CustomerDAO getCustomerDAO() {
		return new CustomerDAOImpl();
	}
	
	public static EmployeeDAO getEmployeeDAO() {
		return new EmployeeDAOImpl();
	}
	
	public static AccountDAO getAccountDAO() {
		return new AccountDAOImpl();
	}
	
	public static CustomerAccountDAO getCustomerAccountDAO() {
		return new CustomerAccountDAOImpl();
	}
	
	public static TransactionDAO getTransactionDAO() {
		return new TransactionDAOImpl();
	}
}
