package model;

import java.io.Serializable;

//		id_account, status, tax_filing_status


public class Account implements Serializable {
	private Integer id_account;
	private String status = "unconfirmed";		//unconfirmed, incomplete,
	private String tax_filing_status;
	
	public Account() {};
	
	public Account(Integer id_account, String status, String tax_filing_status) {
		this.id_account = id_account; 
		this.status = status; 
		this.tax_filing_status= tax_filing_status; 
	}
	
	public Account(Integer id_account, String tax_filing_status) {
		this(id_account, "unconfirmed", tax_filing_status);
	}
	
	public Account(String tax_filing_status) {
		this(null, "unconfirmed", tax_filing_status);
	}

	/**
	 * @return the id_account
	 */
	public Integer getId_account() {
		return id_account;
	}

	/**
	 * @param id_account the id_account to set
	 */
	public void setId_account(Integer id_account) {
		this.id_account = id_account;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the tax_filing_status
	 */
	public String getTax_filing_status() {
		return tax_filing_status;
	}

	/**
	 * @param tax_filing_status the tax_filing_status to set
	 */
	public void setTax_filing_status(String tax_filing_status) {
		this.tax_filing_status = tax_filing_status;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_account == null) ? 0 : id_account.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tax_filing_status == null) ? 0 : tax_filing_status.hashCode());
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
		if (id_account == null) {
			if (other.id_account != null)
				return false;
		} else if (!id_account.equals(other.id_account))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tax_filing_status == null) {
			if (other.tax_filing_status != null)
				return false;
		} else if (!tax_filing_status.equals(other.tax_filing_status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [id_account=" + id_account + ", status=" + status + ", tax_filing_status=" + tax_filing_status
				+ "]";
	}
	
	
}
