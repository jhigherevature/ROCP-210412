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

public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Override
	public boolean insertIntoEmployees(Employee emp, Integer login_id) {
		PreparedStatement ps = null;
//		String queryExample_1 = "INSERT INTO examples.employees (emp_name, emp_title, emp_salary) VALUES (?,?,?)";
//		String queryExample_2 = "INSERT INTO examples.employees VALUES (DEFAULT,?,?,?)";
		try (Connection conn = ConnectionUtility.getConnection()) {
			/*
			 * We are setting the emp_id column of this query to 
			 * NULL because we have the trigger and function 
			 * working on our DB. If you are using SERIAL or
			 * a customer sequence, you can use DEFAULT if the
			 * custom sequence is used as the default value
			 */
			String query = "INSERT INTO bankapp.employee VALUES (DEFAULT,?,?,?,?)";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, emp.getEmp_name());
			ps.setString(2, emp.getEmp_title());
			ps.setDouble(3, emp.getEmp_salary());
			ps.setInt(4, login_id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			/*
			 * The '?' in the String query below is the parameter
			 * marker for our PreparedStatement. We can set the
			 * value used in the parameter markers by referencing
			 * the prepared statement and setting the value of those
			 * markers using the marker's position (the indexing here
			 * also starts at 1.
			 */
			String query = "SELECT * FROM bankapp.employee WHERE emp_id=?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				emp = new Employee(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getInt(5)
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	@Override
	public Employee selectEmployeeByLoginId(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp = null;
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			/*
			 * The '?' in the String query below is the parameter
			 * marker for our PreparedStatement. We can set the
			 * value used in the parameter markers by referencing
			 * the prepared statement and setting the value of those
			 * markers using the marker's position (the indexing here
			 * also starts at 1.
			 */
			String query = "SELECT * FROM bankapp.employee WHERE login_id=?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				emp = new Employee(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4),
						rs.getInt(5)
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
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "SELECT * FROM bankapp.employee";
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
				emp.setEmp_id(rs.getInt(1));
				emp.setEmp_name(rs.getString(2));
				emp.setEmp_title(rs.getString("emp_title"));
				emp.setEmp_salary(rs.getDouble("emp_salary"));
				emp.setLogin_id(rs.getInt("login_id"));
				
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
		// TODO Auto-generated method stub
		return false;
	}

}
