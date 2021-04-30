package postgredataaccessobjects;

import java.util.List;

import customerlogin.CustomerLogin;

public interface CustomerLoginDAO {
	
	public boolean insertIntoCustomerLogin();
	public CustomerLogin selectCustomerLogin(Integer id);
	public List<CustomerLogin> selectAllCustomerLogin();
	public CustomerLogin updateUsername(Integer id, CustomerLogin cl);
	public CustomerLogin updatePassword(Integer id, CustomerLogin cl);

}
