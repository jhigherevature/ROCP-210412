package customers;

import java.util.Scanner;

import javadataaccessobjects.ReviewCustomerInformationDAO;
import javadataaccessobjects.ReviewCustomerInformationDAOImplementation;

public class CustomerUI {
	
Scanner input = new Scanner (System.in);
	
	public CustomerUI () {}
	
	public void ui() {
				
		bui:while(true) {
		
		System.out.println("Select an option:"
				+ "\n3.Customer information"
				+ "\n5.Exit");
		
		int num = input.nextInt();
		input.nextLine();
		
		switch(num) {
			
		case 3:
			
			ReviewCustomerInformationDAO cDao = new ReviewCustomerInformationDAOImplementation("customer");
			cDao.reviewCustomerInformation();
			break;
			
		case 5: break bui;
		
		}
		
	}
		
	}

}
