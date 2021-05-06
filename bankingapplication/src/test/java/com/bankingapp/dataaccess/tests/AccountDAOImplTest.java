package com.bankingapp.dataaccess.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bankingapp.business.BusinessException;
import com.bankingapp.dataaccess.AccountDAOImpl;
import com.bankingapp.dataaccess.DAOException;
import com.bankingapp.entities.*;

@TestInstance(Lifecycle.PER_CLASS)
class AccountDAOImplTest {

	@Mock
	Connection connection;

	@Mock
	PreparedStatement preparedStatement;

	@Mock
	ResultSet results;

	@BeforeEach
	void initializeTest() throws DAOException, SQLException {
		MockitoAnnotations.openMocks(this);
		when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
		when(preparedStatement.executeQuery()).thenReturn(results);
		when(results.getInt(any(int.class))).thenReturn((new Random().nextInt(5) + 1));
		when(results.getString(any(int.class))).thenReturn("test string");
		when(results.getTimestamp(any(int.class))).thenReturn(java.sql.Timestamp.valueOf(LocalDateTime.now()));
		when(results.next()).thenReturn(true, true, true, false);
	}

	@Test
	@DisplayName("getAll AccountTypes should return a list of account Types")
	void getAllAccountTypesShouldReturnAllAccountTypes() throws DAOException {
		// Arrange
		AccountDAOImpl accountDAO = new AccountDAOImpl(connection);

		// Act
		List<AccountType> accountTypes = accountDAO.getAllAccountTypes();

		// Assert
		assertEquals(3, accountTypes.size());
	}

	@Test
	@DisplayName("getAllAccountTypes should throw DAOException if SQLException is thrown")
	void getAllAccountTypesShouldThrowDAOException() throws DAOException, SQLException {
		// Arrange
		doThrow(SQLException.class).when(preparedStatement).executeQuery();
		AccountDAOImpl accountDAO = new AccountDAOImpl(connection);

		// Act
		Executable getAccountAllCountTypes = () -> accountDAO.getAllAccountTypes();

		// Assert
		assertThrows(DAOException.class, getAccountAllCountTypes);
	}

	@Test
	@DisplayName("getLastAccountId should return expected account Id")
	void getLastAcccountIdShouldReturnExpectedAccountId() throws DAOException, SQLException {
		// Arrange
		int expectedAccountId = 3;
		when(results.getInt(1)).thenReturn(expectedAccountId);
		AccountDAOImpl accountDAO = new AccountDAOImpl(connection);

		// Act
		int returnedAccountId = accountDAO.getLastAcccountId();

		// Assert
		assertEquals(expectedAccountId, returnedAccountId);
	}

	@Test
	@DisplayName("getLastAcccountId should throw DAOException if SQLException is thrown")
	void getLastAcccountIdShouldThrowDAOException() throws DAOException, SQLException {
		// Arrange
		doThrow(SQLException.class).when(preparedStatement).executeQuery();
		AccountDAOImpl accountDAO = new AccountDAOImpl(connection);

		// Act
		Executable getAccountAllCountTypes = () -> accountDAO.getLastAcccountId();

		// Assert
		assertThrows(DAOException.class, getAccountAllCountTypes);
	}

	@Test
	@DisplayName("saveNewAccount should save account and set valid account id")
	void saveNewAccountShouldSaveAccountAndSetValidAccountId() throws DAOException {
		// Arrange
		Account account = new Account();
		AccountType accountType = new AccountType();
		accountType.setAccountTypeId(1);
		account.setAccountType(accountType);
		account.setAccountId(-1);
		AccountDAOImpl accountDAO = new AccountDAOImpl(connection);

		// Act
		accountDAO.saveNewAccount(account, new Customer());

		// Assert
		assertTrue(account.getAccountId() != -1);
	}

	@Test
	@DisplayName("saveNewAccount should throw DAOException if SQLException is thrown")
	void saveNewAccountShouldThrowDAOException() throws DAOException, SQLException {
		// Arrange
		Account account = new Account();
		AccountType accountType = new AccountType();
		accountType.setAccountTypeId(1);
		account.setAccountType(accountType);
		doThrow(SQLException.class).when(preparedStatement).executeQuery();
		AccountDAOImpl accountDAO = new AccountDAOImpl(connection);

		// Act
		Executable getAccountAllCountTypes = () -> accountDAO.saveNewAccount(account, new Customer());

		// Assert
		assertThrows(DAOException.class, getAccountAllCountTypes);
	}

	@Test
	@DisplayName("findAccountsOfCustomer should return accounts of customer")
	void findAccountsOfCustomerShouldReturnAccountsOfCustomer() throws DAOException {
		// Arrange
		AccountDAOImpl accountDAO = new AccountDAOImpl(connection);

		// Act
		List<Account> accounts = accountDAO.findAccountsOfCustomer(new Customer());

		// Assert
		assertEquals(3, accounts.size());
	}

