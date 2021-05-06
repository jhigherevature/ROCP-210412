package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import dataaccessobject.userDAOImpl;

public class bank {
	private userDAOImpl database = new userDAOImpl();
	public boolean createEmployeeUsernamePassword(String newUsername, String newPassword, String title) {
		return database.createEmployeeUsernamePassword(newUsername,newPassword,title);
	}
	
	public int checkLoginInformation(String username, String password) {
		return database.getAccountUsingLogin(username, password);
	}
	public String checkEmpLoginInformation(String username, String password) {
		return database.getEmpAccountUsingLogin(username, password);
	}
	public int openAccount(int userID, AccountType accountType, double balance) {
		return database.addAccount(userID, accountType, balance);
	}
	
	public Customer getApprovedCustomer(int userID) {
		return database.getApprovedAccount(userID);
	}
	public Customer getUnApprovedCustomer(int userID) {
		return database.getUnapprovedAccount(userID);
	}
	public Customer getAllUnApprovedAccounts() {
		return database.getAllUnApprovedAccount();
	}
	public CustomerList getAllAccounts() {
		return database.getAllAccounts();
	}
	public Customer getJointAccounts(int userID) {
		return database.getJointAccounts(userID);
	}
	public int checkSAHExists(int accountID) {
		return database.checkSAHExists(accountID);
	}
	public EmployeeList getEmployee(int empID) {
		return database.getEmployee(empID);
	}
	public EmployeeList getAllEmployees() {
		return database.getAllEmployees();
	}
	public boolean updateFirstName(int userID, String firstName) {
		return database.updateFirstName(userID, firstName);
	}
	
	public boolean updateLastName(int userID, String lastName) {
		return database.updateLastName(userID, lastName);
	}
	
	public boolean updateAddress(int userID, String address) {
		return database.updateAddress(userID, address);
	}
	
	public boolean updateUsernamePassword(int userID, String newUsername, String newPassword) {
		return database.updateUsernamePassword(userID, newUsername, newPassword);
	}
	public boolean updateEmployeeUsernamePassword(int empID, String newUsername, String newPassword) {
		return database.updateEmployeeUsernamePassword(empID,newUsername,newPassword);
	}
	public boolean updateEmployeeTitle(int empID, String title) {
		return database.updateEmployeeTitle(empID, title);
	}
	public boolean updateJointAccount(int userID, int AccountID) {
		return database.updateJointAccount(AccountID, userID);
	}
	
	public boolean acceptApproval(int AccountID) {
		return database.acceptApproval(AccountID);
	}
	
	boolean closeAccount(int accountID) {
		return database.deleteAccount(accountID);
	}
	
	
    public double roundDouble(double d, int places) {
 
        BigDecimal bigDecimal = new BigDecimal(Double.toString(d));
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
	
	
	public void withdrawl(int accountID, AccountType accountType, double balance, double withdrawlAmount) {
		if (accountType.equals(AccountType.Savings)) {
			double interestRate = checkInterest(balance, - withdrawlAmount);
			System.out.println("Current Savings Account Interest Rate: " + interestRate*100 + "%");
			System.out.println("You will receive $" + roundDouble((balance - withdrawlAmount)*interestRate,2) + " on the first of the next month");
			if (balance - withdrawlAmount < 50) {
				System.out.println("\n*******************WARNING***MESSAGE*******************");
				System.out.println("   Your Savings Account balance has fallen below the");
				System.out.println("required amount. If your Savings Account balance is not");
				System.out.println("above $50 by the end of this month, you will be charged");
				System.out.println("      a fee of $5 on the first of the next month.");
				System.out.println("*******************************************************");
			}
		}
		if (accountType.equals(AccountType.Checking)) {
			
			if (balance - withdrawlAmount < 100) {
				System.out.println("\n*******************WARNING***MESSAGE*******************");
				System.out.println("   Your Checking Account balance has fallen below the");
				System.out.println("required amount. If your Checking Account balance is not");
				System.out.println("above $100 by the end of the month, you will be charged");
				System.out.println("      a fee of $5 on the first of the next month.");
				System.out.println("*******************************************************");
			}
		}
		double newBalance = roundDouble(balance - withdrawlAmount,2);
		database.updateAccount(accountID, newBalance);
		
	}
	
	public void deposit(int accountID, AccountType accountType, double balance, double depositAmount) {
		if (accountType.equals(AccountType.Savings)) {
			double interestRate = checkInterest(balance, depositAmount);
			System.out.println("Current Savings Account Interest Rate: " + interestRate*100 + "%");
			System.out.println("You will receive $" + roundDouble((balance + depositAmount)*interestRate,2) + " on the first of the next month");
		}
		double newBalance = roundDouble(balance + depositAmount,2);	
		database.updateAccount(accountID, newBalance);
		
	}

	private double checkInterest(double balance, double amount) {
		double interest = 0;
		if((balance + amount) > 10000) {
			interest = 0.0005;
		} else {
			interest = 0.0002;
		}
		
		return interest;
		
		
	}


	
	public int newCustomer(String firstname, String lastname, String ssn, String address, String username, String password) {
		return database.addLogin(firstname, lastname, ssn, address, username, password);
		
	}


	public boolean ssnCheck(String ssn) {
		return database.ssnCheck(ssn);
	}


	public boolean usernameCheck(String username) {
		return database.usernameCheck(username);
	}

	public boolean UserExists(int UserID) {
		return database.userExists(UserID);
		
	}
	
	public boolean deleteUser(int userID) {
		return database.deleteUser(userID);
	}
	public boolean deleteEmployee(int empID) {
		return database.deleteEmployee(empID);
	}
	public boolean employeeUsernameCheck(String newUsername) {
		return database.employeeUsernameCheck(newUsername);
	}
}
