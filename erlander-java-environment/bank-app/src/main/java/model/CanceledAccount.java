package model;

import java.sql.Date;

public class CanceledAccount extends Account{
	private Integer canceledByID;
	private Date canceledDate;
	
	private CanceledAccount() {
		super();
	}
	
	private CanceledAccount(Integer accountNumber, Date applicationDate, Boolean approved, Date approvalDate, Integer approvedByID, Double balance, Integer canceledByID, Date canceledDate) {
		super(accountNumber, applicationDate, approved, approvalDate, approvedByID, balance);
		this.setCanceledByID(canceledByID);
		this.setCanceledDate(canceledDate);
	}

	public Integer getCanceledByID() {
		return canceledByID;
	}

	public void setCanceledByID(Integer canceledByID) {
		this.canceledByID = canceledByID;
	}

	public Date getCanceledDate() {
		return canceledDate;
	}

	public void setCanceledDate(Date canceledDate) {
		this.canceledDate = canceledDate;
	}
	
}
