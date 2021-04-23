package main;

import java.util.List;

import dataaccessobject.DonorDAO;
import dataaccessobject.DonorDAOImpl;
import model.Donor;

public class Simulator {

	public static void main(String[] args) {
		DonorDAO dDao = new DonorDAOImpl();
		List<Donor> testList = dDao.selectAllDonors();
		
		for (Donor d : testList) {
			System.out.println(d);
		}
		
//		Donor d = new Donor("345437", "91115", "mrs", "Johnsonetta", "Johnson", "4123 Lineway dr.", "Atlanta", "GA", 90740, "123-456-7899", "Johnsonetta@johnson.com", "642-12-1234", "asflinna osadfoaef kjaoef", true, true);
		Donor d = new Donor("345437", "91115", "mrs", "Johnsonetta", "Johnson", "4123 Lineway dr.", "Atlanta", "GA", 90740, "123-456-7899", "Johnsonetta@johnson.com", "642-12-1234", "asflinna osadfoaef kjaoef", true, true);

		//		System.out.println(dDao.insertIntoDonors(d));
	}

}
