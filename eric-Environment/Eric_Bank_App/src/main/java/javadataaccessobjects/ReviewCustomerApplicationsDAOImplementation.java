package javadataaccessobjects;

import java.util.Scanner;

import customerapplication.CustomerApplication;
import postgredataaccessobjects.CustomerApplicationDAO;
import postgredataaccessobjects.CustomerApplicationDAOImplementation;
import postgredataaccessobjects.CustomersDAO;
import postgredataaccessobjects.CustomersDAOImplementation;

public class ReviewCustomerApplicationsDAOImplementation implements ReviewCustomerApplicationsDAO {
	
	Scanner input = new Scanner (System.in);
	
	String accessLevel;
	
	public ReviewCustomerApplicationsDAOImplementation() {}
	
	public ReviewCustomerApplicationsDAOImplementation(String accessLevel) {
		
		this.accessLevel = accessLevel;
		
	}
	
	CustomerApplicationDAO ca = new CustomerApplicationDAOImplementation("banker");
	CustomersDAO cDao = new CustomersDAOImplementation("banker");

	public void reviewCustomerApplications() {
		
		rca:while(true) {
		System.out.println("Select one of the following actions by inputing the corresponding number:"
				+ "\n1.View applications"
				+ "\n2.Approve or deny application"
				+ "\n3.Return to previous screen");
		
		Integer num = input.nextInt();
		input.nextLine();
		
			switch(num) {
			
			case 1: System.out.println(ca.selectAllCustomerApplication());
			
			break;
				
			case 2: reviewCustomerApplicationInformation();
				
			break;
				
			case 3: break rca;
		
			}
		
		}
	}
	
	public void reviewCustomerApplicationInformation() {
		
		System.out.print("Enter the applicant ID you wish to approve or deny: ");
		Integer id = input.nextInt();
		input.nextLine();
		
		CustomerApplication custApp = ca.selectCustomerApplication(id);
		
		System.out.print("1.Approve"
				+ "\n2.Deny"
				+ "\n3.Exit");
		//add an adjust option
			
		int num = input.nextInt();
		input.nextLine();
		
		switch (num) {
		
		case 1: 
			cDao.insertIntoCustomers(custApp.getCustomer_first_name(), custApp.getCustomer_last_name(), custApp.getCustomer_username(), custApp.getCustomer_password());
			ca.deleteCustomerApplication(id);
		break;
			
		case 2: ca.deleteCustomerApplication(id);
		break;
			
		case 3: break;
		
		}
		
	}
	
	
}
