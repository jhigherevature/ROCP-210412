package postgredataaccessobjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import bankers.Bankers;
import connectionutility.ConnectionUtility;

public class BankersDAOImplementation implements BankersDAO {
	
	Scanner input = new Scanner(System.in);
	
	String accessLevel;
	
	public BankersDAOImplementation() {}
	
	public BankersDAOImplementation (String accessLevel){
		
		this.accessLevel = accessLevel;
		
	}
		
	@Override
	public boolean insertIntoBankers() {
		
		System.out.print("You are creating a new banker.\nPlease enter the new banker's first name: ");
		String firstName = input.nextLine();
		System.out.print("Last name: ");
		String lastName = input.nextLine();
		System.out.print("Job: ");
		String job = input.nextLine();
		System.out.print("Salary: ");
		Double salary = input.nextDouble();
		input.nextLine();
		
		
		PreparedStatement ps = null;
		
		try (Connection conn = ConnectionUtility.getConnection(this.accessLevel)) {
		
			String query = "INSERT INTO bank_template.bankers VALUES (DEFAULT,?,?,?,?)";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, job);
			ps.setDouble(4, salary);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	@Override
	public Bankers selectBanker(Integer id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Bankers e = null;
		
		try(Connection conn = ConnectionUtility.getConnection(this.accessLevel)) {
		
		String query = "SELECT * FROM bank_template.bankers WHERE banker_id = ?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		while (rs.next()) {
			e = new Bankers(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getDouble(5)
					);
		}
		} catch (SQLException ex) {
			ex.printStackTrace();
			return e;
		}
		
		return e;
	}
	
	@Override
	public List<Bankers> selectAllBankers() {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Bankers> l = new ArrayList<Bankers>();
		
		try (Connection conn = ConnectionUtility.getConnection(this.accessLevel)) {
		
		String query = "SELECT * FROM bank_template.bankers";
		ps = conn.prepareStatement(query);
		
		rs = ps.executeQuery();
		while (rs.next()) {
			
			Bankers b = new Bankers(
					
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getDouble(5)
					);
				
				// Add the new employee Object to our list
				l.add(b);
			
		}
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
		return l;	
		
	}
	
	@Override
	public Bankers updateBankerFirstName(Integer id, Bankers b) {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the new first name: ");
		String firstName = input.nextLine();
				
		try (Connection conn = ConnectionUtility.getConnection(this.accessLevel)) {
		
		String query = "UPDATE bank_template.bankers SET banker_first_name = ? WHERE banker_id = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, firstName);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return b;
		}
		
		b.setFirstName(firstName);
		
		return b;
		
	}
	
	@Override
	public Bankers updateBankerLastName(Integer id, Bankers b) {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the new last name: ");
		String lastName = input.nextLine();
		
		try (Connection conn = ConnectionUtility.getConnection(this.accessLevel)) {
		
		String query = "UPDATE bank_template.bankers SET banker_last_name = ? WHERE banker_id = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, lastName);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return b;
		}
		
		b.setLastName(lastName);
		
		return b;
		
	}
	
	@Override
	public Bankers updateBankerJob(Integer id, Bankers b) {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the new job: ");
		String job = input.nextLine();
		
		try (Connection conn = ConnectionUtility.getConnection(this.accessLevel)) {
		
		String query = "UPDATE bank_template.bankers SET banker_job = ? WHERE banker_id = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, job);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return b;
		}
		
		b.setJob(job);
		
		return b;
		
	}
	
	@Override
	public Bankers updateBankerSalary(Integer id, Bankers b) {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the new salary number: ");
		Double salary = input.nextDouble();
		input.nextLine();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.bankers SET banker_salary = ? WHERE banker_id = ?";
		ps = conn.prepareStatement(query);
		ps.setDouble(1, salary);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return b;
		}
		
		b.setSalary(salary);
		
		return b;
		
	}
	
	@Override
	public boolean deleteBanker() {
		
		PreparedStatement ps = null;
		System.out.print("Enter the banker ID of the banker you wish to terminate: ");
		Integer id = input.nextInt();
		input.nextLine();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
			
			String query = "DELETE FROM bank_template.bankers WHERE banker_id = ?";
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


