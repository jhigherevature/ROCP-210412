package javadataaccessobjects;

import java.util.Scanner;

import customerlogin.CustomerLogin;
import customers.Customers;
import postgredataaccessobjects.CustomerApplicationDAO;
import postgredataaccessobjects.CustomerApplicationDAOImplementation;
import postgredataaccessobjects.CustomerLoginDAO;
import postgredataaccessobjects.CustomerLoginDAOImplementation;
import postgredataaccessobjects.CustomersDAO;
import postgredataaccessobjects.CustomersDAOImplementation;
import postgredataaccessobjects.SavingsAccountDAO;
import postgredataaccessobjects.SavingsAccountDAOImplementation;
import savingsaccounts.SavingsAccount;

public class ReviewCustomerInformationDAOImplementation implements ReviewCustomerInformationDAO{
	
	Scanner input = new Scanner(System.in);
	
	String accessLevel;
	
	public ReviewCustomerInformationDAOImplementation() {}
	
	public ReviewCustomerInformationDAOImplementation(String accessLevel) {
		
		this.accessLevel = accessLevel;
		
	}
	
	CustomerApplicationDAO ca = new CustomerApplicationDAOImplementation("banker");
	CustomersDAO cDao = new CustomersDAOImplementation("banker");
	CustomerLoginDAO clDao= new CustomerLoginDAOImplementation("banker");
	SavingsAccountDAO sDao = new SavingsAccountDAOImplementation("banker");
	
public void reviewCustomerInformation() {
		
		System.out.print("Enter the customer ID for the account you wish to use: ");
		Integer id = input.nextInt();
		input.nextLine();
		
		rci:while(true) {
		
		Customers cust = cDao.selectCustomer(id);
		CustomerLogin cl = clDao.selectCustomerLogin(id);
		SavingsAccount sa = sDao.selectSavingsAccount(id);
		System.out.println(cust);
		System.out.println(cl);
		System.out.println(sa);
		
		System.out.println("1.Update customer information"
				+ "\n2.Update login information"
				+ "\n3.Withdraw/deposite into savings account"
				+ "\n4.Add/remove a secondary user savings account"
				+ "\n5.Exit");
			
		int num = input.nextInt();
		input.nextLine();
		
		switch (num) {
		
		case 1: cust = updateCustomerInformation(cust.getCustomerID(), cust);
		break;
			
		case 2: cl = updateLoginInformation(cust.getCustomerID(), cl);
		break;
			
		case 3: sa = savingsTransaction(cust.getCustomerID(), sa);
		break;
		
		case 4: sa = updateSecondaryUser(cust.getCustomerID(), sa);
		break;
		
		case 5:
		break rci;
		
		}
		
	}
		
	}
	
	public Customers updateCustomerInformation(Integer id, Customers cust) {
		
		System.out.println("1.Update first name"
				+ "\n2.Update last name"
				+ "\n3.Exit");
		
		Integer num = input.nextInt();
		input.nextLine();
		
		switch (num) {
		
		case 1: cust = cDao.updateCustomerFirstName(id, cust);
		return cust;
			
		case 2: cust = cDao.updateCustomerLastName(id, cust);
		return cust;
			
		case 3: 
		return cust;
		
		}
		
		return cust;
		
	}
	
	public CustomerLogin updateLoginInformation(Integer id, CustomerLogin cl) {
		
		System.out.println("1.Update username"
				+ "\n2.Update password"
				+ "\n3.Exit");
		
		int num = input.nextInt();
		input.nextLine();
		
		switch (num) {
		
		case 1: cl = clDao.updateUsername(id, cl);
		return cl;
			
		case 2: cl = clDao.updatePassword(id, cl);
		return cl;
			
		case 3: 
		return cl;
		
		}
		
		return cl;
		
	}
	
	public SavingsAccount savingsTransaction(Integer id, SavingsAccount sa) {
		
		System.out.println("1.Make a deposite/withdrawl"
				+ "\n2.Exit");
		
		Integer num = input.nextInt();
		input.nextLine();
		
		switch (num) {
		
		case 1: 
			
			if( sa.getSavingsID() == id ) {
				sa = sDao.updateSavingsPrimary(id, sa);
				return sa;
			}
			
			if (sa.getSecondaryID() == id) {
				sa = sDao.updateSavingsSecondary(id, sa);
				return sa;
			}
			
		return sa;
			
		case 2: 
			
		return sa;

		
		}
		
		return sa;
		
	}
	
	public SavingsAccount updateSecondaryUser(Integer id, SavingsAccount sa) {
		
		System.out.println("1.Add a secondary user"
				+ "\n2.Remove a secondary user"
				+ "\n2.Exit");
		
		Integer num = input.nextInt();
		input.nextLine();
		
		switch (num) {
		
		case 1: sa = sDao.updateSecondaryIDAsPrimary(id, sa);
			
		return sa;
			
		case 2: sa = sDao.removeSecondaryID(id, sa);
			
		return sa;
		
		case 3:
			
		return sa;

		
		}
		
		return sa;
		
	}
	
	
}
