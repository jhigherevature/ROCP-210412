package postgredataaccessobjects;

import java.util.List;

import savingsaccounts.SavingsAccount;

public interface SavingsAccountDAO {
	
	//to manipulate savings account data
		public boolean insertIntoSavingsAccounts();
		public SavingsAccount selectSavingsAccount(Integer id);
		public List<SavingsAccount> selectAllSavingsAccounts();
		public boolean updateSavingsID();
		public SavingsAccount updateSecondaryIDAsPrimary(Integer id, SavingsAccount sa);
		public SavingsAccount updateSecondaryIDAsSecondary(Integer id, SavingsAccount sa);
		public SavingsAccount updateSavingsPrimary(Integer id, SavingsAccount sa);
		public SavingsAccount updateSavingsSecondary(Integer id, SavingsAccount sa);
		public SavingsAccount removeSecondaryID(Integer id, SavingsAccount sa);
		public SavingsAccount setSecondaryIDAsPrimary(Integer id, SavingsAccount sa );
		public boolean deleteSavingsAccount();

}
