package main;

import model.Account;
import model.Donor;
import model.Employee;
import model.Userpass;

public class CUR {
//	private int value;
	private String access_token = null;
	private int logincounter = 0;
	private String progname = "The Donor Fund";
	private Employee emp = null;
	private Donor donor = null;
	private Account acc = null;
	private Integer pledgeyear = null;
	private Userpass userpass = null;

	// reference to an instance of the singleton object
	private static CUR CurrentUser = new CUR();
	
	/*
	 * This is our private constructor. By making this
	 * constructor private, we prevent any other class
	 * from creating instances (objects) of this class
	 * directly.
	 */
	private CUR() { }
	
	
	public static CUR getCUR() {
		return CurrentUser;
	}
	
//	getters and setters

	public int getLogincounter() {
		return logincounter;
	}

	public void setLogincounter(int logincounter) {
		this.logincounter = logincounter;
	}
	public int incLogincounter() {
		logincounter=logincounter+1;
		return (logincounter+1);
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		CUR.getCUR().access_token = access_token;
	}

	
	public Account getAcc() {
		return acc;
	}


	public void setAcc(Account acc) {
		this.acc = acc;
	}


	public Employee getEmp() {
		return emp;
	}


	public void setEmp(Employee emp) {
		this.emp = emp;
	}


	public Donor getDonor() {
		return donor;
	}


	public void setDonor(Donor donor) {
		CUR.getCUR().donor = donor;
	}


	public Userpass getUserpass() {
		return userpass;
	}


	public void setUserpass(Userpass userpass) {
		this.userpass = userpass;
	}


	public String getProgname() {
		return progname;
	}


	public void setProgname(String progname) {
		this.progname = progname;
	}


	public Integer getPledgeyear() {
		return pledgeyear;
	}


	public void setPledgeyear(Integer pledgeyear) {
		this.pledgeyear = pledgeyear;
	}


	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
