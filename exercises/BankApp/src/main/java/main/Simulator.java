package main;

import java.util.Scanner;

import dataaccessobject.CustomerDAOImpl;
import dataaccessobject.LoginDAOImpl;
import model.Account;
import model.Customer;
import model.Login;

public class Simulator {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int userInput;
		String username;
		String password;
		LoginDAOImpl LoginDAO = new LoginDAOImpl();
		CustomerDAOImpl cDAO = new CustomerDAOImpl();
		Login log = null;
		String name;
		int id = 1;
		double amount;
		double accountBalance;
		double amountToInsert;
		
		do
		{
			System.out.println("Do you have an account with us? 1 - Yes, 2 - No.");
			userInput = console.nextInt();
				
			if(userInput == 1)
			{
				System.out.println("Please enter your username.");
				username = console.next();
				System.out.println("Please enter your password.");
				password = console.next();
				log = LoginDAO.selectLoginByUserAndPass(username, password);
			}
			else
			{
				System.out.println("Create an Account");
				System.out.println("Pick a username.");
				username = console.next();
				System.out.println("Pick a password.");
				password = console.next();
				System.out.println("Enter your name.");
				name = console.next();
				Account acc = new Account(id, 0, id, 0);
				cDAO.insertIntoAccounts(acc);
				Customer cust = new Customer(id, name, id);
				cDAO.insertIntoCustomers(cust);
				Login newLogin = new Login(id, username, password);
				cDAO.insertIntoLogin(newLogin);
				id++;
				log = LoginDAO.selectLoginByUserAndPass(username, password);
			}
			
			do
			{
				
				System.out.println("Press 1 - to Deposit, 2 - Withdraw.");
				userInput = console.nextInt();
					
				if(userInput == 1)
				{
					System.out.println("Enter amount to deposit.");
					amount = console.nextDouble();
					int currentid = log.getLogin_id();
					if(amount < 0)
					{
						System.out.println("Error: Can't Deposit a negative value.");
						break;
					}
					Account account = cDAO.selectAccount(currentid);
					accountBalance = account.getAccount_balance();
					amountToInsert = accountBalance + amount;
					cDAO.updateAccount(currentid, amountToInsert);
				}
				else
				{
					System.out.println("Enter amount to withdraw.");
					amount = console.nextDouble();
					int currentid = log.getLogin_id();
					if(amount < 0)
					{
						System.out.println("Error: Can't withdraw a negative value");
						break;
					}
					Account account = cDAO.selectAccount(currentid);
					accountBalance = account.getAccount_balance();
					if(amount > accountBalance)
					{
						System.out.println("Error: Can't withdraw more than you have.");
						break;
					}
					amountToInsert = accountBalance - amount;
					cDAO.updateAccount(currentid, amountToInsert);
				}
				System.out.println("Enter 1 to Create new account/Login, 2 to deposit/withdraw again, any other key to exit");
				userInput = console.nextInt();
			}
			while(userInput == 2);
		}
		while(userInput == 1);
	}
}