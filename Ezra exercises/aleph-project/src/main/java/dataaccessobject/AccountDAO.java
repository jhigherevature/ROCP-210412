package dataaccessobject;

import java.util.List;

import model.Account;

public interface AccountDAO {
	public boolean insertIntoAccount(Account account);
	public Account selectAccount(Integer id);
	public List<Account> selectAllAccount();
	
}
