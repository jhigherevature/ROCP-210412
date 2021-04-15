package gatheringUserInput;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Create a method that prints different statements based on 
 * the user's input according to the following cases.

Case One: If the input is 1, then print, “Moving Right”
Case Two: If the input is 2, then print, “Moving Left”
Case Three: If the input is 3, then print, “Moving Up”
Case Four: If the input is 4, then print, “Moving Down”
Case Five: If the input is ‘q', then exit the program
Case Six: If the input is anything other than the above, 
then print, "Try again. 
Acceptable input: \[
1 - Move right, 
2 - Move Left, 
3 - Move Up, 
4 - Move Down, 
q - exit program\]"

The program should employ a continuous loop and only end if the user types in the letter q.
 */

public class Exercise2 {
	
	public static void  Exercise2() {
		
		String  greet = "Input 1 to move right, 2 to move left, 3 to move up, 4 to move down, and q to exit the program.";
		System.out.println(greet);
		Scanner scan = new Scanner(System.in);
		String x = scan.next();
		
	End:while(x != "q") {
		switch (x) {

				case "1":
					System.out.println("1 - Move Right" + "\n" + greet);
					x =scan.next();
					break ;
				case "2":
					System.out.println("2 - Move Left" + "\n" + greet);
					x =scan.next();
					break;
				case "3":
					System.out.println("3 - Move Up"+ "\n" + greet);
					x =scan.next();
					break;
				case "4":
					System.out.println("4 - Move Down"+ "\n" + greet);
					x =scan.next();
					break;
				case "q":
					System.out.println("q - exit program");
					break End;
				default:
					System.out.println("Try Again"+ "\n" + greet);
					x =scan.next();
					break ;
				}

		}
	
		scan.close();
		
	}
	
	public static void main(String[] args) {		
			Exercise2();
		}
			
	
		
}


/*

//This is just the old code incase anything went wrong witht the method , I did all my work orriginly in main and then copy and pasted into the method input

String  greet = "Input 1 to move right, 2 to move left, 3 to move up, 4 to move down, and q to exit the program.";
System.out.println(greet);
Scanner scan = new Scanner(System.in);
String x = scan.next();

End:while(x != "q") {
switch (x) {

		case "1":
			System.out.println("1 - Move Right" + "\n" + greet);
			x =scan.next();
			break ;
		case "2":
			System.out.println("2 - Move Left" + "\n" + greet);
			x =scan.next();
			break;
		case "3":
			System.out.println("3 - Move Up"+ "\n" + greet);
			x =scan.next();
			break;
		case "4":
			System.out.println("4 - Move Down"+ "\n" + greet);
			x =scan.next();
			break;
		case "q":
			System.out.println("q - exit program");
			break End;
		default:
			System.out.println("Try Again"+ "\n" + greet);
			x =scan.next();
			break ;
		}

}
scan.close();

*/