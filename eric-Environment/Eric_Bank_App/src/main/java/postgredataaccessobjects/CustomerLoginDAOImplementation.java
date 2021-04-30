package postgredataaccessobjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connectionutility.ConnectionUtility;
import customerlogin.CustomerLogin;

public class CustomerLoginDAOImplementation implements CustomerLoginDAO {
	
	Scanner input = new Scanner(System.in);
	
	String accessLevel;
	
	public CustomerLoginDAOImplementation () {}
	
	public CustomerLoginDAOImplementation (String accessLevel) {
		
		this.accessLevel = accessLevel;
		
	}

	@Override
	public boolean insertIntoCustomerLogin() {
		
		System.out.print("Enter a username: ");
		String username = input.nextLine();
		System.out.print("Enter a password: ");
		String password = input.nextLine();
		
		PreparedStatement ps = null;
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
			String query = "INSERT INTO bank_template.customer_login VALUES (DEFAULT,?,?)";//not serialized in database, need to implement with insertintoCustomers
			ps = conn.prepareStatement(query);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}

	@Override
	public CustomerLogin selectCustomerLogin(Integer id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		CustomerLogin e = null;
		
		try(Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "SELECT * FROM bank_template.customer_login WHERE login_id = ?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		while (rs.next()) {
			e = new CustomerLogin(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3)
					);
		}
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
		return e;
		
	}

	@Override
	public List<CustomerLogin> selectAllCustomerLogin() {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CustomerLogin> l = new ArrayList<CustomerLogin>();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "SELECT * FROM bank_template.customer_login";
		ps = conn.prepareStatement(query);
		
		rs = ps.executeQuery();
		while (rs.next()) {
			
			CustomerLogin b = new CustomerLogin(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3)
					);
				
				l.add(b);
			
		}
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
		return l;
		
	}

	@Override
	public CustomerLogin updateUsername(Integer id, CustomerLogin cl) {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the new username: ");
		String username = input.nextLine();
				
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.customer_login SET login_username = ? WHERE login_id = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, username);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return cl;
		}
		
		cl.setUsername(username);
		
		return cl;
		
	}

	@Override
	public CustomerLogin updatePassword(Integer id, CustomerLogin cl) {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the new password: ");
		String password = input.nextLine();
				
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.customer_login SET login_password = ? WHERE login_id = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, password);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return cl;
		}
		
		cl.setPassword(password);
		
		return cl;
		
	}
	
	

}
