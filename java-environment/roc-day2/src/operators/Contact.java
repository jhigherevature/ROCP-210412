package operators;

public class Contact {

	public static void main(String[] args) {
		/*
		 * When using the '+' operator with strings
		 * the operator will perform String 
		 * concatenation this means that the 
		 * values will be appended
		 * to form a single string.
		 * 
		 * When numbers are presented next to Strings
		 * the numbers are converted to Strings as well.
		 * 
		 * Note that operators resolve from left-to-right
		 */
		System.out.println("Hello " + "World!");
		System.out.println("A" + 5 + 5);
		System.out.println("A" + (5 + 5));
		System.out.println(5 + 5 + "A");
	}
}
