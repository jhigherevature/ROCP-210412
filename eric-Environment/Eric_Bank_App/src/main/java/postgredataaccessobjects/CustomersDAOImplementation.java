package postgredataaccessobjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connectionutility.ConnectionUtility;
import customerlogin.CustomerLogin;
import customers.Customers;

public class CustomersDAOImplementation implements CustomersDAO {
	
	Scanner input = new Scanner (System.in);
	
	String accessLevel;
	
	public CustomersDAOImplementation () {}
	
	public CustomersDAOImplementation (String accessLevel) {
		
		this.accessLevel = accessLevel;
		
	}

	@Override
	public boolean insertIntoCustomers(String firstName, String lastName, String username, String password) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
			String query = "INSERT INTO bank_template.customers VALUES (default,?,?)";
			ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			
			Customers c = null;
			CustomerLogin cl = null;
			
			
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			rs.next();
			
			c = new Customers(
				rs.getInt(1),
				firstName,
				lastName
				);
			
			cl = new CustomerLogin(
					c.getCustomerID(),
					username,
					password
					);
						
			query = "INSERT INTO bank_template.customer_login VALUES (?,?,?)";
			
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, cl.getLoginID());
			ps.setString(2, cl.getUsername());
			ps.setString(3, cl.getPassword());
			
			ps.executeUpdate();
			
			query = "INSERT INTO bank_template.savings_accounts VALUES (?, null, ?)";
			
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, cl.getLoginID());
			ps.setDouble(2, 0);
			
			ps.executeUpdate();
			
			
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public Customers selectCustomer(Integer id) {
				
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customers c = new Customers(); 
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
			String query = "SELECT * FROM bank_template.customers WHERE customer_id = ?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				c = new Customers(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3)
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return c;
		
	}

	@Override
	public List<Customers> selectAllCustomers() {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Customers> l = new ArrayList<Customers>();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "SELECT * FROM bank_template.customers";
		ps = conn.prepareStatement(query);
		
		rs = ps.executeQuery();
		while (rs.next()) {
			
			Customers c = new Customers(
					
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3)
					);
				
				// Add the new employee Object to our list
				l.add(c);
			
		}
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
		return l;	
		
	}

	@Override
	public Customers  updateCustomerFirstName(Integer id, Customers cust) {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the new first name: ");
		String firstName = input.nextLine();
				
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.customers SET customer_first_name = ? WHERE customer_id = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, firstName);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return cust;
		}
		
		cust.setCustomerFirstName(firstName);
		
		return cust;
		
	}

	@Override
	public Customers updateCustomerLastName(Integer id, Customers cust) {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the new last name: ");
		String lastName = input.nextLine();
				
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.customers SET customer_last_name = ? WHERE customer_id = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, lastName);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return cust;
		}
		
		cust.setCustomerLastName(lastName);
		
		return cust;
		
	}

	@Override
	public boolean deleteCustomer() {
		
		PreparedStatement ps = null;
		System.out.print("Enter the customer ID of the customer you wish to terminate: ");
		Integer id = input.nextInt();
		input.nextLine();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
			
			String query = "DELETE FROM bank_template.customer WHERE customer_id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.execute();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
}
