package operators;

public class LogicalOperators {
	
	public static void main(String[] args) {
		
		System.out.println(true & true); // true
		System.out.println(true & false); // false
		System.out.println(false & true); // false
		System.out.println(false & false); // false
		
		System.out.println(true | true); // true
		System.out.println(true | false); // true
		System.out.println(false | true); // true
		System.out.println(false | false); // false

		
		
		/*
		 * Short circuit operations will perform a 
		 * 'logical leap' 
		 */
		
		if (false & printAndReturnTrue()) {
			System.out.println("it was true!");
		} else {
			System.out.println("it was not true!");
		}
		
	}

	public static boolean printAndReturnTrue() {
		System.out.println("The method executed");
		return true;
		
	}
	
}
