package dataaccessobject;

import java.sql.*;
import java.util.ArrayList;

import connectionutil.ConnectionUtility;
import model.AccountType;
import model.Customer;
import model.CustomerList;
import model.EmployeeList;

public class userDAOImpl implements userDAO {

	//* CRUD OPERATIONS*//
	
	// CREATE
	@Override
	public int addLogin(String firstname, String lastname, String ssn, String address, String username, String password) {
		int userID = -1;
		
		try {
			Connection connection = ConnectionUtility.getConnection();
			// Add User
			String addUserSql = "INSERT INTO bank.users(firstname, lastname, ssn, address) values (?,?,?,?)";
			PreparedStatement addUser = connection.prepareStatement(addUserSql, Statement.RETURN_GENERATED_KEYS);
			addUser.setString(1, firstname);
			addUser.setString(2, lastname);
			addUser.setString(3, ssn);
			addUser.setString(4, address);
			addUser.executeUpdate();
			ResultSet addUserResults = addUser.getGeneratedKeys();
			if(addUserResults.next()) {
				userID = addUserResults.getInt(1);
			}
			// Add Login and Link
			String addLoginSql = "INSERT INTO bank.userlogins(user_id, username, password) values (?,?,?)";
			PreparedStatement addLogin = connection.prepareStatement(addLoginSql);
			addLogin.setInt(1, userID);
			addLogin.setString(2, username);
			addLogin.setString(3, password);
			addLogin.execute();
			
			connection.close();
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());
		}
		
