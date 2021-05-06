package com.bankingapp.business.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bankingapp.business.AccountServiceImpl;
import com.bankingapp.business.BusinessException;
import com.bankingapp.dataaccess.AccountDAO;
import com.bankingapp.dataaccess.DAOException;
import com.bankingapp.entities.Account;
import com.bankingapp.entities.AccountTransaction;
import com.bankingapp.entities.AccountType;
import com.bankingapp.entities.Customer;
import com.bankingapp.entities.TransactionType;

@TestInstance(Lifecycle.PER_CLASS)
class AccountServiceImplTest {

	@Mock
	AccountDAO accountDAO;

	@BeforeEach
	void initializeTest() throws DAOException {
		MockitoAnnotations.openMocks(this);
		TransactionType transactionType = new TransactionType();
		transactionType.setTransactonTypeName("test transaction");
		when(accountDAO.getTransactionByName(any(String.class))).thenReturn(transactionType);
	}

	@Test
	@DisplayName("CreateNewAccount should return new account")
	void createNewAccountShouldReturnNonNullAccount() throws DAOException, BusinessException {
		// Arrange
		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		Account returnedAccount = accountServiceImpl.createNewAccount(new AccountType(), 10.0, new Customer());

		// Assert
		assertEquals(10, returnedAccount.getAccountBalance());
	}

	@Test
	@DisplayName("CreateNewAccount should throw BusinessException if DAOException is thrown")
	void createNewAccountShouldThrowBusinessException() throws DAOException, BusinessException {
		// Arrange
		AccountType accountType = new AccountType();
		Customer customer = new Customer();
		doThrow(DAOException.class).when(accountDAO).saveNewAccount(any(Account.class), any(Customer.class));
		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		Executable createNewAccount = () -> accountServiceImpl.createNewAccount(accountType, 10.0, customer);

		// Assert
		assertThrows(BusinessException.class, createNewAccount);
	}

	@Test
	@DisplayName("depositModey should increase balance on account")
	void depositMoneyShouldIncreaseAccountBalance() throws DAOException, BusinessException {
		// Arrange
		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);
		Account account = new Account();
		account.setAccountBalance(10);

		// Act
		accountServiceImpl.depositMoney(account, new Customer(), 10.0);

