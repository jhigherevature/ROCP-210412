package gatheruserinput;

import java.util.Scanner;

public class ScannerUserInput {

	public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);
		System.out.print("Enter string here: ");
		String input1=scan1.nextLine();
		input1=input1.replaceAll("[^aeiouAEIOU]", "");
		
		System.out.println("Vowels in above line are :" + input1);
		
	}

}
