package dataaccessobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectionutil.ConnectionUtility;
import model.Account;
import model.Customer;
import model.Employee;
import model.Login;

public class CustomerDAOImpl {

	//Insert
	public boolean insertIntoLogin(Login log) 
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection()) 
		{
			String query = "INSERT INTO bankapp.login VALUES(?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, log.getLogin_id());
			ps.setString(2, log.getUser_name());
			ps.setString(3, log.getPass_word());
			ps.executeUpdate();
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			return false;
			
		}
		return true;
	}
	
	public boolean insertIntoCustomers(Customer cust) 
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection()) 
		{
			String query = "INSERT INTO bankapp.customers VALUES(?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, cust.getCust_id());
			ps.setString(2, cust.getCust_name());
			ps.setInt(3, cust.getLogin_id());
			ps.executeUpdate();
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			return false;
			
		}
		return true;
	}
	
	public boolean insertIntoEmployees(Employee emp) 
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection()) 
		{
			String query = "INSERT INTO bankapp.employees VALUES(?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, emp.getEmp_id());
			ps.setString(2, emp.getEmp_name());
			ps.setInt(3, emp.getLogin_id());
			ps.executeUpdate();
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			return false;
			
		}
		return true;
	}
	
	public boolean insertIntoAccounts(Account acc)
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection()) 
		{
			String query = "INSERT INTO bankapp.accounts VALUES(?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, acc.getAccount_id());
			ps.setDouble(2, acc.getAccount_balance());
			ps.setInt(3, acc.getCust_id1());
			ps.setInt(4, acc.getCust_id2());
			ps.executeUpdate();
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			return false;
			
		}
		return true;
	}
	
	//Select
	public Login selectLogin(int login_id)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Login log = null;
		
		try(Connection conn = ConnectionUtility.getConnection())
		{
			String query = "SELECT * FROM bankapp.login WHERE login_id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, login_id);
			rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				log = new Login(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3)
						);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return log;
	}
	
	public Customer selectCustomer(int cust_id)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer cust = null;
		
		try(Connection conn = ConnectionUtility.getConnection())
		{
			String query = "SELECT * FROM bankapp.customers WHERE cust_id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, cust_id);
			rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				 cust = new Customer(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3)
						);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return cust;
	}
	
	public Employee selectEmployee(int emp_id)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp = null;
		
		try(Connection conn = ConnectionUtility.getConnection())
		{
			String query = "SELECT * FROM bankapp.employees WHERE emp_id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, emp_id);
			rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				 emp = new Employee(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3)
						);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return emp;
	}
	
	public Account selectAccount(int account_id)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account acc = null;
		
		try(Connection conn = ConnectionUtility.getConnection())
		{
			String query = "SELECT * FROM bankapp.accounts WHERE account_id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, account_id);
			rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				 acc = new Account(
						rs.getInt(1),
						rs.getDouble(2),
						rs.getInt(3),
						rs.getInt(4)
						);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return acc;
	}
	
	public List<Customer> selectAllCustomers() 
	{
		Statement stmt = null;
		ResultSet rs = null;
		List<Customer> cList = new ArrayList<Customer>();
		
		try(Connection conn = ConnectionUtility.getConnection())
		{
			String query = "SELECT * FROM bankapp.customers";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) 
			{
				Customer cust = new Customer(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3)
						);
				cList.add(cust);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return cList;
	}
	
	public List<Account> selectAllAccounts() 
	{
		Statement stmt = null;
		ResultSet rs = null;
		List<Account> aList = new ArrayList<Account>();
		
		try(Connection conn = ConnectionUtility.getConnection())
		{
			String query = "SELECT * FROM bankapp.accounts";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) 
			{
				Account acc = new Account(
						rs.getInt(1),
						rs.getDouble(2),
						rs.getInt(3),
						rs.getInt(4)
						);
				aList.add(acc);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return aList;
	}
	
	//Update
	public boolean updateAccount(int account_id, double amount)
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection()) 
		{
			String query = "UPDATE bankapp.accounts SET account_balance=? WHERE account_id=?";
			ps = conn.prepareStatement(query);
			ps.setDouble(1, amount);
			ps.setInt(2, account_id);
			ps.executeUpdate();
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			return false;
			
		}
		return true;
	}
	
	//Delete
	public boolean deleteAccount(int account_id)
	{
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtility.getConnection()) 
		{
			String query = "DELETE FROM bankapp.accounts WHERE account_id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, account_id);
			ps.executeUpdate();
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			return false;
			
		}
		return true;
	}
}