package services;

import dao.AccountDAO;
import model.Employee;
import utilities.DAOUtility;
import utilities.ScannerUtility;
import view.Printable;

public class ApproveAccountsService {
	ApproveAccountsMenuService menu = new ApproveAccountsMenuService();
	AccountDAO adao = DAOUtility.getAccountDAO();
	ScannerUtility s = ScannerUtility.getInstance();
	Printable accountPrompt = () -> System.out.print("\nPlease enter the account number to be approved: ");

	public void approveAll(Employee employee) {
		int approvedAccountsCount;

		approvedAccountsCount = adao.approveAllPendingAccounts(employee.getEmployeeID());

		System.out.println("\n Successfully updated " + approvedAccountsCount + " accounts.");
		menu.approvalMenu(employee);
	}

	public void approveByAccountID(Employee employee) {
		int accountNum;
		boolean isAccount = false;
		boolean success = false;
		accountPrompt.print();

		do {
			if (s.scan.hasNextInt()) {
				accountNum = s.scan.nextInt();
				s.scan.nextLine();
				
				isAccount = adao.checkIfAccount(accountNum);
				if (isAccount) {
					success = adao.approvePendingAccountByID(employee.getEmployeeID(), accountNum);
					if (success) {
						System.out.println("\nSuccessfully approved account number " + accountNum);
						continue;
					}
				} else {
					System.out.print("\nPlease enter a valid pending account number: ");
					continue;
				}
			} else {
				s.scan.nextLine();
				System.out.print("\nPlease enter a valid account number: ");
				continue;
			}
		} while (!isAccount);
		
		menu.approvalMenu(employee);

	}
}