		return userID;
	}
	
	@Override
	public int addAccount(int userID, AccountType accountType, Double balance) {
		int accountID = -1;
		
		try {
			Connection connection = ConnectionUtility.getConnection();

			// Add Account
			String addAccountSql = "INSERT INTO bank.accounts(Type, Balance, approved) values (?,?,0)";
			PreparedStatement addAccount = connection.prepareStatement(addAccountSql, Statement.RETURN_GENERATED_KEYS);
			addAccount.setString(1, accountType.name());
			addAccount.setDouble(2, balance);
			addAccount.executeUpdate();
			ResultSet addAccountResults = addAccount.getGeneratedKeys();
			if(addAccountResults.next()) {
				accountID = addAccountResults.getInt(1);
			}
			
			// Link User to Account
			if (userID > 0 && accountID > 0) {
				String linkAccountSql = "INSERT INTO bank.mappings(map_id,user_id, account_id) values (DEFAULT,?,?)";
				PreparedStatement linkAccount = connection.prepareStatement(linkAccountSql);
				linkAccount.setInt(1, userID);
				linkAccount.setInt(2, accountID);
				linkAccount.executeUpdate();
			}
			
			
			else {
				connection.rollback();
			}
			connection.close();
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());
		}
		
		return accountID;
	}
	
	@Override
	public boolean createEmployeeUsernamePassword(String newUsername, String newPassword, String title) {
		boolean created = false;
		
		try {
			Connection connection = ConnectionUtility.getConnection();

			// Add Account
			String addEmpSql = "INSERT INTO bank.emplogins(username, password, title) values (?,?,?)";
			PreparedStatement addAccount = connection.prepareStatement(addEmpSql);
			addAccount.setString(1, newUsername);
			addAccount.setString(2, newPassword);
			addAccount.setString(3, title);
			addAccount.executeUpdate();
			created = true;
			
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());
		}
		
		return created;
	}
	// READ
	// Check to see if an account with this social security number has been created
	@Override
	public boolean ssnCheck(String ssn) {
		boolean valid = true;
		try {
			Connection connection = ConnectionUtility.getConnection();
			String ssnSql = "SELECT id "
					+ "FROM bank.users "
					+ "WHERE ssn = ?;";
			PreparedStatement login = connection.prepareStatement(ssnSql);
			login.setString(1, ssn);
			ResultSet getUserResults = login.executeQuery();
			if (getUserResults.next()) {
				valid = false;
			}
				
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());
		
		}
		return valid;
	}
	
	@Override
	public boolean userExists(int userID) {
		boolean valid = false;
		try {
			Connection connection = ConnectionUtility.getConnection();
			String idSql = "SELECT id "
					+ "FROM bank.users "
					+ "WHERE id = ?;";
			PreparedStatement login = connection.prepareStatement(idSql);
			login.setInt(1, userID);
			ResultSet getUserResults = login.executeQuery();
			if (getUserResults.next()) {
				valid = true;
			}
				
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());
		
		}
		return valid;
	}
	// Check to see if an account with this username has already been created
	@Override
	public boolean	usernameCheck(String username){
		boolean valid = true;
		try {
			Connection connection = ConnectionUtility.getConnection();
			String usernameSql = "SELECT user_id "
					+ "FROM bank.userlogins "
					+ "WHERE username = ?;";
			PreparedStatement login = connection.prepareStatement(usernameSql);
			login.setString(1, username);
			ResultSet getUserResults = login.executeQuery();
			if (getUserResults.next()) {
				valid = false;
			}
				
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());
		
		}
		return valid;
	}
	
	@Override
	public boolean	employeeUsernameCheck(String username){
		boolean valid = true;
		try {
			Connection connection = ConnectionUtility.getConnection();
			String usernameSql = "SELECT emp_id "
					+ "FROM bank.emplogins "
					+ "WHERE username = ?;";
			PreparedStatement login = connection.prepareStatement(usernameSql);
			login.setString(1, username);
			ResultSet getUserResults = login.executeQuery();
			if (getUserResults.next()) {
				valid = false;
			}
				
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());
		
		}
		return valid;
	}
	
	// Using Login Into
	@Override
	public int getAccountUsingLogin(String username, String password) {
		int userID = -1;
		try {
			Connection connection = ConnectionUtility.getConnection();
			String loginSql = "SELECT user_id "
					+ "FROM bank.userlogins "
					+ "WHERE username = ? AND password = ?";
			PreparedStatement login = connection.prepareStatement(loginSql);
			login.setString(1, username);
			login.setString(2, password);
			ResultSet getUserResults = login.executeQuery();
			if (getUserResults.next()) {
				userID = getUserResults.getInt("user_id");
			}
				
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());
		
		}
		return userID;
	}
	
	@Override
	public String getEmpAccountUsingLogin(String username, String password) {
		String empTitle = null;
		try {
			Connection connection = ConnectionUtility.getConnection();
			String loginSql = "SELECT title "
					+ "FROM bank.emplogins "
					+ "WHERE username = ? AND password = ?";
			PreparedStatement login = connection.prepareStatement(loginSql);
			login.setString(1, username);
			login.setString(2, password);
			ResultSet getUserResults = login.executeQuery();
			if (getUserResults.next()) {
				empTitle = getUserResults.getString("title");
			}
				
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());
		
		}
		return empTitle;
		
	}
	
	@Override
	public EmployeeList getEmployee(int empID) {
		EmployeeList employeeList = null;
		ArrayList<Integer> empIDList = new ArrayList<Integer>();
		ArrayList<String> usernameList = new ArrayList<String>();
		ArrayList<String> passwordList = new ArrayList<String>();
		ArrayList<String> titleList = new ArrayList<String>();
		
		try {
			Connection connection = ConnectionUtility.getConnection();
			String empSql = "SELECT emp_id, username, password, title "
					+ "FROM bank.emplogins "
					+ "WHERE emp_id = ? ";
			PreparedStatement emp = connection.prepareStatement(empSql);
			emp.setInt(1, empID);
			ResultSet getUserResults = emp.executeQuery();
			while(getUserResults.next()) {
				empIDList.add(getUserResults.getInt("emp_id"));
				usernameList.add(getUserResults.getString("username"));
				passwordList.add(getUserResults.getString("password"));
				titleList.add(getUserResults.getString("title"));
			}
				
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());
		
		}
		employeeList = new EmployeeList(empIDList, usernameList, passwordList, titleList);
		return employeeList;
	}
	
	
	@Override
	public EmployeeList getAllEmployees() {
		EmployeeList employeeList = null;
		ArrayList<Integer> empIDList = new ArrayList<Integer>();
		ArrayList<String> usernameList = new ArrayList<String>();
		ArrayList<String> passwordList = new ArrayList<String>();
		ArrayList<String> titleList = new ArrayList<String>();
		
		try {
			Connection connection = ConnectionUtility.getConnection();
			String empSql = "SELECT emp_id, username, password, title "
					+ "FROM bank.emplogins ";
			PreparedStatement emp = connection.prepareStatement(empSql);
			
			ResultSet getUserResults = emp.executeQuery();
			while(getUserResults.next()) {
				empIDList.add(getUserResults.getInt("emp_id"));
				usernameList.add(getUserResults.getString("username"));
				passwordList.add(getUserResults.getString("password"));
				titleList.add(getUserResults.getString("title"));
			}
				
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());
		
		}
		employeeList = new EmployeeList(empIDList, usernameList, passwordList, titleList);
		return employeeList;
	}
	
	@Override
	public Customer getApprovedAccount(int userID) {
		Customer customer = null;
		String firstname, lastname, ssn, address;
		ArrayList<Integer> accountIDList = new ArrayList<Integer>();
		ArrayList<AccountType> accountTypeList = new ArrayList<AccountType>();
		ArrayList<Double> balanceList = new ArrayList<Double>();
		
		try {
			Connection connection = ConnectionUtility.getConnection();
			String getUserSql = "SELECT firstname, lastname, ssn, address, account_id, type, balance "
					+ "FROM bank.users AS a JOIN bank.mappings AS b ON a.id = b.user_id "
					+ "JOIN bank.accounts AS c ON c.id = b.account_id "
					+ "WHERE a.id = ? AND approved = 1";
			PreparedStatement getUser = connection.prepareStatement(getUserSql);
			getUser.setInt(1, userID);
			ResultSet getUserResults = getUser.executeQuery();
			
			while (getUserResults.next()) {
				firstname = getUserResults.getString("firstname");
				lastname = getUserResults.getString("lastname");
				ssn = getUserResults.getString("ssn");
				address = getUserResults.getString("address");
				accountIDList.add(getUserResults.getInt("account_id"));
				balanceList.add(getUserResults.getDouble("balance"));
				accountTypeList.add(AccountType.valueOf(getUserResults.getString("type")));
				customer = new Customer(firstname, lastname, ssn, address, accountIDList, accountTypeList, balanceList);
				
			}	
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());
		
		}
		
		return customer;
	}

	@Override
	public Customer getUnapprovedAccount(int userID) {
		Customer customer = null;
		String firstname, lastname, ssn, address;
		ArrayList<Integer> accountIDList = new ArrayList<Integer>();
		ArrayList<AccountType> accountTypeList = new ArrayList<AccountType>();
		ArrayList<Double> balanceList = new ArrayList<Double>();
		
		try {
			Connection connection = ConnectionUtility.getConnection();
			String getUserSql = "SELECT firstname, lastname, ssn, address, account_id, type, balance "
					+ "FROM bank.users AS a JOIN bank.mappings AS b ON a.id = b.user_id "
					+ "JOIN bank.accounts AS c ON c.id = b.account_id "
					+ "WHERE a.id = ? AND approved = 0";
			PreparedStatement getUser = connection.prepareStatement(getUserSql);
			getUser.setInt(1, userID);
			ResultSet getUserResults = getUser.executeQuery();
			
			while (getUserResults.next()) {
				firstname = getUserResults.getString("firstname");
				lastname = getUserResults.getString("lastname");
				ssn = getUserResults.getString("ssn");
				address = getUserResults.getString("address");
				accountIDList.add(getUserResults.getInt("account_id"));
				balanceList.add(getUserResults.getDouble("balance"));
				accountTypeList.add(AccountType.valueOf(getUserResults.getString("type")));
				customer = new Customer(firstname, lastname, ssn, address, accountIDList, accountTypeList, balanceList);
				
			}	
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());
		
		}
		
		return customer;
	}
	
	@Override
	public Customer getAllUnApprovedAccount() {
		Customer customer = null;
		String firstname, lastname, ssn, address;
		ArrayList<Integer> accountIDList = new ArrayList<Integer>();
		ArrayList<AccountType> accountTypeList = new ArrayList<AccountType>();
		ArrayList<Double> balanceList = new ArrayList<Double>();
		
		try {
			Connection connection = ConnectionUtility.getConnection();
			String getUserSql = "SELECT firstname, lastname, ssn, address, account_id, type, balance "
					+ "FROM bank.users AS a JOIN bank.mappings AS b ON a.id = b.user_id "
					+ "JOIN bank.accounts AS c ON c.id = b.account_id "
					+ "WHERE approved = 0";
			PreparedStatement getUser = connection.prepareStatement(getUserSql);
			
			ResultSet getUserResults = getUser.executeQuery();
			
			while (getUserResults.next()) {
				firstname = getUserResults.getString("firstname");
				lastname = getUserResults.getString("lastname");
				ssn = getUserResults.getString("ssn");
				address = getUserResults.getString("address");
				accountIDList.add(getUserResults.getInt("account_id"));
				balanceList.add(getUserResults.getDouble("balance"));
				accountTypeList.add(AccountType.valueOf(getUserResults.getString("type")));
				customer = new Customer(firstname, lastname, ssn, address, accountIDList, accountTypeList, balanceList);
				
			}	
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());
		
		}
		
		return customer;
	}
	
	@Override
	public CustomerList getAllAccounts() {
		CustomerList customerList = null;
		ArrayList<Integer> userIDList = new ArrayList<Integer>();
		ArrayList<String> firstnameList = new ArrayList<String>();
		ArrayList<String> lastnameList = new ArrayList<String>();
		ArrayList<String> usernameList = new ArrayList<String>();
		ArrayList<String> passwordList = new ArrayList<String>();
		ArrayList<String> ssnList = new ArrayList<String>();
		ArrayList<String> addressList = new ArrayList<String>();
		ArrayList<Integer> accountIDList = new ArrayList<Integer>();
		ArrayList<AccountType> accountTypeList = new ArrayList<AccountType>();
		ArrayList<Double> balanceList = new ArrayList<Double>();
		ArrayList<Integer> approved = new ArrayList<Integer>();
		
		try {
			Connection connection = ConnectionUtility.getConnection();
			String getUserSql = "SELECT a.id, firstname, lastname, username, PASSWORD, ssn, address, account_id, type, balance, approved "
					+ "FROM bank.users AS a JOIN bank.mappings AS b ON a.id = b.user_id "
					+ "JOIN bank.accounts AS c ON c.id = b.account_id "
					+ "JOIN bank.userlogins AS d ON d.user_id = a.id;";
			PreparedStatement getUser = connection.prepareStatement(getUserSql);
			
			ResultSet getUserResults = getUser.executeQuery();
			while (getUserResults.next()) {
				userIDList.add(getUserResults.getInt("id"));
				firstnameList.add(getUserResults.getString("firstname"));
				lastnameList.add(getUserResults.getString("lastname"));
				usernameList.add(getUserResults.getString("username"));
				passwordList.add(getUserResults.getString("password"));
				ssnList.add(getUserResults.getString("ssn"));
				addressList.add(getUserResults.getString("address"));
				accountIDList.add(getUserResults.getInt("account_id"));
				balanceList.add(getUserResults.getDouble("balance"));
				approved.add(getUserResults.getInt("approved"));
				accountTypeList.add(AccountType.valueOf(getUserResults.getString("type")));
				
				customerList = new CustomerList(userIDList, firstnameList, lastnameList, usernameList, passwordList, ssnList, addressList, accountIDList, accountTypeList, balanceList, approved);
				
			}	
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());
		
		}
		
		return customerList;
	}
	
	@Override
	public Customer getJointAccounts(int userID ) {
		Customer customer = null;
		String firstname, lastname, ssn, address;
		ArrayList<Integer> accountIDList = new ArrayList<Integer>();
		ArrayList<AccountType> accountTypeList = new ArrayList<AccountType>();
		ArrayList<Double> balanceList = new ArrayList<Double>();
		
		try {
			Connection connection = ConnectionUtility.getConnection();
			String getUserSql = "SELECT firstname, lastname, ssn, address, account_id, type, balance "
					+ "FROM bank.users AS a JOIN bank.mappings AS b ON a.id = b.user_id "
					+ "JOIN bank.accounts AS c ON c.id = b.account_id "
					+ "WHERE b.joint_user_id = ? AND approved = 1";
			PreparedStatement getUser = connection.prepareStatement(getUserSql);
			getUser.setInt(1, userID);
			ResultSet getUserResults = getUser.executeQuery();
			
			while (getUserResults.next()) {
				firstname = getUserResults.getString("firstname");
				lastname = getUserResults.getString("lastname");
				ssn = getUserResults.getString("ssn");
				address = getUserResults.getString("address");
				accountIDList.add(getUserResults.getInt("account_id"));
				balanceList.add(getUserResults.getDouble("balance"));
				accountTypeList.add(AccountType.valueOf(getUserResults.getString("type")));
				customer = new Customer(firstname, lastname, ssn, address, accountIDList, accountTypeList, balanceList);
				
			}	
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());
		
		}
		
		return customer;
		
	}
	
	@Override
	public int checkSAHExists(int accountID) {
		int jointUserID = -1;
		try {
			Connection connection = ConnectionUtility.getConnection();
			String checkSAHExistsSql = "SELECT joint_user_id "
					+ "FROM bank.mappings "
					+ "WHERE account_id = ?;";
			PreparedStatement checkSAHExists = connection.prepareStatement(checkSAHExistsSql);
			checkSAHExists.setInt(1, accountID);
			ResultSet getUserResults = checkSAHExists.executeQuery();
			if (getUserResults.next()) {
				jointUserID = getUserResults.getInt("joint_user_id");
			}
				
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());
		
		}
		
		return jointUserID;
	}
	
	
	
	// Update
	@Override
	public boolean updateAccount(int accountID, double balance) {
		boolean updated = false;
		
		try {
			Connection connection = ConnectionUtility.getConnection();
			String updateBalanceSql = "UPDATE bank.accounts SET balance = ? WHERE id = ?";
			PreparedStatement updateBalance = connection.prepareStatement(updateBalanceSql);
			updateBalance.setDouble(1, balance);
			updateBalance.setInt(2, accountID);
			updateBalance.executeUpdate();
			updated = true;
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());

		}
		return updated;	
	}
	
	@Override
	public boolean updateFirstName(int userID, String updatedFirstName) {
		boolean updated = false;
		try {
			Connection connection = ConnectionUtility.getConnection();
			String updateFirstNameSql = "UPDATE bank.users SET firstname = ? WHERE id = ?";
			PreparedStatement updateFirstName = connection.prepareStatement(updateFirstNameSql);
			updateFirstName.setString(1, updatedFirstName);
			updateFirstName.setInt(2, userID);
			updateFirstName.executeUpdate();
			updated = true;
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());

		}
		return updated;
	}
	
	@Override
	public boolean updateLastName(int userID, String updatedLastName) {
		boolean updated = false;
		try {
			Connection connection = ConnectionUtility.getConnection();
			String updateLastNameSql = "UPDATE bank.users SET lastname = ? WHERE id = ?";
			PreparedStatement updateLastName = connection.prepareStatement(updateLastNameSql);
			updateLastName.setString(1, updatedLastName);
			updateLastName.setInt(2, userID);
			updateLastName.executeUpdate();
			updated = true;
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());

		}
		return updated;
	}

	@Override
	public boolean updateAddress(int userID, String updatedAddress) {
		boolean updated = false;
		try {
			Connection connection = ConnectionUtility.getConnection();
			String updateAddressSql = "UPDATE bank.users SET address = ? WHERE id = ?";
			PreparedStatement updateAddress = connection.prepareStatement(updateAddressSql);
			updateAddress.setString(1, updatedAddress);
			updateAddress.setInt(2, userID);
			updateAddress.executeUpdate();
			updated = true;
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());

		}
		return updated;
	}

	@Override
	public boolean updateUsernamePassword(int userID, String newUsername, String newPassword) {
		boolean updated = false;
		try {
			Connection connection = ConnectionUtility.getConnection();
			String updateAddressSql = "UPDATE bank.userlogins SET username = ?, password = ? WHERE user_id = ?";
			PreparedStatement updateAddress = connection.prepareStatement(updateAddressSql);
			updateAddress.setString(1, newUsername);
			updateAddress.setString(2, newPassword);
			updateAddress.setInt(3, userID);
			updateAddress.executeUpdate();
			updated = true;
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());

		}
		return updated;
	}

	@Override
	public boolean updateEmployeeUsernamePassword(int empID, String newUsername, String newPassword) {
		boolean updated = false;
		try {
			Connection connection = ConnectionUtility.getConnection();
			String updateAddressSql = "UPDATE bank.emplogins SET username = ?, password = ? WHERE emp_id = ?";
			PreparedStatement updateAddress = connection.prepareStatement(updateAddressSql);
			updateAddress.setString(1, newUsername);
			updateAddress.setString(2, newPassword);
			updateAddress.setInt(3, empID);
			updateAddress.executeUpdate();
			updated = true;
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());

		}
		return updated;
	}
	@Override
	public boolean updateEmployeeTitle(int empID, String title) {
		boolean updated = false;
		try {
			Connection connection = ConnectionUtility.getConnection();
			String updateAddressSql = "UPDATE bank.emplogins SET title = ? WHERE emp_id = ?";
			PreparedStatement updateAddress = connection.prepareStatement(updateAddressSql);
			updateAddress.setString(1, title);
			updateAddress.setInt(2, empID);
			updateAddress.executeUpdate();
			updated = true;
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());

		}
		return updated;
	}
	@Override
	public boolean acceptApproval(int accountID) {

		boolean updated = false;
		try {
			Connection connection = ConnectionUtility.getConnection();
			String acceptApprovalSQL = "UPDATE bank.accounts SET approved = 1 WHERE id = ?";
			PreparedStatement acceptApproval = connection.prepareStatement(acceptApprovalSQL);
			acceptApproval.setInt(1, accountID);
			acceptApproval.executeUpdate();
			updated = true;
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());

		}
		return updated;
	}
	
	@Override
	public boolean updateJointAccount(int userID, int accountID) {
		boolean updated = false;
		try {
			Connection connection = ConnectionUtility.getConnection();
			String updateJointAccountSQL = "UPDATE bank.mappings SET joint_user_id = ? WHERE account_id = ?";
			PreparedStatement updateJointAccount = connection.prepareStatement(updateJointAccountSQL);
			updateJointAccount.setInt(1, userID);
			updateJointAccount.setInt(2, accountID);
			updateJointAccount.executeUpdate();
			updated = true;
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());

		}
		return updated;
		
	};

	// DELETE
	@Override
	public boolean deleteAccount(int accountID) {
		boolean deleted = false;

		
		try {
			Connection connection = ConnectionUtility.getConnection();
			String deleteAccountSQL = "DELETE FROM bank.accounts WHERE id = ?";
			PreparedStatement deleteAccount = connection.prepareStatement(deleteAccountSQL);
			deleteAccount.setInt(1, accountID);
			deleteAccount.executeUpdate();
			deleted = true;
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());

		}
		return deleted;
		
	}

	@Override
	public boolean deleteUser(int userID) {
		boolean deleted = false;

		try {
			Connection connection = ConnectionUtility.getConnection();
			String deleteAccountSQL = "UPDATE bank.mappings SET joint_user_id = null WHERE joint_user_id = ?";
			PreparedStatement deleteAccount = connection.prepareStatement(deleteAccountSQL);
			deleteAccount.setInt(1, userID);
			deleteAccount.executeUpdate();
			deleted = true;
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());

		}
		
		
		try {
			Connection connection = ConnectionUtility.getConnection();
			String deleteAccountSQL = "DELETE FROM bank.users WHERE id = ?";
			PreparedStatement deleteAccount = connection.prepareStatement(deleteAccountSQL);
			deleteAccount.setInt(1, userID);
			deleteAccount.executeUpdate();
			deleted = true;
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());

		}
		return deleted;
	}

	@Override
	public boolean denyApproval(int accountID) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean deleteEmployee(int empID) {

		boolean deleted = false;
		
		try {
			Connection connection = ConnectionUtility.getConnection();
			String deleteAccountSQL = "DELETE FROM bank.emplogins WHERE emp_id = ?";
			PreparedStatement deleteAccount = connection.prepareStatement(deleteAccountSQL);
			deleteAccount.setInt(1, empID);
			deleteAccount.executeUpdate();
			deleted = true;
		} catch (SQLException e) {
			System.err.println("An error has occured: " + e.getMessage());

		}
		return deleted;	
	}



}
