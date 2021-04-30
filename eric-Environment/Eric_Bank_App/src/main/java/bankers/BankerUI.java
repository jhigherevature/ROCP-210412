package bankers;

import java.util.Scanner;

import javadataaccessobjects.ReviewBankerInformationDAO;
import javadataaccessobjects.ReviewBankerInformationDAOImplementation;
import javadataaccessobjects.ReviewCustomerApplicationsDAO;
import javadataaccessobjects.ReviewCustomerApplicationsDAOImplementation;
import javadataaccessobjects.ReviewCustomerInformationDAO;
import javadataaccessobjects.ReviewCustomerInformationDAOImplementation;
import javadataaccessobjects.ReviewEmployeeInformationDAO;
import javadataaccessobjects.ReviewEmployeeInformationDAOImplementation;

public class BankerUI {
	
	Scanner input = new Scanner (System.in);
	
	public BankerUI () {}
	
	public void ui() {
				
		bui:while(true) {
		
		System.out.println("Select an option:"
				+ "\n1.Banker information"
				+ "\n2.Employee information"
				+ "\n3.Customer information"
				+ "\n4.Customer applications"
				+ "\n5.Exit");
		
		int num = input.nextInt();
		input.nextLine();
		
		switch(num) {
		
		case 1: 
			
			ReviewBankerInformationDAO bDao= new ReviewBankerInformationDAOImplementation("banker");
			bDao.reviewBankerInformation();
			break;
		
		case 2:
			
			ReviewEmployeeInformationDAO eDao = new ReviewEmployeeInformationDAOImplementation("banker");
			eDao.reviewEmployeeInformation();
			break;
			
		case 3:
			
			ReviewCustomerInformationDAO cDao = new ReviewCustomerInformationDAOImplementation("banker");
			cDao.reviewCustomerInformation();
			break;
			
		case 4:
			
			ReviewCustomerApplicationsDAO caDao = new ReviewCustomerApplicationsDAOImplementation("banker");
			caDao.reviewCustomerApplications();
			break;
			
		case 5: break bui;
		
		}
		
	}
		
	}

}
