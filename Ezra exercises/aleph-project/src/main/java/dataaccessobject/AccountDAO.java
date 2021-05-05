package dataaccessobject;

import java.util.List;

import model.Account;
import model.Donor;

public interface AccountDAO {
	public boolean insertIntoAccount(Account account);
	public Account selectAccount(Integer id);
	public List<Account> selectAllAccounts();
	public int selectAccount();
	public boolean insertIntoAccount(int account_id, String tfs);
	public List<Donor> selectDonorbyAccount(Integer id_account);
	List<Account> selectAllInactiveAccounts();
	List<Account> selectAllActiveAccounts();
	boolean EditAccount(Account account);
	int getAccountActiveNumber();
	int getAccountInactiveNumber();

}
