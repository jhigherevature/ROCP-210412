package model;

import java.sql.Timestamp;

public class Transaction {
	private Integer transactionID;
	private Integer accountID;
	private Integer userID;
	private String transactionType;
	private Double amount;
	private Timestamp timestamp;
	
	public Transaction() {}
	
	public Transaction(Integer transactionID, Integer userID, String transactionType, Double amount, Timestamp timestamp, Integer accountID) {
		this.setTransactionID(transactionID);
		this.setAccountID(accountID);
		this.setTransactionType(transactionType);
		this.setAmount(amount);
		this.setTimestamp(timestamp);
	}
	
	public Transaction(Integer userID, String transactionType, Double amount, Timestamp timestamp, Integer accountID) {
		this.setAccountID(accountID);
		this.setUserID(userID);
		this.setTransactionType(transactionType);
		this.setAmount(amount);
		this.setTimestamp(timestamp);
	}

	public Integer getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(Integer transactionID) {
		this.transactionID = transactionID;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getAccountID() {
		return accountID;
	}

	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
}
