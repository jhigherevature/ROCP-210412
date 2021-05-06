package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import connectutil.ConnectUtil;
import model.Donor;
import model.Employee;
import services.AuthenticationService;
import services.CreateDonor;
import services.GetUNandPW;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StartMenu {

	private static final Logger log = LogManager.getLogger(StartMenu.class);

	@SuppressWarnings({ "resource", "unused" })
	public void startMenu() {

//	Name of Program can be easily changed in CUR

//	Login Types can be easily changed and added here by adding to LoginType array
		String[] loginType = new String[] { "Donor", "School *coming soon*", "Employee", "New Donor", "Logout" };



		String access_token = null;

//		Check connection to server
		try (Connection conn = ConnectUtil.getConnection()) {
//			System.out.println("Connection successful");
		} catch (SQLException sqlE) {
			System.out.println("Connection failed");
			sqlE.printStackTrace();
		}
//		welcome message
		System.out.println("Welcome to " + CUR.getCUR().getProgname());

		int menuChoiceLogin = 0;
		loginloop: while (menuChoiceLogin != 5) {

			System.out.println("Please choose your user type below:");
			for (int i = 1; i <= loginType.length; i++) {
				System.out.println(i + ") " + loginType[(i - 1)]);
			}
//	open scanner
			Scanner scan = new Scanner(System.in);
//			menuChoiceLogin = services.Constraints.menuCon(scan.nextInt());	//doesn't help because can only take an int value anyway
			menuChoiceLogin = scan.nextInt();
			
			switch (menuChoiceLogin) {
			case 1: // donor
				Donor donor = AuthenticationService.authenticateDonor(GetUNandPW.getUNandPW());
				if (donor == null) {
					if (CUR.getCUR().getLogincounter() >= 3) {
						System.out.println("Too many failed attempts.");
						log.warn("user attempted too many failed donor logins");

						menuChoiceLogin = 5;
					} else {
						menuChoiceLogin = 1;
						break;
					}
				}
				if (donor != null) {
					menuChoiceLogin = 5;
				}
				break;
			case 2: // school user
				System.out.println(
						"School logins are not currently available at this time. Please contact admin. \nIf you did not intend to login as a school user then please login again.");
				System.exit(0);
				menuChoiceLogin = 5;
				break;
			case 3: // Employee
				Employee emp = AuthenticationService.authenticateEmployee(GetUNandPW.getUNandPW());
//	System.out.println(emp);
				if (emp == null) {
					if (CUR.getCUR().getLogincounter() >= 3) {
						System.out.println("Too many failed attempts.");
						log.warn("user attempted too many failed employee logins");
						menuChoiceLogin = 5;
					} else {
						break;
					}
				}
				if (emp != null) {
					menuChoiceLogin = 5;
				}
				break;

			case 4:
				CreateDonor cd = new CreateDonor();
				System.out.println("Please create your new account now");
				cd.createDonor();
				CUR.getCUR().setAccess_token("donor");
				break;
			case 5:
				menuChoiceLogin = 5;
				System.out.println("Thank you for visiting " + CUR.getCUR().getProgname() + ". See you again soon!");
				System.exit(0);
				break;
			}
		}
//	Choose context menu by access_token

		switch (access_token = CUR.getCUR().getAccess_token()) {

		case "null":
			System.out.println("Thank you for visiting " + CUR.getCUR().getProgname() + ". See you again soon!");
			System.exit(0);
			
		case "donor":
			log.info(access_token + " user successfully logged into donor menu");
			System.out.println("donor menu");
			MainDonorMenu mdm = new MainDonorMenu();
			mdm.menu();
			break;

		case "emp":
			log.info(access_token + " user successfully logged into employee menu");
			System.out.println("employee menu");
			MainEmployeeMenu mem = new MainEmployeeMenu();
			mem.menu();
			break;
			
		case "admin":
			log.info(access_token + " user successfully logged into admin menu");
			System.out.println("admin menu");
			break;
		}

	}
}
