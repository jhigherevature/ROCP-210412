package postgredataaccessobjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connectionutility.ConnectionUtility;
import customers.Customers;
import savingsaccounts.SavingsAccount;

public class SavingsAccountDAOImplementation implements SavingsAccountDAO {
	
	Scanner input = new Scanner(System.in);
	
	String accessLevel;
	
	public SavingsAccountDAOImplementation () {}
	
	public SavingsAccountDAOImplementation (String accessLevel) {
		
		this.accessLevel = accessLevel;
		
	}
	
	public boolean insertIntoSavingsAccounts() {
		
		System.out.println("You are creating a new Savings Account.\nYour starting account balance is $0.\nThank you for choosing Not US Bank.");
				
		PreparedStatement ps = null;
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
			String query = "INSERT INTO bank_template.savings_accounts VALUES (DEFAULT, 0)";
			ps = conn.prepareStatement(query);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}

	@Override
	public SavingsAccount selectSavingsAccount(Integer id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		SavingsAccount sa = null;
		
		try(Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "SELECT * FROM bank_template.savings_accounts WHERE savings_id = ?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		while (rs.next()) {
			sa = new SavingsAccount(
					rs.getInt(1),
					rs.getInt(2),
					rs.getDouble(3)
					);
		}
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
		return sa;
		
	}

	@Override
	public List<SavingsAccount> selectAllSavingsAccounts() {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<SavingsAccount> sal = new ArrayList<SavingsAccount>();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "SELECT * FROM bank_template.savings_accounts";
		ps = conn.prepareStatement(query);
		
		rs = ps.executeQuery();
		while (rs.next()) {
			
			SavingsAccount sa  = new SavingsAccount(
					
					rs.getInt(1),
					rs.getInt(2),
					rs.getDouble(3)
					
					);
				
				// Add the new employee Object to our list
				sal.add(sa);
			
		}
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
		return sal;
		
	}

	@Override
	public SavingsAccount updateSavingsPrimary(Integer id, SavingsAccount sa) {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the new balance: ");
		Double savings = input.nextDouble();
		input.nextLine();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.savings_accounts SET savings = ? WHERE savings_id = ?";
		ps = conn.prepareStatement(query);
		ps.setDouble(1, savings);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return sa;
		}
		
		sa.setSavings(savings);
		
		return sa;
		
	}

	@Override
	public boolean deleteSavingsAccount() {
		
		PreparedStatement ps = null;
		System.out.print("Enter the savings account ID of the account you wish to terminate: ");
		Integer id = input.nextInt();
		input.nextLine();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
			
			String query = "DELETE FROM bank_template.savings_accounts WHERE savings_id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.execute();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		
		return true;
		
	}

	@Override
	public SavingsAccount updateSecondaryIDAsPrimary(Integer id, SavingsAccount sa) {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the new secondary ID: ");
		Integer nid = input.nextInt();
		input.nextLine();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.savings_accounts SET secondary_id = ? WHERE savings_id = ?";
		ps = conn.prepareStatement(query);
		ps.setDouble(1, nid);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return sa;
		}
		
		sa.setSecondaryID(nid);
		
		return sa;
		
	}
	
	@Override
	public SavingsAccount updateSecondaryIDAsSecondary(Integer id, SavingsAccount sa) {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the replacement secondary ID: ");
		Integer nid = input.nextInt();
		input.nextLine();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.savings_accounts SET secondary_id = ? WHERE secondary_id = ?";
		ps = conn.prepareStatement(query);
		ps.setDouble(1, nid);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return sa;
		}
		
		sa.setSecondaryID(nid);
		
		return sa;
		
	}

	@Override
	public SavingsAccount updateSavingsSecondary(Integer id, SavingsAccount sa) {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the new balance: ");
		Double savings = input.nextDouble();
		input.nextLine();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.savings_accounts SET savings = ? WHERE secondary_id = ?";
		ps = conn.prepareStatement(query);
		ps.setDouble(1, savings);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return sa;
		}
		
		sa.setSavings(savings);
		
		return sa;
		
	}

	@Override
	public SavingsAccount removeSecondaryID(Integer id, SavingsAccount sa) {
		
		PreparedStatement ps = null;
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.savings_accounts SET secondary_id = NULL  WHERE _id = ?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return sa;
		}
		
		sa.setSecondaryID(null);
		
		return sa;
		
	}

	@Override
	public SavingsAccount setSecondaryIDAsPrimary(Integer id, SavingsAccount sa) {
		
		PreparedStatement ps = null;
		
		Integer oldid = id;
		Integer newid = sa.getSecondaryID();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.savings_accounts SET savings_id = secondary_id  WHERE _id = ?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, oldid);
		ps.execute();
		
		query = "UPDATE bank_template.savings_accounts SET secondary_id = NULL WHERE savings_id = ?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, newid);
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return sa;
		}
		
		sa.setSavingsID(newid);
		sa.setSecondaryID(null);
		
		return sa;
		
	}
	

	@Override
	public boolean updateSavingsID() {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the primary ID of the savings account you are changing: ");
		Integer id = input.nextInt();
		input.nextLine();
		System.out.print("Enter the new primary ID: ");
		Integer nid = input.nextInt();
		input.nextLine();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.savings_accounts SET savings_id = ? WHERE savings_id = ?";
		ps = conn.prepareStatement(query);
		ps.setDouble(1, nid);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
}
