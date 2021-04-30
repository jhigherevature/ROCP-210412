package postgredataaccessobjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connectionutility.ConnectionUtility;
import employeelogin.EmployeeLogin;

public class EmployeeLoginDAOImplementation implements EmployeeLoginDAO{
	
	Scanner input = new Scanner(System.in);
	
	String accessLevel;
	
	public EmployeeLoginDAOImplementation() {}
	
	public EmployeeLoginDAOImplementation (String accessLevel){
		
		this.accessLevel = accessLevel;
		
	}

	@Override
	public boolean insertIntoEmployeeLogin() {
		
		System.out.print("Enter a username: ");
		String username = input.nextLine();
		System.out.print("Enter a password: ");
		String password = input.nextLine();
		
		PreparedStatement ps = null;
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
			String query = "INSERT INTO bank_template.employee_login VALUES (DEFAULT,?,?)";//not serialized in database, need to implement with insertintoCustomers
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
	public EmployeeLogin selectEmployeeLogin(Integer id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		EmployeeLogin e = null;
		
		try(Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "SELECT * FROM bank_template.employee_login WHERE login_id = ?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		while (rs.next()) {
			e = new EmployeeLogin(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3)
					);
		}
		} catch (SQLException ex) {
			ex.printStackTrace();
			return e;
		}
		
		return e;
		
	}

	@Override
	public List<EmployeeLogin> selectAllEmployeeLogin() {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<EmployeeLogin> l = new ArrayList<EmployeeLogin>();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "SELECT * FROM bank_template.employee_login";
		ps = conn.prepareStatement(query);
		
		rs = ps.executeQuery();
		while (rs.next()) {
			
			EmployeeLogin b = new EmployeeLogin(
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
	public EmployeeLogin updateUsername(Integer id, EmployeeLogin el) {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the new username: ");
		String username = input.nextLine();
				
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.employee_login SET login_username = ? WHERE login_id = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, username);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return el;
		}
		
		el.setUsername(username);
		
		return el;
		
	}

	@Override
	public EmployeeLogin updatePassword(Integer id, EmployeeLogin el) {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the new password: ");
		String password = input.nextLine();
				
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.employee_login SET login_password = ? WHERE login_id = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, password);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return el;
		}
		
		el.setPassword(password);
		
		return el;
		
	}
	
}
