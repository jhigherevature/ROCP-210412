package varargs;

public class Simulator {
	
	public static void main(String[] args) {
		String[] words = {"One", "Two", "Three", "Four"};
		printWithArray(words);
		printWithVarArgs("One", "Two", "Three", "Four");
		
	}

	
	//Array
	public static void printWithArray(String[] values) {
		System.out.println(values[0]);
		System.out.println(values[1]);
		System.out.println(values[2]);
		System.out.println(values[3]);
		
		
	}
	
	
	//Variable arguments list,(varargs): String... values(only one can be used and it must be the last parameter in the method signature)
	//allow you to pass an arbitrary number of values as a last argument
	//of a method and treat the data as a single array
	public static void printWithVarArgs(String... values ) {
		System.out.println(values[0]);
		System.out.println(values[1]);
		System.out.println(values[2]);
		System.out.println(values[3]);
		
		
	}
}
