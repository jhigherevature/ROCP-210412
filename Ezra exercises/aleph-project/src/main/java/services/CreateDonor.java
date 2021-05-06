package services;

import java.util.Scanner;

import dataaccessobject.EmployeeDAOImpl;
import dataaccessobject.UserpassDAO;
import dataaccessobject.UserpassDAOImpl;
import main.CUR;
import model.Account;
import model.Donor;
import model.Employee;
import model.Userpass;
import dataaccessobject.AccountDAO;
import dataaccessobject.AccountDAOImpl;
import dataaccessobject.DonorDAO;
import dataaccessobject.DonorDAOImpl;
import dataaccessobject.EmployeeDAO;

public class CreateDonor {

	public void createDonor() {

//		CreateUP cup = new CreateUP();  [username, password,]

		String[] newup = create_UP(); 
		String username = newup[0];
		String password = newup[1];
//		get username and password and create new userpass record
		UserpassDAOImpl udao = new UserpassDAOImpl();
		udao.createUserpass(username, password, "donor");
//		get id for new userpass record
		Userpass userpass = udao.selectLoginByUserAndPass(username, password);
		Integer id_user = userpass.getId_userpass();
//		get taxfilingstatus for new account
		AccountDAOImpl adao = new AccountDAOImpl();
		String taxfilingstatus = getTaxFilingStatus();
//		determine account_id for new account
		int account_id = adao.selectAccount();
		account_id++;
//		create new account
		adao.insertIntoAccount(account_id, taxfilingstatus);
//		set user profile account id 		
		CUR.getCUR().setAcc(adao.selectAccount(account_id));
//		see below. Collect donor info 
		Donor newd = requestDonorInfo(id_user, account_id);
//		adjustment for editing info
		newd.setId_account(account_id);
//		Insert info into donor object and create record in database
		DonorDAOImpl ddao = new DonorDAOImpl();
		System.out.println(newd.toString());
		ddao.insertIntoDonors(newd);

//		create joint account if account is married filing joint
		if (CUR.getCUR().getAcc().getTax_filing_status().equalsIgnoreCase("married-joint")) {
			System.out.println("Create unique username and password for your partner");
			newup = create_UP();
			username = newup[0];
			password = newup[1];
//			get username and password and create new userpass record
			udao = new UserpassDAOImpl();
			udao.createUserpass(username, password, "donor");
//			get id for new userpass record
			userpass = udao.selectLoginByUserAndPass(username, password);
			id_user = userpass.getId_userpass();
			System.out.println("Fill out donor info for your partner");

			newd = requestDonorInfo(id_user, account_id);
//				Insert info into donor object and create record in database
			ddao = new DonorDAOImpl();
			System.out.println(newd.toString());
			ddao.insertIntoDonors(newd);
		}

	}

	private String getTaxFilingStatus() {
		String[] accountType = new String[] { "single", "married filing together", "married filing seperately",
				"business", "C-Corp" };
		System.out.println("Please choose from account types below:");
		for (int i = 1; i <= accountType.length; i++) {
			System.out.println(i + ") " + accountType[(i - 1)]);
		}
		Scanner scan = new Scanner(System.in);
		int z = scan.nextInt();
		if (z == 1) {
			return "single";
		} else if (z == 2) {
			return "married-joint";
		} else if (z == 3) {
			return "married-sep";
		} else if (z == 4) {
			return "business";
		} else if (z == 5) {
			return "c-corp";
		} else {
			return "error";
		}
//				return accountType[(scan.nextInt()-1)];
	}

	private String[] create_UP() {
		String[] NewUP = new String[2];
		System.out.println("Please choose your username");
		Scanner scan = new Scanner(System.in);
		NewUP[0] = scan.nextLine();
		System.out.println("Username selected is: " + NewUP[0] + "\n Please choose your password");
		// Scanner scan = new Scanner(System.in);
		NewUP[1] = scan.nextLine();
		System.out.println("Username selected is " + NewUP[0] + "\n" + "Password selected is " + NewUP[1]);
		return NewUP;
	}

	public Donor requestDonorInfo(Integer id_user, Integer account_id) {
		Donor d = new Donor();
		System.out.println("Please input the following information to fill out your donor profile:");
		System.out.println("first name");
		Scanner scan = new Scanner(System.in);
		d.setFirst_name(scan.nextLine());

		System.out.println("last name");
		d.setLast_name(scan.nextLine());

		System.out.println("preferred title (i.e. dr, mr, mrs, etc)");
		d.setTitle(scan.nextLine());

		System.out.println("Address");
		d.setAddress(scan.nextLine());
		System.out.println("City");
		d.setCity(scan.nextLine());
		System.out.println("State");
		d.setState(scan.nextLine());
		System.out.println("zip code");
		d.setZip(scan.nextInt());
//		possible for skipped fix? Thanks Michael :D
		scan.nextLine();
		System.out.println("phone");
		d.setPhone(scan.nextLine());
		System.out.println("Email");
		d.setEmail(scan.nextLine());
		System.out.println("alternate email");
		d.setEmail_alt(scan.nextLine());
		System.out.println("Social Security number");
		d.setSoc_sec(scan.nextLine());
		System.out.println("Notes");
		d.setNotes(scan.nextLine());

		System.out.println("Would you like to permit schools to which you donate to contact you directly? (yes/no)");
//		intern method guarantees functionality of  == operator
		String yn = scan.nextLine().toLowerCase().intern();
		if (yn == "yes") {
			d.setAllow_school_contact(true);
		} else {
			d.setAllow_school_contact(false);
		}
		
		if (CUR.getCUR().getAccess_token() == "donor") {
//		System.out.println("Is your donor status active?");
		d.setDonor_status(true);
		d.setId_account(account_id);
		}
		
		if (CUR.getCUR().getAccess_token() == "emp") {
			System.out.println("Is donor status active? (true/false)");
			d.setDonor_status(scan.nextBoolean());
			System.out.println("Input Account ID number (leave blank if creating new account)");
			d.setId_account(scan.nextInt());
//			adao.selectAccount();
		}
		
		d.setId_userpass(id_user);
//		d.setId_donor(null);
		return d;
	}

}
