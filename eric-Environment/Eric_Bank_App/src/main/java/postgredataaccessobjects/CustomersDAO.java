package postgredataaccessobjects;


import java.util.List;

import customers.Customers;

public interface CustomersDAO {
	
	//to manipulate customer data
		public boolean insertIntoCustomers(String firstName, String lastName, String username, String password);
		public Customers selectCustomer(Integer id);
		public List<Customers> selectAllCustomers();
		public Customers updateCustomerFirstName(Integer id, Customers cust);
		public Customers updateCustomerLastName(Integer id, Customers cust);
		public boolean deleteCustomer();

}