		// Assert
		assertEquals(20.0, account.getAccountBalance());
	}

	@Test
	@DisplayName("depositMoney should throw BusinessException if DAOException is thrown")
	void depositMoneyShouldThrowBusinessException() throws DAOException, BusinessException {
		// Arrange
		doThrow(DAOException.class).when(accountDAO).updateAccount(any(Account.class));

		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		Executable depositMoney = () -> accountServiceImpl.depositMoney(new Account(), new Customer(), 20);
		// Assert
		assertThrows(BusinessException.class, depositMoney);
	}

	@Test
	@DisplayName("withdrawModey should decrease balance on account")
	void withdrawMoneyShouldDecreaseAccountBalance() throws DAOException, BusinessException {
		// Arrange
		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);
		Account account = new Account();
		account.setAccountBalance(20);

		// Act
		accountServiceImpl.withdrawMoney(account, new Customer(), 10.0);

		// Assert
		assertEquals(10.0, account.getAccountBalance());
	}

	@Test
	@DisplayName("withdrawMoney should disallow overdrawing an account")
	void withdrawMoneyShouldDisallowOverDraft() throws DAOException, BusinessException {
		// Arrange
		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);
		Account account = new Account();
		account.setAccountBalance(20);

		// Act
		accountServiceImpl.withdrawMoney(account, new Customer(), 30.0);

		// Assert
		assertEquals(20.0, account.getAccountBalance());
	}

	@Test
	@DisplayName("withdrawMoney should throw BusinessException if DAOException is thrown")
	void withdrawMoneyShouldThrowBusinessException() throws DAOException, BusinessException {
		// Arrange
		Account account = new Account();
		account.setAccountBalance(20);
		doThrow(DAOException.class).when(accountDAO).updateAccount(any(Account.class));

		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		Executable withDrawMoney = () -> accountServiceImpl.withdrawMoney(account, new Customer(), 10);

		// Assert
		assertThrows(BusinessException.class, withDrawMoney);
	}

	@Test
	@DisplayName("transferMoney should deduct from source account and add to target account")
	void transferMoneyShouldDeductFromSourceAndAddToTargetAccounts() throws DAOException, BusinessException {
		// Arrange
		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);
		Account sourceAccount = new Account();
		sourceAccount.setAccountBalance(20);
		Account targetAccount = new Account();
		targetAccount.setAccountBalance(20);

		// Act
		accountServiceImpl.transferMoney(sourceAccount, targetAccount, new Customer(), 10.0);

		// Assert
		assertTrue(sourceAccount.getAccountBalance() == 10.0 && targetAccount.getAccountBalance() == 30.0);
	}

	@Test
	@DisplayName("transferMoney should not overdraw from source account")
	void transferMoneyShouldNotOverdrawOnSourceAccount() throws DAOException, BusinessException {
		// Arrange
		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);
		Account sourceAccount = new Account();
		sourceAccount.setAccountBalance(20);
		Account targetAccount = new Account();
		targetAccount.setAccountBalance(20);

		// Act
		accountServiceImpl.transferMoney(sourceAccount, targetAccount, new Customer(), 30.0);

		// Assert
		assertTrue(sourceAccount.getAccountBalance() == 20.0);
	}

	@Test
	@DisplayName("transferMoney should throw BusinessException if DAOException is thrown")
	void transferMoneyShouldThrowBusinessException() throws DAOException, BusinessException {
		// Arrange
		Account sourceAccount = new Account();
		sourceAccount.setAccountBalance(20);
		Account targetAccount = new Account();
		targetAccount.setAccountBalance(20);
		doThrow(DAOException.class).when(accountDAO).updateAccount(any(Account.class));

		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		Executable transferMoney = () -> accountServiceImpl.transferMoney(sourceAccount, targetAccount, new Customer(),
				10.0);

		// Assert
		assertThrows(BusinessException.class, transferMoney);
	}

	@Test
	@DisplayName("findAllAccounts should return all accounts")
	void findAllAccountsShouldReturnAllAccounts() throws DAOException, BusinessException {
		// Arrange
		List<Account> accounts = Arrays.asList(new Account(), new Account(), new Account());
		when(accountDAO.findAllAccounts()).thenReturn(accounts);

		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		List<Account> returnedAccounts = accountServiceImpl.findAllAccounts();

		// Assert
		assertEquals(accounts, returnedAccounts);
	}

	@Test
	@DisplayName("findAllAccounts should throw BusinessException if DAOException is thrown")
	void findAllAccountsShouldThrowBusinessException() throws DAOException, BusinessException {
		// Arrange
		doThrow(DAOException.class).when(accountDAO).findAllAccounts();

		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		Executable findAllAccounts = () -> accountServiceImpl.findAllAccounts();

		// Assert
		assertThrows(BusinessException.class, findAllAccounts);
	}

	@Test
	@DisplayName("findAllUnapprovedAccounts should return all unapproved accounts")
	void findAllUnApprovedAccountsShouldReturnAllUnApprovedAccounts() throws DAOException, BusinessException {
		// Arrange
		Account account1 = new Account();
		account1.setStatus("pending");

		Account account2 = new Account();
		account2.setStatus("pending");

		Account account3 = new Account();
		account3.setStatus("pending");

		List<Account> accounts = Arrays.asList(account1, account2, account3);
		when(accountDAO.findAllUnapprovedAccounts()).thenReturn(accounts);

		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		List<Account> returnedAccounts = accountServiceImpl.findAllUnapprovedAccounts();

		// Assert
		assertEquals(accounts, returnedAccounts);
	}

	@Test
	@DisplayName("findAllUnapprovedAccounts should throw BusinessException if DAOException is thrown")
	void findAllUnapprovedAccountsShouldThrowBusinessException() throws DAOException, BusinessException {
		// Arrange
		doThrow(DAOException.class).when(accountDAO).findAllUnapprovedAccounts();

		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		Executable findUApprovedAccounts = () -> accountServiceImpl.findAllUnapprovedAccounts();

		// Assert
		assertThrows(BusinessException.class, findUApprovedAccounts);
	}

	@Test
	@DisplayName("getAllAccountTypes should return all accountTypes")
	void getAllAccountTypesShouldReturnAllAccountTypes() throws DAOException, BusinessException {
		// Arrange
		List<AccountType> accountTypes = Arrays.asList(new AccountType(), new AccountType(), new AccountType());
		when(accountDAO.getAllAccountTypes()).thenReturn(accountTypes);

		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		List<AccountType> returnedAccountTypes = accountServiceImpl.getAllAccountTypes();

		// Assert
		assertEquals(accountTypes, returnedAccountTypes);
	}

	@Test
	@DisplayName("getAllAccountTypes should throw BusinessException if DAOException is thrown")
	void getAllAccountTypesShouldThrowBusinessException() throws DAOException, BusinessException {
		// Arrange
		doThrow(DAOException.class).when(accountDAO).getAllAccountTypes();

		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		Executable getAllAccountTypes = () -> accountServiceImpl.getAllAccountTypes();

		// Assert
		assertThrows(BusinessException.class, getAllAccountTypes);
	}

	@Test
	@DisplayName("findAccountsOfCustomer should return accounts of customer")
	void findAccountsOfCustomerShouldReturnAccountsOfCustomer() throws DAOException, BusinessException {
		// Arrange
		List<Account> accounts = Arrays.asList(new Account(), new Account(), new Account());
		Customer customer = new Customer();
		when(accountDAO.findAccountsOfCustomer(customer)).thenReturn(accounts);

		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		List<Account> returnedAccounts = accountServiceImpl.findAccountsOfCustomer(customer);

		// Assert
		assertEquals(accounts, returnedAccounts);
	}

	@Test
	@DisplayName("findAccountsOfCustomer should throw BusinessException if DAOException is thrown")
	void findAccountsOfCustomerShouldThrowBusinessException() throws DAOException, BusinessException {
		// Arrange
		Customer customer = new Customer();
		doThrow(DAOException.class).when(accountDAO).findAccountsOfCustomer(customer);

		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		Executable findAccountsOfCustomer = () -> accountServiceImpl.findAccountsOfCustomer(customer);

		// Assert
		assertThrows(BusinessException.class, findAccountsOfCustomer);
	}

	@Test
	@DisplayName("recordTransactions should throw BusinessException if DAOException is thrown")
	void recordTransactionsShouldThrowBusinessException() throws DAOException, BusinessException {
		// Arrange
		doThrow(DAOException.class).when(accountDAO).recordTransactions(any());
		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		Executable recordTransactions = () -> accountServiceImpl.recordTransactions(new Account(), new Account(),
				10.0, "test transaction", new Customer());

		// Assert
		assertThrows(BusinessException.class, recordTransactions);
	}

	@Test
	@DisplayName("updateAccount should not throw any exceptions")
	void updateAccountShouldNotThrowAnyExceptions() throws DAOException, BusinessException {
		// Arrange
		doNothing().when(accountDAO).updateAccount(any(Account.class));
		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		Executable updateAccount = () -> accountServiceImpl.updateAccount(new Account());

		// Assert
		assertDoesNotThrow(updateAccount);
	}

	@Test
	@DisplayName("updateAccount should throw BusinessException if DAOException is thrown")
	void updateAccountShouldThrowBusinessException() throws DAOException, BusinessException {
		// Arrange
		doThrow(DAOException.class).when(accountDAO).updateAccount(any(Account.class));
		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		Executable updateAccount = () -> accountServiceImpl.updateAccount(new Account());

		// Assert
		assertThrows(BusinessException.class, updateAccount);
	}

	@Test
	@DisplayName("removeAccount should not throw any exceptions")
	void removeAccountShouldNotThrowAnyExceptions() throws DAOException, BusinessException {
		// Arrange
		doNothing().when(accountDAO).deleteAccount(any(Account.class));
		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		Executable removeAccount = () -> accountServiceImpl.removeAccount(new Account());

		// Assert
		assertDoesNotThrow(removeAccount);
	}

	@Test
	@DisplayName("removeAccount should throw BusinessException if DAOException is thrown")
	void removeAccountShouldThrowBusinessException() throws DAOException, BusinessException {
		// Arrange
		doThrow(DAOException.class).when(accountDAO).deleteAccount(any(Account.class));
		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		Executable removeAccount = () -> accountServiceImpl.removeAccount(new Account());

		// Assert
		assertThrows(BusinessException.class, removeAccount);
	}

	@Test
	@DisplayName("getAllTransactionsOfCustomer should return accounts of customer")
	void getAllTransactionsOfCustomerShouldReturnTransactionsOfCustomer() throws DAOException, BusinessException {
		// Arrange
		List<AccountTransaction> transactions = Arrays.asList(new AccountTransaction(), new AccountTransaction(),
				new AccountTransaction());
		Customer customer = new Customer();
		when(accountDAO.getAllTransactionByCustomer(customer)).thenReturn(transactions);

		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		List<AccountTransaction> returnedTransactions = accountServiceImpl.getAllTransactionByCustomer(customer);

		// Assert
		assertEquals(transactions, returnedTransactions);
	}

	@Test
	@DisplayName("getAllTransactionsOfCustomer should throw BusinessException if DAOException is thrown")
	void getAllTransactionsOfCustomerShouldThrowBusinessException() throws DAOException, BusinessException {
		// Arrange
		Customer customer = new Customer();
		doThrow(DAOException.class).when(accountDAO).getAllTransactionByCustomer(customer);

		AccountServiceImpl accountServiceImpl = new AccountServiceImpl(accountDAO);

		// Act
		Executable getAllTransactionsByCustomer = () -> accountServiceImpl.getAllTransactionByCustomer(customer);

		// Assert
		assertThrows(BusinessException.class, getAllTransactionsByCustomer);
	}
}
