package main;

import dataaccessobject.CustomerDAO;
import dataaccessobject.CustomerDAOImpl;
import initialization.InitializeData;
import model.Customer;

public class Simulator {
	public static void main(String[] args) {
		InitializeData dd = new InitializeData();
		dd.create();
		CustomerDAO cDAO = new CustomerDAOImpl();
		cDAO.balanceCheck(1);
		cDAO.depositMoney(1);
		
}
}
