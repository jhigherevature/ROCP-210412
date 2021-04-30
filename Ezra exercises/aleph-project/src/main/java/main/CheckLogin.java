package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import connectutil.ConnectUtil;

public class CheckLogin {
	@SuppressWarnings("resource")
	public String[] checkLogin(String usertype) {
		
		System.out.println("Please type in your username");
		Scanner scan = new Scanner(System.in);
		String un = scan.nextLine();
		System.out.println("Username selected is: " + un + "\n Please type in your password");
//		Scanner scan = new Scanner(System.in);
		String pw = scan.nextLine();
//		System.out.println("Username selected is " + un + "\n"+ "Password selected is " + pw);

			PreparedStatement ps = null;
			ResultSet rs = null;
//			Employee emp = null;
			String[] loginObject = new String[3];
//			usertype = "employee"; //should be set automatically based on previous input
			if (usertype == "donor") {
				usertype = "donor";
				try (Connection conn = ConnectUtil.getConnection()) {
					//	this variation would make login work with any type of login...still need to update tables accordingly though
						String query = "SELECT e.first_name, e.last_name, e.emp_title FROM project.userpass AS u INNER JOIN project."+usertype+" AS e ON u.id_userpass = e.id_userpass WHERE username= '"+un+"' AND pw = '"+pw+"';";
						ps = conn.prepareStatement(query);						
						System.out.println(un + " " + pw);						
						rs = ps.executeQuery();
						
						while (rs.next()) {
							loginObject[0] = rs.getString("first_name");
							System.out.println(loginObject[0]);
							loginObject[1] = rs.getString("last_name");
							System.out.println(loginObject[1]);
							loginObject[2] = rs.getString("emp_title");
							System.out.println(loginObject[2]);
							}
						
					} catch (SQLException e) {
						e.printStackTrace();
						}
			}
			if (usertype == "employee") {
				usertype = "employee";
				try (Connection conn = ConnectUtil.getConnection()) {
					//	this variation would make login work with any type of login...still need to update tables accordingly though
						String query = "SELECT e.first_name, e.last_name, u.access_lvl FROM project.userpass AS u INNER JOIN project."+usertype+" AS e ON u.id_userpass = e.id_userpass WHERE username= '"+un+"' AND pw = '"+pw+"';";
						ps = conn.prepareStatement(query);						
						System.out.println(un + " " + pw);						
						rs = ps.executeQuery();
						
						while (rs.next()) {
							loginObject[0] = rs.getString("first_name");
							System.out.println(loginObject[0]);
							loginObject[1] = rs.getString("last_name");
							System.out.println(loginObject[1]);
							loginObject[2] = rs.getString("permission_type");
							System.out.println(loginObject[2]);
							}
						
						
					} catch (SQLException e) {
						e.printStackTrace();
						}
				
			}
			if (usertype == "parent") {
				usertype = "parent";
			}
			if (usertype == "school") {
				usertype = "school_contact";
			}
			try (Connection conn = ConnectUtil.getConnection()) {
			//	this variation would make login work with any type of login...still need to update tables accordingly though
				String query = "SELECT e.first_name, e.last_name, e.emp_title FROM project.userpass AS u INNER JOIN project."+usertype+" AS e ON u.id_userpass = e.id_userpass WHERE username= '"+un+"' AND pw = '"+pw+"';";
//				check to see if query works
//				String query = "SELECT e.first_name, e.last_name, e.emp_title FROM project.userpass AS u INNER JOIN project.employee AS e ON u.id_userpass = e.id_userpass WHERE username= 'a' AND pw = 'a';";
//			uses prepareStatement     but isn't working. don't know why
//				String query = "SELECT e.first_name, e.last_name, e.emp_title FROM project.userpass AS u INNER JOIN project.employee AS e ON u.id_userpass = e.id_userpass WHERE username= '?' AND pw = '?';";
//				String query = "SELECT e.first_name, e.last_name, e.emp_title FROM project.userpass AS u INNER JOIN project.? AS e ON u.id_userpass = e.id_userpass WHERE username=? AND pw =?;";

				ps = conn.prepareStatement(query);
				
				System.out.println(un + " " + pw);
//				this won't work...figured out alternative
//				ps.setString(1, un);
//				ps.setString(2, pw);
				
				rs = ps.executeQuery();
				
				
				while (rs.next()) {
					loginObject[0] = rs.getString("first_name");
					System.out.println(loginObject[0]);
					loginObject[1] = rs.getString("last_name");
					System.out.println(loginObject[1]);
					loginObject[2] = rs.getString("emp_title");
					System.out.println(loginObject[2]);
					}
				
			} catch (SQLException e) {
				e.printStackTrace();
				}
			if (loginObject[0]==null) {
				return null;
			}
			
			return loginObject;
			}
}
