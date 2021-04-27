package model;

import java.io.Serializable;
import java.sql.Date;


public class Pledge implements Serializable{
	private Integer id_pledge;
	private Integer id_account;
	private Integer year_pledge = 2021;
	private Integer pledge_amt;
	private String id_school;
	
	long curr_time = System.currentTimeMillis();
	private Date date_pledged = new Date(curr_time);		// another option:  	 Date.valueOf("2021-04-29"); 		//what datatype is a date
	private String status_pledge = "unconfirmed";		// pledged, submitted, pay_now, closed
	private Date submission_date = null;
	private Date approval_date = null;

	get.
	Date date = Date.valueOf("");
		
	public Pledge() {
	}
	public Pledge(Integer id_pledge, Integer id_account, Integer year_pledge,
	 Integer pledge_amt,String id_school, Date date_pledged, //what datatype is a date
	 String status_pledge, Date submission_date, Date approval_date) {
		this.id_account = null;	//id_account; 
		this.year_pledge = year_pledge;
		this.pledge_amt = pledge_amt;
		this.id_school = id_school; 
		this.date_pledged = date_pledged; //what datatype is a date
		this.status_pledge = status_pledge; 
		this.submission_date = submission_date; 
		this.approval_date = approval_date; 
	}
	
//	public Pledge(Integer id_pledge, Integer id_account, Integer year_pledge, 
//			Integer pledge_amt,String id_school, Date date_pledged, //what datatype is a date
//			String status_pledge, Date submission_date, Date approval_date) {
//		this(id_pledge, id_account,  year_pledge, pledge_amt, id_school,
//				date_pledged, status_pledge,  submission_date, approval_date);
//	}
	
	public Pledge(Integer id_account, Integer year_pledge, 
			Integer pledge_amt, String id_school, Date date_pledged) {
		this(null, id_account,  year_pledge, pledge_amt, id_school,
				date_pledged, "pledged",  null, null);
	}
	/**
	 * @return the id_pledge
	 */
	public Integer getId_pledge() {
		return id_pledge;
	}
	/**
	 * @param id_pledge the id_pledge to set
	 */
	public void setId_pledge(Integer id_pledge) {
		this.id_pledge = id_pledge;
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
	 * @return the year_pledge
	 */
	public Integer getYear_pledge() {
		return year_pledge;
	}
	/**
	 * @param year_pledge the year_pledge to set
	 */
	public void setYear_pledge(Integer year_pledge) {
		this.year_pledge = year_pledge;
	}
	/**
	 * @return the pledge_amt
	 */
	public Integer getPledge_amt() {
		return pledge_amt;
	}
	/**
	 * @param pledge_amt the pledge_amt to set
	 */
	public void setPledge_amt(Integer pledge_amt) {
		this.pledge_amt = pledge_amt;
	}
	/**
	 * @return the id_school
	 */
	public String getId_school() {
		return id_school;
	}
	/**
	 * @param id_school the id_school to set
	 */
	public void setId_school(String id_school) {
		this.id_school = id_school;
	}
	/**
	 * @return the date_pledged
	 */
	public Date getDate_pledged() {
		return date_pledged;
	}
	/**
	 * @param date_pledged the date_pledged to set
	 */
	public void setDate_pledged(Date date_pledged) {
		this.date_pledged = date_pledged;
	}
	/**
	 * @return the status_pledge
	 */
	public String getStatus_pledge() {
		return status_pledge;
	}
	/**
	 * @param status_pledge the status_pledge to set
	 */
	public void setStatus_pledge(String status_pledge) {
		this.status_pledge = status_pledge;
	}
	/**
	 * @return the submission_date
	 */
	public Date getSubmission_date() {
		return submission_date;
	}
	/**
	 * @param submission_date the submission_date to set
	 */
	public void setSubmission_date(Date submission_date) {
		this.submission_date = submission_date;
	}
	/**
	 * @return the approval_date
	 */
	public Date getApproval_date() {
		return approval_date;
	}
	/**
	 * @param approval_date the approval_date to set
	 */
	public void setApproval_date(Date approval_date) {
		this.approval_date = approval_date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_pledge == null) ? 0 : id_pledge.hashCode());
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
		Pledge other = (Pledge) obj;
		if (id_pledge == null) {
			if (other.id_pledge != null)
				return false;
		} else if (!id_pledge.equals(other.id_pledge))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pledge [id_pledge=" + id_pledge + ", id_account=" + id_account + ", year_pledge=" + year_pledge
				+ ", pledge_amt=" + pledge_amt + ", id_school=" + id_school + ", date_pledged=" + date_pledged
				+ ", status_pledge=" + status_pledge + ", submission_date=" + submission_date + ", approval_date="
				+ approval_date + "]";
	}
	
	
}
