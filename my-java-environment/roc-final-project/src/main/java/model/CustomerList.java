package model;

import java.util.ArrayList;

public class CustomerList {
	private ArrayList<Integer> userID;
	private ArrayList<String> firstname;
	private ArrayList<String> lastname;
	private ArrayList<String> username;
	private ArrayList<String> password;
	private ArrayList<String> ssn;
	private ArrayList<String> address;
	private ArrayList<AccountType> accountType;
	private ArrayList<Double> balance;
	private ArrayList<Integer> accountID;
	private ArrayList<Integer> approved;
	
	public CustomerList(ArrayList<Integer> userID, ArrayList<String> firstname, ArrayList<String> lastname,
			ArrayList<String> username,ArrayList<String> password, ArrayList<String> ssn, ArrayList<String> address,
			ArrayList<Integer> accountIDList, ArrayList<AccountType> accountTypeList, ArrayList<Double> balanceList, ArrayList<Integer> approved) {
		this.userID = userID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.ssn = ssn;
		this.address = address;
		this.accountID = accountIDList;
		this.accountType = accountTypeList;
		this.balance = balanceList;
		this.approved = approved;
	}

	public ArrayList<Integer> getuserID() {
		return userID;
	}
	public ArrayList<String> getFirstname() {
		return firstname;
	}

	public ArrayList<String> getLastname() {
		return lastname;
	}
	public ArrayList<String> getUsername() {
		return username;
	}
	public ArrayList<String> getPassword() {
		return password;
	}
	public ArrayList<String> getSsn() {
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
	public ArrayList<Integer> getApproved() {
		return approved;
	}
	public ArrayList<String> getAddress() {
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
	
//	private Integer cust_id;
//	private String cust_first;
//	private String cust_last;
//	private String cust_user;
//	private String cust_pass;
//	private Double cust_savacc;
//	private Double cust_checkacc;
//	private String cust_joindate;
//	private String cust_logindate;
//
//	
//	//* GETTERS *//
//	public Integer getCust_id() {
//		return cust_id;
//	}
//	public String getCust_first() {
//		return cust_first;
//	}
//	public String getCust_last() {
//		return cust_last;
//	}
//	public String getCust_user() {
//		return cust_user;
//	}
//	public String getCust_pass() {
//		return cust_pass;
//	}
//	public Double getCust_savacc() {
//		return cust_savacc;
//	}
//	public Double getCust_checkacc() {
//		return cust_checkacc;
//	}
//	public String getCust_joindate() {
//		return cust_joindate;
//	}
//	public String getCust_logindate() {
//		return cust_logindate;
//	}
//
//	
//	//* SETTERS *//
//	public void setCust_id(Integer cust_id) {
//		this.cust_id = cust_id;
//	}
//	public void setCust_first(String cust_first) {
//		this.cust_first = cust_first;
//	}
//	public void setCust_last(String cust_last) {
//		this.cust_last = cust_last;
//	}
//	public void setCust_user(String cust_user) {
//		this.cust_user = cust_user;
//	}
//	public void setCust_pass(String cust_pass) {
//		this.cust_pass = cust_pass;
//	}
//	public void setCust_savacc(Double cust_savacc) {
//		this.cust_savacc = cust_savacc;
//	}
//	public void setCust_checkacc(Double cust_checkacc) {
//		this.cust_checkacc = cust_checkacc;
//	}
//	public void setCust_joindate(String cust_joindate) {
//		this.cust_joindate = cust_joindate;
//	}
//	public void setCust_logindate(String cust_logindate) {
//		this.cust_logindate = cust_logindate;
//	}
//
//	//* HASH CODE OVERRIDE *//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((cust_checkacc == null) ? 0 : cust_checkacc.hashCode());
//		result = prime * result + ((cust_first == null) ? 0 : cust_first.hashCode());
//		result = prime * result + ((cust_id == null) ? 0 : cust_id.hashCode());
//		result = prime * result + ((cust_joindate == null) ? 0 : cust_joindate.hashCode());
//		result = prime * result + ((cust_last == null) ? 0 : cust_last.hashCode());
//		result = prime * result + ((cust_logindate == null) ? 0 : cust_logindate.hashCode());
//		result = prime * result + ((cust_pass == null) ? 0 : cust_pass.hashCode());
//		result = prime * result + ((cust_savacc == null) ? 0 : cust_savacc.hashCode());
//		result = prime * result + ((cust_user == null) ? 0 : cust_user.hashCode());
//		return result;
//	}
//	
//	//* EQUALS OVERRIDE *//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Customer other = (Customer) obj;
//		if (cust_checkacc == null) {
//			if (other.cust_checkacc != null)
//				return false;
//		} else if (!cust_checkacc.equals(other.cust_checkacc))
//			return false;
//		if (cust_first == null) {
//			if (other.cust_first != null)
//				return false;
//		} else if (!cust_first.equals(other.cust_first))
//			return false;
//		if (cust_id == null) {
//			if (other.cust_id != null)
//				return false;
//		} else if (!cust_id.equals(other.cust_id))
//			return false;
//		if (cust_joindate == null) {
//			if (other.cust_joindate != null)
//				return false;
//		} else if (!cust_joindate.equals(other.cust_joindate))
//			return false;
//		if (cust_last == null) {
//			if (other.cust_last != null)
//				return false;
//		} else if (!cust_last.equals(other.cust_last))
//			return false;
//		if (cust_logindate == null) {
//			if (other.cust_logindate != null)
//				return false;
//		} else if (!cust_logindate.equals(other.cust_logindate))
//			return false;
//		if (cust_pass == null) {
//			if (other.cust_pass != null)
//				return false;
//		} else if (!cust_pass.equals(other.cust_pass))
//			return false;
//		if (cust_savacc == null) {
//			if (other.cust_savacc != null)
//				return false;
//		} else if (!cust_savacc.equals(other.cust_savacc))
//			return false;
//		if (cust_user == null) {
//			if (other.cust_user != null)
//				return false;
//		} else if (!cust_user.equals(other.cust_user))
//			return false;
//		return true;
//	}
//	
//	
	
}
