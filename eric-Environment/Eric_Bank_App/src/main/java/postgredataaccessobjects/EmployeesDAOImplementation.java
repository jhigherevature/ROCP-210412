package postgredataaccessobjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connectionutility.ConnectionUtility;
import employees.Employees;

public class EmployeesDAOImplementation implements EmployeesDAO {
	
	Scanner input = new Scanner (System.in);
	
	String accessLevel;
	
	 public EmployeesDAOImplementation () {}
	 
	 public EmployeesDAOImplementation (String accessLevel) {
		 
		 this.accessLevel = accessLevel;
		 
	 }
	 
	 @Override
		public Employees selectEmployee(Integer id) {
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			Employees e = null;
			
			try(Connection conn = ConnectionUtility.getConnection(accessLevel)) {
			
			String query = "SELECT * FROM bank_template.employees WHERE employee_id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				e = new Employees(
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
		public List<Employees> selectAllEmployees() {
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Employees> l = new ArrayList<Employees>();
			
			try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
			
			String query = "SELECT * FROM bank_template.employees";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				
				Employees e = new Employees(
						
						/*
						 * When using the 'get' methods on our
						 * result set, we can find the values using
						 * the column index (which starts at 1)
						 * or the column name, based on the DB structure
						 */
						
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getDouble(5)
						);
					
					// Add the new employee Object to our list
					l.add(e);
				
			}
			
			} catch (SQLException ex) {
				ex.printStackTrace();
				return null;
			}
			
			return l;		
		}

		@Override
		public Employees updateEmployeeFirstName(Integer id, Employees e) {
			
			PreparedStatement ps = null;
			
			System.out.print("Enter the new first name: ");
			String firstName = input.nextLine();
					
			try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
			
			String query = "UPDATE bank_template.employees SET employee_first_name = ? WHERE employee_id = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, firstName);
			ps.setInt(2, id);
			ps.execute();
			
			} catch (SQLException ex) {
				ex.printStackTrace();
				return e;
			}
			
			e.setFirstName(firstName);
			
			return e;	
		}

		@Override
		public Employees updateEmployeeLastName(Integer id, Employees e) {
			
			PreparedStatement ps = null;
			
			System.out.print("Enter the new last name: ");
			String lastName = input.nextLine();
			
			try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
			
			String query = "UPDATE bank_template.employees SET employee_last_name = ? WHERE employee_id = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, lastName);
			ps.setInt(2, id);
			ps.execute();
			
			} catch (SQLException ex) {
				ex.printStackTrace();
				return e;
			}
			
			e.setLastName(lastName);
			
			return e;	
		}

		@Override
		public Employees updateEmployeeJob(Integer id, Employees e) {
			
			PreparedStatement ps = null;
			
			System.out.print("Enter the new job: ");
			String job = input.nextLine();
			
			try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
			
			String query = "UPDATE bank_template.employees SET employee_job = ? WHERE employee_id = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, job);
			ps.setInt(2, id);
			ps.execute();
			
			} catch (SQLException ex) {
				ex.printStackTrace();
				return e;
			}
			
			e.setJob(job);
			
			return e;	
			
		}

		@Override
		public Employees updateEmployeeSalary(Integer id, Employees e) {
			
			PreparedStatement ps = null;
			
			System.out.print("Enter the new salary number: ");
			Double salary = input.nextDouble();
			input.nextLine();
			
			try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
			
			String query = "UPDATE bank_template.employees SET employee_salary = ? WHERE employee_id = ?";
			ps = conn.prepareStatement(query);
			ps.setDouble(1, salary);
			ps.setInt(2, id);
			ps.execute();
			
			} catch (SQLException ex) {
				ex.printStackTrace();
				return e;
			}
			
			e.setSalary(salary);
			
			return e;	
			
		}

		@Override
		public boolean deleteEmployee() {
			
			PreparedStatement ps = null;
			System.out.print("Enter the employee ID of the employee you wish to terminate: ");
			Integer id = input.nextInt();
			
			try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
				
				String query = "DELETE FROM bank_template.employees WHERE employee_id = ?";
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
		public boolean insertIntoEmployees() {
			
			System.out.print("You are creating a new employee.\nPlease enter the new employee's first name: ");
			String firstName = input.nextLine();
			System.out.print("Last name: ");
			String lastName = input.nextLine();
			System.out.print("Job: ");
			String job = input.nextLine();
			System.out.print("Salary: ");
			Double salary = input.nextDouble();
			
			
			PreparedStatement ps = null;
			
			try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
			
				String query = "INSERT INTO bank_template.employees VALUES (DEFAULT,?,?,?,?)";
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

}
