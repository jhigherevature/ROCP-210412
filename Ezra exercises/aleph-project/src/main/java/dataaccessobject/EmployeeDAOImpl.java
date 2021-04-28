package dataaccessobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import connectutil.ConnectUtil;
import model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public boolean insertIntoEmployees(Employee emp) {
		PreparedStatement ps = null;
//		String queryExample_1 = "INSERT INTO examples.employees (emp_name, emp_title, emp_salary) VALUES (?,?,?)";
//		String queryExample_2 = "INSERT INTO examples.employees VALUES (DEFAULT,?,?,?)";
		try (Connection conn = ConnectUtil.getConnection()) {
			/*
			 * We are setting the emp_id column of this query to 
			 * NULL because we have the trigger and function 
			 * working on our DB. If you are using SERIAL or
			 * a customer sequence, you can use DEFAULT if the
			 * custom sequence is used as the default value
			 */
			String query = "INSERT INTO project.employee VALUES (DEFAULT,?,?,?,?)";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, emp.getFirst_name());
			ps.setString(2, emp.getLast_name());
			ps.setString(3, emp.getEmp_title());
			ps.setInt(4, emp.getId_userpass());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public Employee selectEmployee(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp = null;
		
		try (Connection conn = ConnectUtil.getConnection()) {

			String query = "SELECT * FROM project.employee WHERE id_emp=?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
						
			while (rs.next()) {
				emp = new Employee(
						rs.getInt("id_emp"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("emp_title"),
						rs.getInt("id_userpass")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<Employee> selectAllEmployees() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Employee> elist = new ArrayList<Employee>();
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT * FROM project.employee";
			stmt = conn.createStatement();
			
			/*
			 * Statements have multiple methods which can
			 * be used to execute queries. For Simple Statements
			 * the 'execute()' method will return a boolean based on
			 * whether the query successfully completed or not
			 * 
			 * The 'executeQuery' method will return a ResultSet
			 * based off the query provided
			 */
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Employee emp = new Employee();
				/*
				 * When using the 'get' methods on our
				 * result set, we can find the values using
				 * the column index (which starts at 1)
				 * or the column name, based on the DB structure
				 */
				emp.setEmp_id(rs.getInt("id_emp"));
				emp.setFirst_name(rs.getString("first_name"));
				emp.setLast_name(rs.getString("last_name"));
				emp.setEmp_title(rs.getString("emp_title"));
				emp.setId_userpass(rs.getInt("id_userpass"));
				
				// Add the new employee Object to our list
				elist.add(emp);
			}
		} catch (SQLException e) {
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
		PreparedStatement ps = null;
		try (Connection conn = ConnectUtil.getConnection()) {
		
			String query = "DELETE FROM project.employee WHERE emp_id=?";
			ps = conn.prepareStatement(query);
				
			ps.setInt(1, emp.getEmp_id());
			ps.executeUpdate();			
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
	}
	@Override
	public Employee selectEmployeeByLoginId(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp = null;
		
		try (Connection conn = ConnectUtil.getConnection()) {
		
			String query = "SELECT * FROM project.employee WHERE id_userpass=?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				emp = new Employee(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5)
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
}
