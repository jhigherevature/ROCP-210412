package test;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import model.AccountType;
import model.Customer;

public class CustomerObjectServiceTest {
	
	@Test
	public void shouldCreateCustomerAndReturnFirstName() {
		//Given
		String firstname = "John";
		String lastname = null;
		String ssn = null;
		String address = null;
		ArrayList<Integer> accountIDList = null;
		ArrayList<AccountType> accountTypeList = null;
		ArrayList<Double> balanceList = null;
		
		//When
		Customer customer = new Customer(firstname,lastname,ssn,address,accountIDList,accountTypeList,balanceList);
		
		//Then
		Assert.assertTrue(customer.getFirstname().equals(firstname));
	}
	
	@Test
	public void shouldCreateCustomerAndReturnLastName() {
		//Given
		String firstname = null;
		String lastname = "Doe";
		String ssn = null;
		String address = null;
		ArrayList<Integer> accountIDList = null;
		ArrayList<AccountType> accountTypeList = null;
		ArrayList<Double> balanceList = null;
		
		//When
		Customer customer = new Customer(firstname,lastname,ssn,address,accountIDList,accountTypeList,balanceList);
		
		//Then
		Assert.assertTrue(customer.getLastname().equals(lastname));
	}
	
	@Test
	public void shouldCreateCustomerAndReturnSSN() {
		//Given
		String firstname = null;
		String lastname = null;
		String ssn = "123456789";
		String address = null;
		ArrayList<Integer> accountIDList = null;
		ArrayList<AccountType> accountTypeList = null;
		ArrayList<Double> balanceList = null;
		
		//When
		Customer customer = new Customer(firstname,lastname,ssn,address,accountIDList,accountTypeList,balanceList);
		
		//Then
		Assert.assertTrue(customer.getSsn().equals(ssn));
	}
	
	@Test
	public void shouldCreateCustomerAndReturnAddress() {
		//Given
		String firstname = null;
		String lastname = null;
		String ssn = null;
		String address = "123 Test Road";
		ArrayList<Integer> accountIDList = null;
		ArrayList<AccountType> accountTypeList = null;
		ArrayList<Double> balanceList = null;
		
		//When
		Customer customer = new Customer(firstname,lastname,ssn,address,accountIDList,accountTypeList,balanceList);
		
		//Then
		Assert.assertTrue(customer.getAddress().equals(address));
	}
	
	@Test
	public void shouldCreateCustomerAndReturnAccountIDList() {
		//Given
		String firstname = null;
		String lastname = null;
		String ssn = null;
		String address = null;
		ArrayList<Integer> accountIDList = new ArrayList<>(
				Arrays.asList(1,2,3,4,5));
		ArrayList<AccountType> accountTypeList = null;
		ArrayList<Double> balanceList = null;
		
		//When
		Customer customer = new Customer(firstname,lastname,ssn,address,accountIDList,accountTypeList,balanceList);
		
		//Then
		Assert.assertTrue(customer.getAccountID().equals(accountIDList));
	}
	
	@Test
	public void shouldCreateCustomerAndReturnAccountTypeList() {
		//Given
		String firstname = null;
		String lastname = null;
		String ssn = null;
		String address = null;
		ArrayList<Integer> accountIDList = null;
		ArrayList<AccountType> accountTypeList = new ArrayList<>(
				Arrays.asList(AccountType.Checking,AccountType.Savings));
		ArrayList<Double> balanceList = null;
		
		//When
		Customer customer = new Customer(firstname,lastname,ssn,address,accountIDList,accountTypeList,balanceList);
		
		//Then
		Assert.assertTrue(customer.getAccountType().equals(accountTypeList));
	}
	
	@Test
	public void shouldCreateCustomerAndReturnBalanceList() {
		//Given
		String firstname = null;
		String lastname = null;
		String ssn = null;
		String address = null;
		ArrayList<Integer> accountIDList = null;
		ArrayList<AccountType> accountTypeList = null;
		ArrayList<Double> balanceList = new ArrayList<>(
				Arrays.asList(100.2, 0.1, 345123211267.13, 0.0));
		
		//When
		Customer customer = new Customer(firstname,lastname,ssn,address,accountIDList,accountTypeList,balanceList);
		
		//Then
		Assert.assertTrue(customer.getBalance().equals(balanceList));
	}
	
	@Test
	public void shouldCreateCustomerAndSetAccountIDToNull() {
		//Given
		String firstname = null;
		String lastname = null;
		String ssn = null;
		String address = null;
		ArrayList<Integer> accountIDList = new ArrayList<>(
				Arrays.asList(1,2,3,4,5));
		ArrayList<AccountType> accountTypeList = null;
		ArrayList<Double> balanceList = null;
		
		//When
		Customer customer = new Customer(firstname,lastname,ssn,address,accountIDList,accountTypeList,balanceList);
		customer.setNullAccountID();
		//Then
		Assert.assertTrue(customer.getAccountID()==null);
	}
	
	@Test
	public void shouldCreateCustomerAndSetAccountTypeToNull() {
		//Given
				String firstname = null;
				String lastname = null;
				String ssn = null;
				String address = null;
				ArrayList<Integer> accountIDList = null;
				ArrayList<AccountType> accountTypeList = new ArrayList<>(
						Arrays.asList(AccountType.Checking,AccountType.Savings));
				ArrayList<Double> balanceList = null;
				
				//When
				Customer customer = new Customer(firstname,lastname,ssn,address,accountIDList,accountTypeList,balanceList);
				customer.setNullAccountType();
				//Then
				Assert.assertTrue(customer.getAccountType()==null);
	}
	
	@Test
	public void shouldCreateCustomerAndSetBalanceToNull() {
		//Given
		String firstname = null;
		String lastname = null;
		String ssn = null;
		String address = null;
		ArrayList<Integer> accountIDList = null;
		ArrayList<AccountType> accountTypeList = null;
		ArrayList<Double> balanceList = new ArrayList<>(
				Arrays.asList(100.2, 0.1, 345123211267.13, 0.0));
		
		//When
		Customer customer = new Customer(firstname,lastname,ssn,address,accountIDList,accountTypeList,balanceList);
		customer.setNullBalance();
		//Then
		Assert.assertTrue(customer.getBalance()==null);
	}	
	
}

