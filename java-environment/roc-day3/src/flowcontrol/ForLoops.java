package flowcontrol;

import java.util.Arrays;

public class ForLoops {

	public static void main(String[] args) {
		for (int x = 100; x > 0; x--) {
			System.out.println("This will never print!");
		}
		
		int y = 5;
		for (int x = 0; ; ) {
			if (x == 2)
				break;
			
			x = x+1;
			System.out.println("X is: " + x + " y is: " + y);
		}
		
		
		// below creates an infinite loop
		for ( ; ; ) {
			System.out.println("Will This print?");
			break;
		}
		
//		for (int i = 0; i < 10; i = i+1) {
//			System.out.println("The value of i is: " + i);
//		}
//		
		String[] names = {"Abe", "Barry","Charles", "Dolly"};
//		for (int i = 0; i < names.length; i++) {
//			System.out.println(names[i]);
//			if (names[i] == "Barry") {
//				System.out.println("I found you!");
//				break;
//			}
//		}
		
		/*
		 *  The Arrays class has static methods
		 *  we can use with array objects
		 *  for more functionality! It is a
		 *  convenience class! 
		 */
//		System.out.println(Arrays.toString(names));
		
		
		/*
		 * Enhanced for loops are a short-hand for 
		 * traversing a collection. The syntax is:
		 * 
		 *  for (datatype_matching_collection variable_name : collection)
		 */
		for (String name : names) {
			System.out.println(name);
		}
	}
}
