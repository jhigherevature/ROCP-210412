package model;

import java.util.ArrayList;

public class Customer {
	private final String firstname;
	private final String lastname;
	private final String ssn;
	private final String address;
	private ArrayList<AccountType> accountType;
	private ArrayList<Double> balance;
	private ArrayList<Integer> accountID;
	
	public Customer(String firstname, String lastname, String ssn, String address,
			ArrayList<Integer> accountIDList, ArrayList<AccountType> accountTypeList, ArrayList<Double> balanceList) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.ssn = ssn;
		this.address = address;
		this.accountID = accountIDList;
		this.accountType = accountTypeList;
		this.balance = balanceList;
	}


	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getSsn() {
		return ssn;
	}
	
	public ArrayList<Integer> getAccountID() {
		return accountID;
	}
	public ArrayList<AccountType> getAccountType() {
		return accountType;
	}
	
	public ArrayList<Double> getBalance() {
		return balance;
	}
	public String getAddress() {
		return address;
	}
	
	public void setNullAccountID() {
		this.accountID = null;
	}
	
	public void setNullAccountType() {
		this.accountType = null;
	}
	
	public void setNullBalance() {
		this.balance = null;
	}

}
