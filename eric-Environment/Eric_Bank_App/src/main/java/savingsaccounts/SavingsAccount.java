package savingsaccounts;

import java.io.Serializable;

public class SavingsAccount implements Serializable{
	
	private Integer savingsID;
	private Integer secondaryID;
	private Double savings;
	
	public SavingsAccount (){}
	
	public SavingsAccount(Integer savingsID, Integer secondaryID, Double savings) {
		
		this.savingsID = savingsID;
		this.secondaryID = secondaryID;
		this.savings = savings;
		
	}

	public Integer getSavingsID() {
		return savingsID;
	}

	public void setSavingsID(Integer savingsID) {
		this.savingsID = savingsID;
	}

	public Integer getSecondaryID() {
		return secondaryID;
	}

	public void setSecondaryID(Integer secondaryID) {
		this.secondaryID = secondaryID;
	}

	public Double getSavings() {
		return savings;
	}

	public void setSavings(Double savings) {
		this.savings = savings;
	}

	@Override
	public String toString() {
		return "SavingsAccount [savingsID=" + savingsID + ", secondaryID=" + secondaryID + ", savings=" + savings + "]";
	}
	
	
	
}
