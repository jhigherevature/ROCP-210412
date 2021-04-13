package arrays;

public class Basics {
	
	
	public static void main(String[] args) {
		//Arrays, once created you cannot change in size
			/*
			 * 
			 * 
			 * dataType[] arrName = new dataType[size];
			 * */
		
			int[] numbers = new int[5];//creating an array called numbers that holds 5 int values: declares size
			int[] numbers2 = new int[] {2,4,6,8,10};//creating an array and giving it values
			
			int[] number3 = {3,6,9,12,15};//anonymous array, no dataType yet, can only be used when first creating the array(declaration)
			
			numbers[0] = 5;//setting the value of the first index to 5
			
			//will cause error
			//numbers[5] = 5;//trying to access a index that does not exist
			
		//Last index is always one less than the length
			System.out.println(numbers.length);
			
			//Access elements
			System.out.println(numbers[0]);
	}

}
