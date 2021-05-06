package utilities;

import java.util.Scanner;

public class ScannerUtility {
	private static ScannerUtility instance = null;
	public Scanner scan;
	
	   private ScannerUtility() {
		   scan = new Scanner(System.in);
	   }

	   public static ScannerUtility getInstance() {
	      if(instance == null) {
	         instance = new ScannerUtility();
	      }
	      return instance;
	   }
	   
	   public void closeScanner() {
		   scan.close();
	   }
}
