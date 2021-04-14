package arrays;

public class Basics {
	
	public static void main(String[] args) {
		/*
		 * when creating arrays, we establish the size of the array us
		 * using the square brackets
		 * and the new keyword (right-side)
		 */
		int[] numbers = new int[5];
		
		/*
		 * arrays use indexes, which represent the 
		 * numerical position of items within an array
		 * 
		 * indexing starts at 0
		 */
		
		numbers[0] = 5 ; // first item in array is set to 5
		numbers[1] = 10 ; // first item in array is set to 10
		numbers[2] = 15 ;// first item in array is set to 15
		numbers[3] = 20 ;// first item in array is set to 20
		numbers[4] = 25 ;// first item in array is set to 25
		//numbers[5] = 30 ; trying to access sixth numbers is beyond the 5 5 alloccated for the array
		
		System.out.println(numbers.length);
		System.out.println("Last index is always one less than lenght:" + "one less than lenght:" + (numbers.length -1));
		System.out.println(numbers[0]);
		
		System.out.println(numbers[0]);
		System.out.println(numbers[1]);
		System.out.println(numbers[2]);
		System.out.println(numbers[3]);
		System.out.println(numbers[4]);
		
		int [] numbers_2 = new int[] {2,4,6,8,10};
		
		/*
		 * anonymous array assignment
		 */
		int[] numbers_3; 
		
		numbers_3 = new int[] {3,6,9,12,15};
		
		/*
		 * you cannot use an anonymous array assignment
		 * outside of the declaration of the reference variable
		 */
	//	numbers_3 = {3,6,9,12,15};
	}

}
