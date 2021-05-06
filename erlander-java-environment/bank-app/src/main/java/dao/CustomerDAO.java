package dao;

import java.util.List;

import model.Customer;
import model.User;

public interface CustomerDAO {
	public Customer getCustomerByUserID(int user_id);
	public Customer addNewCustomer(User user);
	public List<Customer> getAllCustomers();
}
