package javadataaccessobjects;

import java.util.Scanner;

import bankerlogin.BankerLogin;
import bankers.Bankers;
import postgredataaccessobjects.BankerLoginDAO;
import postgredataaccessobjects.BankerLoginDAOImplementation;
import postgredataaccessobjects.BankersDAO;
import postgredataaccessobjects.BankersDAOImplementation;

public class ReviewBankerInformationDAOImplementation implements ReviewBankerInformationDAO{
	
	Scanner input = new Scanner (System.in);
	
	String accessLevel;
	
	public ReviewBankerInformationDAOImplementation() {}
	
	public ReviewBankerInformationDAOImplementation(String accessLevel) {
		
		this.accessLevel = accessLevel;
		
	}
	
	BankersDAO bDao = new BankersDAOImplementation("banker");
	BankerLoginDAO blDao = new BankerLoginDAOImplementation("banker");
	
	public void reviewBankerInformation() {
		
		System.out.print("Enter the banker ID for the account you wish to use: ");
		Integer id = input.nextInt();
		input.nextLine();
		
		bDao.selectBanker(id);
		
		rbi:while(true) {
		
		Bankers b = bDao.selectBanker(id);
		BankerLogin bl = blDao.selectBankerLogin(id);
		System.out.println(b);
		System.out.println(bl);
		
		System.out.println("1.Update banker information"
				+ "\n2.Update banker login information"
				+ "\n3.Exit");
			
		int num = input.nextInt();
		input.nextLine();
		
		switch (num) {
		
		case 1: b = updateBankerInformation(b.getBankerID(), b);
		break;
			
		case 2: bl = updateLoginInformation(b.getBankerID(), bl);
		break;
		
		case 3:
		break rbi;
		
		}
		
	}
		
	}
	
	public Bankers updateBankerInformation(Integer id, Bankers b) {
		
		System.out.println("1.Update first name"
				+ "\n2.Update last name"
				+ "\n3.Update job"
				+ "\n4.Update salary"
				+ "\n5.Exit");
		
		Integer num = input.nextInt();
		input.nextLine();
		
		switch (num) {
		
		case 1: b = bDao.updateBankerFirstName(id, b);
		return b;
			
		case 2: b = bDao.updateBankerLastName(id, b);
		return b;
		
		case 3: b = bDao.updateBankerJob(id, b);
		return b;
		
		case 4: b = bDao.updateBankerSalary(id, b);
		return b;
		
		case 5:
		return b;
		
		}
		
		return b;
		
	}
	
	public BankerLogin updateLoginInformation(Integer id, BankerLogin bl) {
		
		System.out.println("1.Update username"
				+ "\n2.Update password"
				+ "\n3.Exit");
		
		int num = input.nextInt();
		input.nextLine();
		
		switch (num) {
		
		case 1: bl = blDao.updateUsername(id, bl);
		return bl;
			
		case 2: bl = blDao.updatePassword(id, bl);
		return bl;
			
		case 3: 
		return bl;
		
		}
		
		return bl;
		
	}

}
