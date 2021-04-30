package postgredataaccessobjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connectionutility.ConnectionUtility;
import customerapplication.CustomerApplication;

public class CustomerApplicationDAOImplementation implements CustomerApplicationDAO {

	Scanner input = new Scanner(System.in);
	
	String accessLevel;
	
	public CustomerApplicationDAOImplementation (String accessLevel) {
		
		this.accessLevel = accessLevel;
		
	}
	
	@Override
	public boolean insertIntoCustomerApplication() {
		
		System.out.print("You are applying for a new account with Not US bank."
				+ "\nPlease enter your first name: ");
		String firstName = input.nextLine();
		System.out.print("Last name: ");
		String lastName = input.nextLine();
		System.out.print("Desired username: ");
		String username = input.nextLine();
		System.out.print("password: ");
		String password = input.nextLine();
		
		
		PreparedStatement ps = null;
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
			String query = "INSERT INTO bank_template.customer_application VALUES (default,?,?,?,?);";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, username);
			ps.setString(4, password);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		System.out.println("Thank you for your application. A Not US Bank employee will be in contact soon.");
		return true;
		
	}

	@Override
	public CustomerApplication selectCustomerApplication(Integer id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		CustomerApplication ca = null;

		try(Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "SELECT * FROM bank_template.customer_application WHERE customer_application_id = ?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		while (rs.next()) {
			ca = new CustomerApplication(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5)
					);
		}
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
		return ca;
	}

	@Override
	public List<CustomerApplication> selectAllCustomerApplication() {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CustomerApplication> l = new ArrayList<CustomerApplication>();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "SELECT * FROM bank_template.customer_application";
		ps = conn.prepareStatement(query);
		
		rs = ps.executeQuery();
		while (rs.next()) {
			
			CustomerApplication ca = new CustomerApplication(
					
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5)
					);
				
				// Add the new employee Object to our list
				l.add(ca);
			
		}
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
		return l;	
		
	}

	@Override
	public boolean updateCustomerApplicationFirstName() {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the ID of the applicant whose first name you are changing: ");
		Integer id = input.nextInt();
		input.nextLine();
		System.out.print("Enter the new first name: ");
		String firstName = input.nextLine();
				
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.customer_application SET customer_first_name = ? WHERE customer_application_id = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, firstName);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		
		return true;
		
	}

	@Override
	public boolean updateCustomerApplicationLastName() {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the ID of the applicant whose last name you are changing: ");
		Integer id = input.nextInt();
		input.nextLine();
		System.out.print("Enter the new last name: ");
		String lastName = input.nextLine();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.customer_application SET customer_last_name = ? WHERE customer_application_id = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, lastName);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		
		return true;
		
	}

	@Override
	public boolean updateCustomerApplicationUsername() {

		PreparedStatement ps = null;
		
		System.out.print("Enter the ID of the applicant whose username you are changing: ");
		Integer id = input.nextInt();
		input.nextLine();
		System.out.print("Enter the new username: ");
		String username = input.nextLine();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.customer_application SET customer_username = ? WHERE customer_application_id = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, username);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public boolean updateCustomerApplicationPassword() {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the ID of the applicant whose password you are changing: ");
		Integer id = input.nextInt();
		input.nextLine();
		System.out.print("Enter the new password: ");
		String password = input.nextLine();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.customer_application SET customer_password = ? WHERE customer_application_id = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, password);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		
		return true;
		
	}

	@Override
	public boolean deleteCustomerApplication(Integer id) {
		
		PreparedStatement ps = null;
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "DELETE FROM bank_template.customer_application WHERE customer_application_id = ?";
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
