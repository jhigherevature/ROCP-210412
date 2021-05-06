package dataaccessobject;

import model.AccountType;
import model.Customer;
import model.CustomerList;
import model.EmployeeList;

public interface userDAO {
	
	//* CRUD OPERATIONS*//
	// Create
	public int addLogin(String firstname, String lastname, String ssn, String address, String username, String password);
	public int addAccount(int userID, AccountType accountType, Double balance);
	public boolean createEmployeeUsernamePassword(String newUsername, String newPassword, String title);
	// Read
	public boolean ssnCheck(String ssn);
	public boolean userExists(int userID);
	public boolean usernameCheck(String username);
	public boolean employeeUsernameCheck(String username);
	public Customer getApprovedAccount(int userID);
	public Customer getAllUnApprovedAccount();
	public CustomerList getAllAccounts();
	public Customer getUnapprovedAccount(int userID);
	public Customer getJointAccounts(int UserID);
	public int checkSAHExists(int accountID);
	public int getAccountUsingLogin(String username, String password);
	public String getEmpAccountUsingLogin(String username, String password);
	public EmployeeList getEmployee(int empID);
	public EmployeeList getAllEmployees();
	// Update
	public boolean updateAccount(int accountID, double balance);
	public boolean updateFirstName(int userID, String updatedFirstName);
	public boolean updateLastName(int userID, String updatedLastName);
	public boolean updateAddress(int userID, String updatedAddress);
	public boolean updateUsernamePassword(int userID, String newUsername, String newPassword);
	public boolean updateEmployeeUsernamePassword(int empID, String newUsername, String newPassword);
	public boolean updateEmployeeTitle(int empID, String title);
	public boolean acceptApproval(int accountID);
	public boolean denyApproval(int accountID);
	public boolean updateJointAccount(int accountID, int userID);
	// Delete
	public boolean deleteAccount(int accountID);
	public boolean deleteUser(int userID);
	public boolean deleteEmployee(int empID);
	
		
}
