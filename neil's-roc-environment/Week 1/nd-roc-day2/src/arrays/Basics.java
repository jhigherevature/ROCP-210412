package arrays;

public class Basics {
	public static void main(String[]args) {
	
	int numbers[] = new int[5];	

	numbers[0] = 5;
	numbers[1] = 10;
	numbers[2] = 15;
	numbers[3] = 20;
	numbers[4] = 25;
	
	System.out.println(numbers.length);
	System.out.println("Last index is always one less than the length: " + (numbers.length - 1));
	System.out.println(numbers[0]);
	
	/*
	 * We can also establish an array with the syntax below:
	 */
	int[] numbers_2 = new int[] {2,4,6,8,10};
	
	/*
	 * anonymous array assignment...
	 */
	int[] numbers_3 = {3,6,9,12,15};
	
	 numbers_3 = new int[] {3,6,9,12,15};
	 
	 /*
	  * You cannot use anonymous array assignment outside of the declaration of the array
	  * reference variable.
	  */
	
	  // numbers_3 = {3,6,9,12,15}; this will result in an error.
	}
}