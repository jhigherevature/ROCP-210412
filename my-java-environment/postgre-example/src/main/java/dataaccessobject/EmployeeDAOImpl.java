package dataaccessobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectionutil.ConnectionUtility;
import model.Employee;

public class EmployeeDAOImpl implements EmployeeDao {

	@Override
	public boolean insertIntoEmployees(Employee emp) {
		PreparedStatement ps = null;
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "INSERT INTO examples.employees VALUES (DEFAULT,?,?,?)";
			ps.getConnection().prepareStatement(query);
			ps.setString(0, emp.getEmp_name());
			ps.setString(2, emp.getEmp_title());
			ps.setDouble(3, emp.getEmp_salary());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		
		// String query = "INSERT INTO examples.employees (emp_name, emp_title, emp_salary) VALUES (?,?,?)";
		
		return true;
	}

	@Override
	public Employee selectEmployee(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp = null;
		
		try(Connection conn = ConnectionUtility.getConnection()) {
			
			String query = "SELECT * FROM examples.employees WHERE emp_id = ?";
			ps.getConnection().prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				emp = new Employee(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4));
						
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Employee> selectAllEmployees() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Employee> elist = new ArrayList<Employee>();
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "SELECT * FROM examples.employees";
			stmt = conn.createStatement();
			
			/*
			 * Statements have multiple methods which can be used to execute queries
			 * For Simple Statements the execute() method will return a boolean based on 
			 * whether the query successfully completed or not
			 * 
			 * The executeQuery() method will return a ResultSet based off the query provided
			 */
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Employee emp = new Employee();
				
				emp.setEmp_id(rs.getInt(1));
				emp.setEmp_name(rs.getString(2));
				emp.setEmp_salary(rs.getDouble(4));
				emp.setEmp_title(rs.getString(3));
				elist.add(emp);
			}
		
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
				
		return elist;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}


}
