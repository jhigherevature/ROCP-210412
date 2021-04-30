package postgredataaccessobjects;

import java.util.List;

import customerapplication.CustomerApplication;

public interface CustomerApplicationDAO {
	
	public boolean insertIntoCustomerApplication();
	public CustomerApplication selectCustomerApplication(Integer id);
	public List<CustomerApplication> selectAllCustomerApplication();
	public boolean updateCustomerApplicationFirstName();
	public boolean updateCustomerApplicationLastName();
	public boolean updateCustomerApplicationUsername();
	public boolean updateCustomerApplicationPassword();
	public boolean deleteCustomerApplication(Integer id);

}
