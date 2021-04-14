package varargs;

public class Simulator {
	public static void main(String...args) {
		
		String[] words = {"One", "Two", "Three"};
		
		printWithArray(words);
		
		printWithVarArgs("One", "Two", "Three");
	}

	public static void printWithArray(String[] values, int...nums) {
		System.out.println(values[0]);
		System.out.println(values[1]);
		System.out.println(values[2]);
	}
	
	public static void printWithVarArgs(String... values) {
		System.out.println(values[0]);
		System.out.println(values[1]);
		System.out.println(values[2]);
	}
}