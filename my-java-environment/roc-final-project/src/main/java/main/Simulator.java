package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Simulator {
	static Logger logger = LogManager.getLogger(Simulator.class);
	
	public static void main(String[] args) {
		LoginMenu lm = new LoginMenu();
		lm.runLoginMenu();
		
	}
	
}
