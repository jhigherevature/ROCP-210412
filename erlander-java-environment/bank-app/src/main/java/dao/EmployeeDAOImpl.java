package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;
import model.Employee;
import utilities.ConnectionUtility;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public Employee getEmployeeByUserID(int user_id) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee employee = null;

		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "SELECT u.user_id, USER_FIRST_NAME, user_last_name, USERNAME, USERPASSWORD, employee_id FROM bank.employees AS e LEFT JOIN bank.users AS u ON e.user_id = u.user_id WHERE e.user_id = ?";
			ps = conn.prepareStatement(query);

			ps.setInt(1, user_id);

			rs = ps.executeQuery();

			if (rs.next() != false) {

				employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6));

			} else {
				return null;
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return employee;
	}

	@Override
	public Admin checkIfAdmin(Employee employee) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin admin = null;

		try (Connection conn = ConnectionUtility.getConnection()) {

			String query = "SELECT * FROM bank.admins WHERE employee_id = ?";
			ps = conn.prepareStatement(query);

			ps.setInt(1, employee.getEmployeeID());

			rs = ps.executeQuery();

			if (rs.next() != false) {
				admin = new Admin(employee.getUserID(), employee.getFirstName(), employee.getLastName(), employee.getUsername(), employee.getPassword(), employee.getEmployeeID(), rs.getInt(1));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
		return admin;
	}
}
