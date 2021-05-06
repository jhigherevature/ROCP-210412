package model;

public class Account {

	private int account_id;
	private double account_balance;
	private int cust_id1;
	private int cust_id2;
	
	public Account(int account_id, double account_balance, int cust_id1, int cust_id2)
	{
		this.account_id = account_id;
		this.account_balance = account_balance;
		this.cust_id1 = cust_id1;
		this.cust_id2 = cust_id2;
	}
	
	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", account_balance=" + account_balance + ", cust_id1=" + cust_id1
				+ ", cust_id2=" + cust_id2 + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(account_balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + account_id;
		result = prime * result + cust_id1;
		result = prime * result + cust_id2;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Double.doubleToLongBits(account_balance) != Double.doubleToLongBits(other.account_balance))
			return false;
		if (account_id != other.account_id)
			return false;
		if (cust_id1 != other.cust_id1)
			return false;
		if (cust_id2 != other.cust_id2)
			return false;
		return true;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public double getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}
	public int getCust_id1() {
		return cust_id1;
	}
	public void setCust_id1(int cust_id1) {
		this.cust_id1 = cust_id1;
	}
	public int getCust_id2() {
		return cust_id2;
	}
	public void setCust_id2(int cust_id2) {
		this.cust_id2 = cust_id2;
	}
}