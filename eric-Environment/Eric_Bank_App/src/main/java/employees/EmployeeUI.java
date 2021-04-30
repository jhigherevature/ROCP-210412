package employees;

import java.util.Scanner;

import javadataaccessobjects.ReviewCustomerApplicationsDAO;
import javadataaccessobjects.ReviewCustomerApplicationsDAOImplementation;
import javadataaccessobjects.ReviewCustomerInformationDAO;
import javadataaccessobjects.ReviewCustomerInformationDAOImplementation;
import javadataaccessobjects.ReviewEmployeeInformationDAO;
import javadataaccessobjects.ReviewEmployeeInformationDAOImplementation;

public class EmployeeUI {
	
Scanner input = new Scanner (System.in);
	
	public EmployeeUI () {}
	
	public void ui() {
				
		eui:while(true) {
		
		System.out.println("Select an option:"
				+ "\n2.Employee information"
				+ "\n3.Customer information"
				+ "\n4.Customer applications"
				+ "\n5.Exit");
		
		int num = input.nextInt();
		input.nextLine();
		
		switch(num) {
		
		case 2:
			
			ReviewEmployeeInformationDAO eDao = new ReviewEmployeeInformationDAOImplementation("employee");
			eDao.reviewEmployeeInformation();
			break;
			
		case 3:
			
			ReviewCustomerInformationDAO cDao = new ReviewCustomerInformationDAOImplementation("employee");
			cDao.reviewCustomerInformation();
			break;
			
		case 4:
			
			ReviewCustomerApplicationsDAO caDao = new ReviewCustomerApplicationsDAOImplementation("employee");
			caDao.reviewCustomerApplications();
			break;
			
		case 5: break eui;
		
		}
		
	}
		
	}

}
