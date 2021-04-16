package gatheruserinput;

import java.util.Scanner;

public class UserInput2 {

	public static void main(String[] args) {
    	Scanner scan2 = new Scanner(System.in);
		loop: while (true) {
//	    	Scanner scan2 = new Scanner(System.in);
		    System.out.print("Enter Value: ");
		    String input2=scan2.nextLine();
			switch (input2) {
		    case "1":
		    System.out.println("Moving Right");
		    break;
		  case "2":
		    System.out.println("Moving Left");	
		    break;
		  case "3":
		    System.out.println("Moving Up");
		    break;
		  case "4":
		    System.out.println("Moving Down");
			break;
		  case "q":
		    System.out.println("Exiting The Program");
		    break loop;
		  default:
		    System.out.println("Try again. Acceptable input: [1 - Move right, 2 - Move Left, 3 - Move Up, 4 - Move Down, q - exit program]");		    break;
			}
		}
         scan2.close();
	}
}
