package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import bankerlogin.BankerLogin;
import bankers.BankerUI;
import connectionutility.ConnectionUtility;
import customerlogin.CustomerLogin;
import customers.CustomerUI;
import employeelogin.EmployeeLogin;
import employees.EmployeeUI;
import postgredataaccessobjects.CustomerApplicationDAO;
import postgredataaccessobjects.CustomerApplicationDAOImplementation;

public class Login {

	Scanner input = new Scanner (System.in);
	
	
	public void initialLogin() {
		
		program:while(true) {
		
		System.out.println("Welcome to Not US Bank! Select an option by inputing the corresponding number below:"
				+ "\n1.Banker login"
				+ "\n2.Employee login"
				+ "\n3.Customer login"
				+ "\n4.New customer application"
				+ "\n5.Exit");
		
		Integer num = input.nextInt();
		input.nextLine();
		
		switch (num) {
		
		case 1: bankerLogin();
		
		break;
			
		case 2: employeeLogin();
		
		break;
			
		case 3: customerLogin();
		
		break;
		
		case 4: newCustomerLogin();
		
		break;
		
		case 5: 
			System.out.println("Goodbye!");
			break program;
		
		}
		
	}
		
	}

	
	public void bankerLogin() {
		
		System.out.print("Please enter your username: ");
		String username = input.nextLine();
		System.out.print("Please enter your password: ");
		String password = input.nextLine();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		BankerLogin e = null;
		
		try(Connection conn = ConnectionUtility.getConnection("login")) {
		
		String query = "SELECT * FROM bank_template.banker_login WHERE banker_login.login_username = ? AND banker_login.login_password = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, username);
		ps.setString(2, password);
		rs = ps.executeQuery();
		while (rs.next()) {
			e = new BankerLogin(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3)
					);
		}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("There was an error, please try again");
		}
		
		if (e == null) {
			System.out.println("Your input did not match any records in our database");
		} else {
		System.out.println(e);
		}

		BankerUI bui = new BankerUI();
		bui.ui();
		
	}

	
	public void employeeLogin() {
		
		System.out.print("Please enter your username: ");
		String username = input.nextLine();
		System.out.print("Please enter your password: ");
		String password = input.nextLine();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		EmployeeLogin e = null;
		
		try(Connection conn = ConnectionUtility.getConnection("login")) {
		
		String query = "SELECT * FROM bank_template.employee_login WHERE employee_login.login_username = ? AND employee_login.login_password = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, username);
		ps.setString(2, password);
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
			System.out.println("There was an error, please try again");
		}
		
		if (e == null) {
			System.out.println("Your input did not match any records in our database");
		} else {
		System.out.println(e);
		}

		EmployeeUI eui = new EmployeeUI();
		eui.ui();
		
	}

	
	public void customerLogin() {
		
		System.out.print("Please enter your username: ");
		String username = input.nextLine();
		System.out.print("Please enter your password: ");
		String password = input.nextLine();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		CustomerLogin e = null;
		
		try(Connection conn = ConnectionUtility.getConnection("login")) {
		
		String query = "SELECT * FROM bank_template.customer_login WHERE customer_login.login_username = ? AND customer_login.login_password = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, username);
		ps.setString(2, password);
		rs = ps.executeQuery();
		while (rs.next()) {
			e = new CustomerLogin(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3)
					);
		}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("There was an error, please try again");
		}
		
		if (e == null) {
			System.out.println("Your input did not match any records in our database");
		} else {
		System.out.println(e);
		}
		
		CustomerUI cui = new CustomerUI();
		cui.ui();
		
	}

	
	public void newCustomerLogin() {
		
		CustomerApplicationDAO caDao= new CustomerApplicationDAOImplementation("login");
		
		caDao.insertIntoCustomerApplication();
		
	}
	
	

}
