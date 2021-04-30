package javadataaccessobjects;

import customerlogin.CustomerLogin;
import customers.Customers;
import savingsaccounts.SavingsAccount;

public interface ReviewCustomerInformationDAO {
	
	
	public void reviewCustomerInformation(); 
	public Customers updateCustomerInformation(Integer id, Customers cust);
	public CustomerLogin updateLoginInformation(Integer id, CustomerLogin cl); 
	public SavingsAccount savingsTransaction(Integer id, SavingsAccount sa);
	public SavingsAccount updateSecondaryUser(Integer id, SavingsAccount sa);

}
