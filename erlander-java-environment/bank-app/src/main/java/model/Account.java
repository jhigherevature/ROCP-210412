package model;

import java.sql.Date;

public class Account {
	private Integer accountNumber;
	private Date applicationDate;
	private Boolean approved;
	private Date approvalDate;
	private Integer approvedByID;
	private Double balance;
	
	public Account() {}
	
	public Account(Integer accountNumber, Date applicationDate, Boolean approved, Date approvalDate, Integer approvedByID, Double balance) {
		this.setAccountNumber(accountNumber);
		this.setApplicationDate(applicationDate);
		this.setApproved(approved);
		this.setApprovalDate(approvalDate);
		this.setApprovedByID(approvedByID);
		this.setBalance(balance);
	}
	
	public Account(Date applicationDate, Boolean approved, Date approvalDate, Integer approvedByID, Double balance) {
		this.setApplicationDate(applicationDate);
		this.setApproved(approved);
		this.setApprovalDate(approvalDate);
		this.setApprovedByID(approvedByID);
		this.setBalance(balance);
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date date) {
		this.applicationDate = date;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public Integer getApprovedByID() {
		return approvedByID;
	}

	public void setApprovedByID(Integer approvedByID) {
		this.approvedByID = approvedByID;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
