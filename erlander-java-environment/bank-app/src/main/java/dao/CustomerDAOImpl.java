package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.User;
import utilities.ConnectionUtility;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public Customer getCustomerByUserID(int user_id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer customer = null;

		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "SELECT u.user_id, user_first_name, user_last_name, username, userpassword, customer_id FROM bank.customers AS c LEFT JOIN bank.users AS u ON c.user_id = u.user_id WHERE c.user_id = ?";
			ps = conn.prepareStatement(query);

			ps.setInt(1, user_id);

			rs = ps.executeQuery();

			if (rs.next() != false) {

				customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6));

			} else {
				return null;
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return customer;
	}

	@Override
	public Customer addNewCustomer(User user) {
		PreparedStatement ps = null;
		ResultSet rs;
		Customer customer = null;

		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "INSERT INTO bank.customers VALUES (DEFAULT,?) RETURNING customer_id";
			ps = conn.prepareStatement(query);
			ps.setInt(1, user.getUserID());

			rs = ps.executeQuery();

			if (rs.next()) {
				customer = new Customer(user.getUserID(), user.getFirstName(), user.getLastName(), user.getUsername(),
						user.getPassword(), rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs;

		try (Connection conn = ConnectionUtility.getConnection()){
				
			String query = "SELECT u.user_id, u.user_first_name, u.user_last_name, u.username, u.userpassword, c.customer_id FROM bank.customers AS c LEFT JOIN bank.users AS u ON u.user_id = c.user_id";			
			ps = conn.prepareStatement(query);	
			
			rs = ps.executeQuery();			

			
			while (rs.next()) {
				
				Customer customer = new Customer();

				customer.setUserID(rs.getInt(1));
				customer.setFirstName(rs.getString(2));
				customer.setLastName(rs.getString(3));
				customer.setUsername(rs.getString(4));
				customer.setPassword(rs.getString(5));
				customer.setCustomerID(rs.getInt(6));

				customers.add(customer);
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
		return customers;
	}
}
