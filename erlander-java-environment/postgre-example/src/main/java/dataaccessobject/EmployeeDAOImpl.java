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

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public boolean insertIntoEmployees(Employee emp) {
		PreparedStatement ps = null;
		
		try (Connection conn = ConnectionUtility.getConnection()) {
			String queryString = "INSERT INTO example.employees VALUES (DEFAULT, ?, ?, ?)";
			ps = conn.prepareStatement(queryString);
			
			ps.setString(1, emp.getEmp_name());
			ps.setString(2, emp.getEmp_title());
			ps.setDouble(3, emp.getEmp_salary());
			
			ps.executeUpdate();
			
		} catch (SQLException sqlE) {
			System.out.println("The connection failed!");
			sqlE.printStackTrace();
			return false;
		}
		
		return true;
		
	}

	@Override
	public Employee selectEmployee(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp = null;
		
		try (Connection conn = ConnectionUtility.getConnection()){
						
			String queryString = "SELECT * FROM example.employees WHERE emp_id=?";
			ps = conn.prepareStatement(queryString);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				emp = new Employee();
				
				emp.setEmp_id(rs.getInt(1));
				emp.setEmp_name(rs.getString(2));
				emp.setEmp_title(rs.getString(3));
				emp.setEmp_salary(rs.getDouble(4));
				
			}
			
		} catch(SQLException sqlE) {
			System.out.println("The connection failed!");
			sqlE.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public List<Employee> selectAllEmployees() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Employee> empList = new ArrayList<Employee>(); 
		
		try (Connection conn = ConnectionUtility.getConnection()){
			
			String queryString = "SELECT * FROM example.employees";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(queryString);
			
			while(rs.next()) {
				Employee emp = new Employee();
				
				emp.setEmp_id(rs.getInt(1));
				emp.setEmp_name(rs.getString(2));
				emp.setEmp_title(rs.getString(3));
				emp.setEmp_salary(rs.getDouble(4));
				
				empList.add(emp);
				
			}
			
		} catch(SQLException sqlE) {
			System.out.println("The connection failed!");
			sqlE.printStackTrace();
		}
		
		
		return empList;
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
