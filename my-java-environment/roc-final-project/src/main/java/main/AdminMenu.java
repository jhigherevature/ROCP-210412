package main;

import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Customer;
import model.CustomerList;
import model.EmployeeList;

public class AdminMenu extends EmployeeMenu{
	CustomerMenu cm = new CustomerMenu();
	Scanner userInput = new Scanner(System.in);
	model.bank bank = new model.bank();
	static Logger logger = LogManager.getLogger(AdminMenu.class);
	boolean exit;
	
	public void runAdminMenu() {
		while (!exit) {
			printAdminMenu();
			int choice = getInput(4);
			switch(choice) {
			case 0:
				logger.info("Admin logging out...");
				System.out.println("\nLogging out...");
				exit = true;
				break;
				
			case 1:
				logger.info("Admin starting account approval process...");
				
				System.out.println("\n-------------------------------------------------------");
				System.out.println("                   Account Approval                    ");
				System.out.println("-------------------------------------------------------");
				Customer UnApprovedCustomers = bank.getAllUnApprovedAccounts();
				if (UnApprovedCustomers==null) {
					System.out.println("No accounts need to be approved");
					break;
				}
				printCustomerUnApprovedAccounts(UnApprovedCustomers);
				System.out.println("     [0] Cancel Approval");
				System.out.println("\nWhich account would you like to approve?");
				logger.info("Employee choosing which Account to approve...");
				
				int approvalChoice = getInput(UnApprovedCustomers.getAccountType().size());
				if (approvalChoice == 0) {
					logger.info("Employee cancelling approval...");
					break;
				}
				
				int accountID = UnApprovedCustomers.getAccountID().get(approvalChoice-1);
				bank.acceptApproval(accountID);
				logger.info("A Customer Account has been approved...");
				System.out.println("Account #" + accountID + " has been approved!");
				
				break;
			case 2:
				logger.info("Admin viewing all Account Info...");
				System.out.println("\n-------------------------------------------------------");
				System.out.println("               Customer Information Table              ");
				System.out.println("-------------------------------------------------------");
				
				CustomerList customerList = bank.getAllAccounts();
				for (int i = 0; i<customerList.getAccountID().size(); i++) {
					System.out.println("User ID #" + customerList.getuserID().get(i) + ":");
					System.out.println("     First Name: " + customerList.getFirstname().get(i));
					System.out.println("     Last Name: " + customerList.getLastname().get(i));
					System.out.println("     Username: " + customerList.getUsername().get(i));
					System.out.print("     Password: ");
					for (int j = 0; j < customerList.getPassword().get(i).length(); j++) {
						if (j == 0) {
							System.out.print(customerList.getPassword().get(i).charAt(j));
						} else {
							System.out.print("*");
						}
					}
					System.out.println("\n     Address: " + customerList.getAddress().get(i));
					System.out.print("     ssn: ***-**-");
					for (int k = 5; k < 9; k++) {
						System.out.print(customerList.getSsn().get(i).charAt(k));
					}
					System.out.println("\n     " + customerList.getAccountType().get(i) + " #"+
							+ customerList.getAccountID().get(i));
					System.out.println("     Balance:" + customerList.getBalance().get(i));
					if (customerList.getApproved().get(i) == 1) {
						System.out.println("     Approval Status: Approved");
					} else {
						System.out.println("     Approval Status: Pending");
					}
					System.out.println("~~~~~");
				}
				boolean valid = false;
				int userID = 0;
				while(!valid) {
					while (true) {
						System.out.print("\nPlease enter the User ID of the Account you want to update: ");
					    try {
					    	userID = userInput.nextInt();
					        break; 
					    } catch (NumberFormatException ignore) {
					        System.out.println("Invalid input, please only enter Integers only...");
					    }
					}   
					
					if (bank.UserExists(userID)) {
						System.out.println("Logging into customer account to modify data");
						logger.info("Admin has logged into Customer Account of UserID #" + userID +"...");
						cm.exit =false;
						cm.runCustomerMenu(userID);
						valid = true;
					} else {
						System.out.println("User ID #" + userID + " does not exist");
						System.out.println("Returning to Admin Main Menu...");
						break;
					}
				}
				break;
			case 3:
				logger.info("Admin viewing all Account Info to delete...");
				System.out.println("\n-------------------------------------------------------");
				System.out.println("               Customer Information Table              ");
				System.out.println("-------------------------------------------------------");
				
				customerList = bank.getAllAccounts();
				for (int i = 0; i<customerList.getAccountID().size(); i++) {
					System.out.println("User ID #" + customerList.getuserID().get(i) + ":");
					System.out.println("     First Name: " + customerList.getFirstname().get(i));
					System.out.println("     Last Name: " + customerList.getLastname().get(i));
					System.out.println("     Username: " + customerList.getUsername().get(i));
					System.out.print("     Password: ");
					for (int j = 0; j < customerList.getPassword().get(i).length(); j++) {
						if (j == 0) {
							System.out.print(customerList.getPassword().get(i).charAt(j));
						} else {
							System.out.print("*");
						}
					}
					System.out.println("\n     Address: " + customerList.getAddress().get(i));
					System.out.print("     ssn: ***-**-");
					for (int k = 5; k < 9; k++) {
						System.out.print(customerList.getSsn().get(i).charAt(k));
					}
					System.out.println("\n     " + customerList.getAccountType().get(i) + " #"+
							+ customerList.getAccountID().get(i));
					System.out.println("     Balance:" + customerList.getBalance().get(i));
					if (customerList.getApproved().get(i) == 1) {
						System.out.println("     Approval Status: Approved");
					} else {
						System.out.println("     Approval Status: Pending");
					}
					System.out.println("~~~~~");
				}
				valid = false;
				userID = 0;
				while(!valid) {
					while (true) {
						System.out.print("\nPlease enter the User ID of the Account you want to delete: ");
						System.out.println("Enter [0] to cancel");
					    try {
					    	userID = userInput.nextInt();
					        break; 
					    } catch (NumberFormatException ignore) {
					        System.out.println("Invalid input, please only enter Integers only...");
					    }
					}   
					
					if (bank.UserExists(userID)) {
						System.out.println("Are you sure you want to delete User ID #" + userID + " and all their data?");
						System.out.println("This cannot be undone");
						System.out.println("[1] Yes");
						System.out.println("[0] No");
						int deleteConfirmation = getInput(1);
							if (deleteConfirmation == 1) {
								logger.info("Admin has deleted UserID #" + userID +"...");
								bank.deleteUser(userID);
								valid = true;
							} else {
								logger.info("Admin has cancelled deletion process...");	
								break;
							}
					
						
					} else {
						logger.info("Admin tried to delete an account that does not exist...");
						System.out.println("User ID #" + userID + " does not exist");
						System.out.println("Returning to Admin Main Menu...");
						break;
					}
				}
				break;
				
			case 4:
				logger.info("Admin opening Employee Information Table to modify...");
				System.out.println("\n-------------------------------------------------------");
				System.out.println("               Employee Information Table              ");
				System.out.println("-------------------------------------------------------");
				valid = false;
				System.out.println("Which employee would you like to modify?");
				System.out.println("Type [-1] to Create a New Employee");
				printEmployeeList();
				int empID = -1;
				while (true) {
					System.out.print("\nPlease enter the Employee ID you want to modify: ");
				    try {
				    	empID = userInput.nextInt();
				        break; 
				    } catch (NumberFormatException ignore) {
				        System.out.println("Invalid input, please only enter Integers only...");
				    }    
				}  
				if (!bank.getEmployee(empID).getEmpID().isEmpty() && empID != -1) {
					EmployeeList updatingEmployee = bank.getEmployee(empID);
					System.out.println("What would you like to change on Employee ID #" + empID);
					System.out.println("[1] Username/Password");
					System.out.println("[2] Title");
					System.out.println("[3] Delete Employee");
					System.out.println("[0] Cancel Action");
					int updateEmployeeChoice = getInput(3);
					switch (updateEmployeeChoice) {
					case 0:
						logger.info("Admin cancelling out...");
						System.out.println("\nReturning to Admin Main Menu...");
						break;
					case 1:
						String newUsername = null;
						valid = false;
						while (!valid) {
							System.out.println("Current Employee Username: " + updatingEmployee.getUsername().get(0));
							System.out.println("Current Employee Password: " + updatingEmployee.getPassword().get(0));
							System.out.print("Enter New Username: ");
							newUsername = userInput.nextLine();
							if (newUsername.length()>=5) {
								if (bank.employeeUsernameCheck(newUsername) == true) {
									valid = true;
								} else if (newUsername.equalsIgnoreCase("exit")) {
									System.out.println("Returning to Login Selection Menu...");
									return;
								} else if (newUsername.equals(updatingEmployee.getUsername().get(0)))
									valid = true;
								else {
									System.out.println(newUsername + " is already taken, please use a different login...");
									System.out.println("To exit updating the username/password, type [exit]...");
								}
							} else {
								System.out.println("Username must be at least 5 characters long");
							}
						}
						valid = false;
						String newPassword = null;
						while(!valid) {
							System.out.print("Please create a password: ");
							newPassword = userInput.nextLine();
							final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%&])(?=.*\\d).+$");
							if (newPassword.length() >= 5) {
								if (textPattern.matcher(newPassword).matches()) {
									valid = true;
									
								} else {
									System.out.println("Password must contain at least one Uppercase Character, Lowercase Character, one number,");
									System.out.println("and one of the following characters :[! @ # $ % &]\n");
								}
							} else {
								System.out.println("Password must be at least 5 characters long ");
								System.out.println("and contain at least one Uppercase Character, Lowercase Character, one number,");
								System.out.println("and one of the following characters :[! @ # $ % &]\n");
							}
						}
						logger.info("Employee #" + empID + " username and password has been updated...");
						System.out.println("Employee #" + empID + " username and password has been updated...");
						bank.updateEmployeeUsernamePassword(empID, newUsername, newPassword);
						break;

						

					case 2:
						System.out.println("Current Employee Title: " + updatingEmployee.getTitle());
						System.out.println("What would you like the new title to be?");
						System.out.println("[1] Admin");
						System.out.println("[0] Employee");
						int titleChoice = getInput(1);
						String newTitle;
						if (titleChoice == 1) {
							newTitle = "Admin";
						} else {
							newTitle = "Employee";
						}
						bank.updateEmployeeTitle(empID, newTitle);
						logger.info("Employee #" + empID + " title has been updated...");
						System.out.println("Employee #" + empID + " title has been updated...");
						break;
					case 3:
						System.out.println("Warning: This cannot be undone");
						System.out.println("[1] Yes");
						System.out.println("[0] No");
						userID = getInput(1);
							if (userID == 1) {
								logger.info("Admin has deleted empID #" + empID +"...");
								bank.deleteEmployee(empID);
								valid = true;
							} else {
								logger.info("Admin has cancelled deletion process...");	
								break;
							}
						break;
					}
					
					
					
					
					
					
				
					
				} else if(empID != -1) {
					logger.info("Admin tried to access an Employee account that does not exist...");
					System.out.println("Employee ID #" + empID + " does not exist");
					System.out.println("Returning to Admin Main Menu...");
					break;
				} else {
					String newUsername = null;
					valid = false;
					while (!valid) {
						System.out.print("Enter New Username: ");
						newUsername = userInput.nextLine();
						if (newUsername.length()>=5) {
							if (bank.employeeUsernameCheck(newUsername) == true) {
								valid = true;
							} else if (newUsername.equalsIgnoreCase("exit")) {
								System.out.println("Returning to Login Selection Menu...");
								return;
							} else {
								System.out.println(newUsername + " is already taken, please use a different login...");
								System.out.println("To exit updating the username/password, type [exit]...");
							}
						} else {
							System.out.println("Username must be at least 5 characters long");
						}
					}
					valid = false;
					String newPassword = null;
					while(!valid) {
						System.out.print("Please create a password: ");
						newPassword = userInput.nextLine();
						final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%&])(?=.*\\d).+$");
						if (newPassword.length() >= 5) {
							if (textPattern.matcher(newPassword).matches()) {
								valid = true;
								
							} else {
								System.out.println("Password must contain at least one Uppercase Character, Lowercase Character, one number,");
								System.out.println("and one of the following characters :[! @ # $ % &]\n");
							}
						} else {
							System.out.println("Password must be at least 5 characters long ");
							System.out.println("and contain at least one Uppercase Character, Lowercase Character, one number,");
							System.out.println("and one of the following characters :[! @ # $ % &]\n");
						}
					}
					System.out.println("What is this employee's title?");
					System.out.println("[1] Admin");
					System.out.println("[0] Employee");
					int titleChoice = getInput(1);
					String newTitle;
					if (titleChoice == 1) {
						newTitle = "Admin";
					} else {
						newTitle = "Employee";
					}
					logger.info("New Employee created...");
					System.out.println("New Employee created...");
					bank.createEmployeeUsernamePassword(newUsername, newPassword, newTitle);
					break;
				}
				
				
				
				
				
				break;
			}
		}
	}
	
	private void printEmployeeList() {
		EmployeeList employeeList = bank.getAllEmployees();
		System.out.println("Here is a list of all the employees:\n");
		for (int i = 0; i < employeeList.getEmpID().size(); i++) {
			System.out.println("User ID #" + employeeList.getEmpID().get(i) + ":");
			System.out.println("     Username: " + employeeList.getUsername().get(i));
			System.out.print("     Password: ");
			for (int j = 0; j < employeeList.getPassword().get(i).length(); j++) {
				if (j == 0) {
					System.out.print(employeeList.getPassword().get(i).charAt(j));
				} else {
					System.out.print("*");
				}
			}
			System.out.println("\n     Title: " + employeeList.getTitle().get(i));		
		}
		
		
	}

	void printAdminMenu() {
		logger.info("Opening Admin Menu...");
		System.out.println("\n-------------------------------------------------------");
		System.out.println("                     Welcome Admin!                    ");
		System.out.println("-------------------------------------------------------");
		System.out.println("\nPlease make a selection: ");
		System.out.println("[1] Approve Accounts");
		System.out.println("[2] Edit Customer Information");
		System.out.println("[3] Cancel Customer Account");
		System.out.println("[4] Edit Employee Information");
		System.out.println("[0] Log Out");
		
	}

}
