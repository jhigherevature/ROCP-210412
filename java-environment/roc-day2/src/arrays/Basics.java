package arrays;

public class Basics {
	
	public static void main(String[] args) {
		/*
		 * When creating arrays, we establish the
		 * size of the array using the square brackets
		 * and the new keyword (right-side) 
		 */
		int[] numbers = new int[5];
		
		/*
		 * Arrays use indexes, which represent
		 * the numerical position of items within
		 * an array.
		 * 
		 * Indexing starts at 0
		 */
		numbers[0] = 5; // first item in array set to 5
		numbers[1] = 10; // second item in array set to 10
		numbers[2] = 15; // third item in array set to 15
		numbers[3] = 20; // fourth item in array set to 20
		numbers[4] = 25; // fifth item in array set to 25
//		numbers[5] = 30; // trying to access sixth - ArrayIndexOutOfBounds Exception
		
		System.out.println(numbers.length);
		
		System.out.println("Last Index is always "
				+ "one less than length: " 
				+ (numbers.length - 1));
		
		System.out.println(numbers[0]);
		System.out.println(numbers[1]);
		System.out.println(numbers[2]);
		System.out.println(numbers[3]);
		System.out.println(numbers[4]);
		
		System.out.println("Index 0 plus 3 is: " + (numbers[0] + 3));
		
		/*
		 * We can also establish an array with the
		 * syntax below:
		 */
		int[] numbers_2 = new int[] {2,4,6,8,10};
		
		
		/*
		 * anonymous array assignment...
		 */
		int numbers_3[] = {3,6,9,12,15};
		
		numbers_3 = new int[] {3,6,9,12,15};
		/*
		 * You cannot use anonymous array assignment
		 * outside of the declaration of the array
		 * reference variable
		 */
//		numbers_3 = {3,6,9,12,15}; // error
	}
}
