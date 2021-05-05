package com.bankingapp.business.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bankingapp.business.AccountServiceImpl;
import com.bankingapp.business.BusinessException;
import com.bankingapp.business.CustomerServiceImpl;
import com.bankingapp.dataaccess.AccountDAO;
import com.bankingapp.dataaccess.DAOException;
import com.bankingapp.entities.*;

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
	void createNewCustomerShouldThrowBusinessException() throws DAOException, BusinessException {
		// Arrange
		AccountType accountType = new AccountType();
		Customer customer = new Customer();
		Account account = new Account();
		doThrow(DAOException.class).when(accountDAO).saveNewAccount(any(Account.class), any(Customer.class));
		AccountServiceImpl customerServiceImpl = new AccountServiceImpl(accountDAO);

		// Act

		// Assert
		assertThrows(BusinessException.class, () -> customerServiceImpl.createNewAccount(accountType, 10.0, customer));
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
}
