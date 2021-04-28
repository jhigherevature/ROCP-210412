package main;

import model.Donor;
import model.Employee;

public class CurrentUserRef {
//	private int value;
	private String access_token = null;
	private int logincounter = 0;
	
	private Employee emp = null;
	private Donor donor = null;
	

	// reference to an instance of the singleton object
	private static CurrentUserRef CurrentUser = new CurrentUserRef();
	
	/*
	 * This is our private constructor. By making this
	 * constructor private, we prevent any other class
	 * from creating instances (objects) of this class
	 * directly.
	 */
	private CurrentUserRef() { }
	
	
	public static CurrentUserRef getCurrentUserRef() {
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
		CurrentUserRef.getCurrentUserRef().access_token = access_token;
	}

	
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
