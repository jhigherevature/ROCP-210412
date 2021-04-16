package scanner;

import java.util.Scanner;

public class UserInput {
	/*
	 * ALT + SHIFT + S - quick access to source menu 
	 * CTRL + Space - context menu
	 * CTRL + SHIFT + O - quick imports
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int menu;
		loop: while (true) {
			System.out.println("Give me a Number:");
			menu = scan.nextInt();
			selection: switch (menu) {
			case 1:
				System.out.println("This is the first section");
				doStuff(2);
				break selection;
			case 2:
				System.out.println("This is the second");
				doStuff(1);
				break selection;
			case 3:
				System.out.println("Thanks for using!");
				break loop;
			default:
				break selection;
			}
		}
		
		/*
		 * It is best practice to close resources
		 * when you are done using them...
		 * 
		 * Note, once a stream has been closed
		 * it cannot be re-opened. Also
		 * The input stream of the System
		 * class is static. Meaning that if you
		 * close the stream you cannot use it
		 * any more...if you are still planning 
		 * to use the System.in stream do not 
		 * close it...
		 */
		scan.close();
	}
	
	public static void doStuff(int choice) {
		if (choice == 1) {
			System.out.println("Option 1");
		} else if (choice == 2) {
			System.out.println("Option 2");
		}
	}
}
