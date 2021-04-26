package dataaccessobject;

import model.Customer;

public interface CustomerDAO {
	
	public Double[] balanceCheck(Integer id);
	public Double[] depositMoney(Integer id);
	public Double[] withdrawlMoney(Integer id);
	
}
