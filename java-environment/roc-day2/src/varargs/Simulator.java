package varargs;

public class Simulator {

	public static void main(String... args) {
		/*
		 * Varargs are used for method parameters
		 * not a replacement for arrays
		 */
//		String... values = {"Strings"};
		String[] words = {"One", "Two", "Three"};
		printWithArray(words, 1,2,3);
		
		printWithVarArgs("One", "Two", "Three");
	}
	
	public static void printWithArray(String[] values, int...nums) {
		System.out.println(values[0]);
		System.out.println(values[1]);
		System.out.println(values[2]);
	}
	
	public static void printWithVarArgs(String... values) {
		if (values.length > 0)
			System.out.println(values[0]);
		
		if (values.length > 1)
			System.out.println(values[1]);
		
		if (values.length > 2)
			System.out.println(values[2]);
	}
}
