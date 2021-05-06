package connectionutil;

public class BluePrint {
	/*
	 * 1. Java app and db are separate entities
	 * 	1.1 - You don't need to create everything from scratch in Java.
	 * 	1.2 - Create dummy data in DBeaver to test with.
	 * 
	 * 2. Flow for login:
	 * 	2.1 - prompt user for input (Sign up or Sign in)
	 * 	2.2 - Login
	 * 		2.2.1 - check login against db (customer/employee/admin)
	 * 		2.2.2 - if so, continue to step 3
	 * 	2.3 - Create new account
	 * 		2.3.1 - Ask for appropriate information
	 * 		2.3.2 - after creation, continue to step 3
	 * 3. Flow for app:
	 * 	3.1 - show menu options (select account or create new account)
	 * 	3.2.1 - (account selection) view account balance, deposit, withdraw
	 * 	3.2.2 - (create account) create account, create joint account 
	 */
}
