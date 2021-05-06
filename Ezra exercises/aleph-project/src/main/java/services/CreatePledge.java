package services;

import java.util.Scanner;

import dataaccessobject.PledgeDAOImpl;
import main.CUR;
import model.Pledge;

public class CreatePledge {
	public boolean createPledge() {

		Pledge p = new Pledge();
		System.out.println("Please input the following information to make a pledge:");
		System.out.println("What year is the pledge for?");

		Scanner scan = new Scanner(System.in);
//			p.setYear_pledge(CUR.getCUR().getPledgeyear());
		p.setYear_pledge(services.Constraints.donationYear(scan.nextInt()));

		System.out.println("Choose which school you would like to pledge to");
//			Choose school and get school ID
		ChooseSchool s = new ChooseSchool();
		p.setId_school(s.chooseSchool());

		System.out.println("Choose amount to pledge");
//			services.Constraints.positiveInt(scan.nextInt());
//			p.setPledge_amt(scan.nextInt());
		p.setPledge_amt(services.Constraints.positiveDouble(scan.nextDouble()));

		p.setId_account(CUR.getCUR().getAcc().getId_account());

		PledgeDAOImpl pdao = new PledgeDAOImpl();
		if (pdao.insertIntoPledge(p)) {return true;}
		else {return false;}
	}

	public boolean createPledgeAdmin() {
		Pledge p = new Pledge();
		System.out.println("Please input the following information to make a pledge:");
		System.out.println("What year is the pledge for?");

		Scanner scan = new Scanner(System.in);
//		p.setYear_pledge(CUR.getCUR().getPledgeyear());
		p.setYear_pledge(scan.nextInt());

		System.out.println("Choose account to associate with pledge");
		p.setId_account(scan.nextInt());

		System.out.println("Choose which school you would like to pledge to");
//		Choose school and get school ID
		ChooseSchool s = new ChooseSchool();
		p.setId_school(s.chooseSchool());

		System.out.println("Choose amount to pledge");
//		services.Constraints.positiveInt(scan.nextInt());
//		p.setPledge_amt(scan.nextInt());
		p.setPledge_amt(services.Constraints.positiveDouble(scan.nextDouble()));
		scan.nextLine();

		System.out.println("Choose pledge status (pledged, submitted, pay_now, closed)");
		p.setStatus_pledge(scan.nextLine());
		if (p.getStatus_pledge() == null) { p.setStatus_pledge("pledged");}
		
		PledgeDAOImpl pdao = new PledgeDAOImpl();
		if (pdao.insertIntoPledge(p)) {return true;}
		else {return false;}
	}
}
