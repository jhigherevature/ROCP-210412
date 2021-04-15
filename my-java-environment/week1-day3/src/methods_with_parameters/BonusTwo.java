package methods_with_parameters;

import java.lang.reflect.Array;

public class BonusTwo {
	static public void displayArrayStatistics(int[] a, int[] b) {
		
		/* ASSUMPTIONS:
		 * Each argument will contain at least three elements
		 * The values will be positive
		 */
		
		// Even Number Comparison
		int evenA = 0;
		int evenB = 0;
		
		for (int i = 0;i < Array.getLength(a);i++) {
			if (Array.getInt(a,i) % 2 == 0) {
				evenA++;
			}
		}
		
		for (int i = 0;i < Array.getLength(b);i++) {
			if (Array.getInt(b,i) % 2 == 0) {
				evenB++;
			}
		}
		
		if (evenA > evenB)
			System.out.println("A contains more even numbers.");
		else if (evenA < evenB) {
			System.out.println("B contains more even numbers.");
		}
		else {
			System.out.println("A and B contain the same amount of even numbers.");
		}
		
		// Data Size Comparison
		if (Array.getLength(a) > Array.getLength(b))
			System.out.println("A contains more data.");
		else if (Array.getLength(a) < Array.getLength(b)) {
			System.out.println("B contains more data.");
		}
		else {
			System.out.println("A and B contain the same amount of data.");
		}
		
		// Values of Multiple 3 Comparison
		int threeA = 0;
		int threeB = 0;
		
		for (int i = 0;i < Array.getLength(a);i++) {
			if (Array.getInt(a,i) % 3 == 0) {
				threeA++;
			}
		}
		
		for (int i = 0;i < Array.getLength(b);i++) {
			if (Array.getInt(b,i) % 3 == 0) {
				threeB++;
			}
		}
		
		if (threeA > threeB)
			System.out.println("A contains more numbers divisible by three.");
		else if (threeB < threeA) {
			System.out.println("B contains more numbers divisible by three.");
		}
		else {
			System.out.println("A and B contain the same amount of numbers divisible by three.");
		}
		
	}
}
