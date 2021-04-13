package operators;

public class Contact {
	public static void main(String[]args) {
		
		/*
		 * When using the '+' operator with strings the operator will perform string concatenation
		 * this means that the values will be appended to form a single string.
		 * 
		 * When numbers are presented next to Strings the numbers are converted to Strings as well
		 * 
		 * note that operators resolve left to right.
		 */
		System.out.println("Hello" + "World!");
		System.out.println("A" + 5 + 5);
		System.out.println("A" + (5 + 5));
		System.out.println(5 + 5 + "A");
	}

}