	@Test
	@DisplayName("updateAccount should not throw any exceptions")
	void updateAccountShouldNotThrowAnyExceptions() {
		// Arrange
		AccountDAOImpl accountDAO = new AccountDAOImpl(connection);

		// Act
		Executable updateAccount = () -> accountDAO.updateAccount(new Account());

		// Assert
		assertDoesNotThrow(updateAccount);
	}

	@Test
	@DisplayName("updateAccount should throw DAOException if SQLException is thrown")
	void updateAccountShouldThrowDAOException() throws SQLException {
		// Arrange
		doThrow(SQLException.class).when(preparedStatement).executeUpdate();
		AccountDAOImpl accountDAO = new AccountDAOImpl(connection);

		// Act
		Executable updateAccount = () -> accountDAO.updateAccount(new Account());

		// Assert
		assertThrows(DAOException.class, updateAccount);
	}

	@Test
	@DisplayName("recordTransactions should not throw any exceptions")
	void recordTransactionsShouldNotThrowAnyExceptions() {
		// Arrange
		AccountDAOImpl accountDAO = new AccountDAOImpl(connection);
		TransactionType transactionType = new TransactionType();
		transactionType.setTransactionTypeId(3);
		AccountTransaction transaction = new AccountTransaction();
		transaction.setTransactionType(transactionType);
		transaction.setCustomer(new Customer());
		transaction.setTargetAccount(new Account());
		List<AccountTransaction> transactions = Arrays.asList(transaction);
		// Act
		Executable recordTransactions = () -> accountDAO.recordTransactions(transactions);

		// Assert
		assertDoesNotThrow(recordTransactions);
	}

	@Test
	@DisplayName("recordTransactions should throw DAOException if SQLException is thrown")
	void recordTransactionsShouldThrowDAOException() throws SQLException {
		// Arrange
		doThrow(SQLException.class).when(preparedStatement).executeUpdate();
		AccountDAOImpl accountDAO = new AccountDAOImpl(connection);
		TransactionType transactionType = new TransactionType();
		transactionType.setTransactionTypeId(3);
		AccountTransaction transaction = new AccountTransaction();
		transaction.setTransactionType(transactionType);
		transaction.setCustomer(new Customer());
		transaction.setTargetAccount(new Account());

		List<AccountTransaction> transactions = Arrays.asList(transaction);
		// Act
		Executable recordTransactions = () -> accountDAO.recordTransactions(transactions);

		// Assert
		assertThrows(DAOException.class, recordTransactions);
	}

	@Test
	@DisplayName("getTransactionTypeByName should return transaction type")
	void getTransactionByNameShouldReturnTransactionType() throws DAOException {
		// Arrange
		AccountDAOImpl accountDAO = new AccountDAOImpl(connection);

		// Act
		TransactionType transactionType = accountDAO.getTransactionByName("test transaction");

		// Assert
		assertNotNull(transactionType);
	}

	@Test
	@DisplayName("getAllTransactions should return accounts of customer")
	void getAllTransactionsByCustomerShouldReturnTransactionsOfCustomer() throws DAOException {
		// Arrange
		AccountDAOImpl accountDAO = new AccountDAOImpl(connection);

		// Act
		List<AccountTransaction> transactions = accountDAO.getAllTransactionByCustomer(new Customer());

		// Assert
		assertEquals(3, transactions.size());
	}

	@Test
	@DisplayName("findAllUnapprovedAccounts should return all accounts")
	void findAllUnapprovedAccountsShouldReturnAllUnapprovedAccounts() throws DAOException {
		// Arrange
		AccountDAOImpl accountDAO = new AccountDAOImpl(connection);

		// Act
		List<Account> accounts = accountDAO.findAllUnapprovedAccounts();

		// Assert
		assertEquals(3, accounts.size());
	}

	@Test
	@DisplayName("findAllAccounts should return all accounts")
	void findAllAccountsShouldReturnAllAccounts() throws DAOException {
		// Arrange
		AccountDAOImpl accountDAO = new AccountDAOImpl(connection);

		// Act
		List<Account> accounts = accountDAO.findAllUnapprovedAccounts();

		// Assert
		assertEquals(3, accounts.size());
	}

	@Test
	@DisplayName("deleteAccount should not throw any exceptions")
	void deleteAccountShouldNotThrowAnyExceptions() {
		// Arrange
		AccountDAOImpl accountDAO = new AccountDAOImpl(connection);

		// Act
		Executable deleteAccount = () -> accountDAO.deleteAccount(new Account());

		// Assert
		assertDoesNotThrow(deleteAccount);
	}

	@Test
	@DisplayName("deleteAccount should throw DAOException if SQLException is thrown")
	void deleteAccountShouldThrowDAOException() throws SQLException {
		// Arrange
		doThrow(SQLException.class).when(preparedStatement).executeUpdate();
		AccountDAOImpl accountDAO = new AccountDAOImpl(connection);

		// Act
		Executable deleteAccount = () -> accountDAO.deleteAccount(new Account());

		// Assert
		assertThrows(DAOException.class, deleteAccount);
	}

}
