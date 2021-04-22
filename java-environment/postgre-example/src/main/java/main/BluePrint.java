package main;

/*
 * This class is used to provide you with notes/information
 * about the general flow of your project
 */
public class BluePrint {
	/*
	 * 1. Your Java Application and your Postgre Database are
	 * 		separate entities
	 * 		1.1 - You do not need to create everything from scratch
	 * 				in Java....
	 * 		1.2 - Make sure to create dummy data to test with!
	 * 
	 * 2. Flow for Login:
	 * 		2.1 - Prompt the user for some input to decide whether
	 * 				they want to 'create new login/register' OR
	 * 				'login to their current account'
	 * 		2.2	- Login
	 * 				2.2.1 - Check the login information provided
	 * 						against the DB
	 * 				2.2.2 - If so, continue to step '3'
	 * 
	 * 		2.3 - Create new Account
	 * 				2.3.1 - Ask the user for the appropriate fields
	 * 				2.3.2 - After the account has successfully been
	 * 						created, move to step '3'
	 * 3. Flow for App (customer)
	 * 		3.1 - Show menu options
	 * 				- 'select account'
	 * 					- query DB for all accounts first
	 * 				
	 * 				- view account balance
	 * 					- query DB based on user input
	 * 				- deposit to account
	 * 					- query DB based on user input
	 * 				- withdraw from account
	 * 					- query DB based on user input
	 * 
	 * 4 - Managing 'Login'
	 * 		-If you create a class/static field in your simulator
	 * 		that will keep a record of the current user's id,
	 * 		this will give you easy ability to reference that user's
	 * 		account info/other important data, more easily.
	 * 			static int currentLoggedInId = 1006;
	 * 
	 */
}
