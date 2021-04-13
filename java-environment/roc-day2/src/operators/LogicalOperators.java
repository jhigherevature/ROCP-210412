package operators;

public class LogicalOperators {
	
	public static void main(String[] args) {		
		System.out.println(true & true);	// true
		System.out.println(true & false);	// false
		System.out.println(false & true);	// false
		System.out.println(false & false);	// false
		
		System.out.println(true | true);	// true
		System.out.println(true | false);	// true
		System.out.println(false | true);	// true
		System.out.println(false | false);	// false		
		
		/*
		 * Short circuit operations will perform a 
		 * 'logical leap'
		 */
		System.out.println("The method returned: " + printAndReturnTrue());
		
		if (false && printAndReturnTrue()) {
			System.out.println("It was true!");
		} else {
			System.out.println("It was not true!");
		}
	}
	
	public static boolean printAndReturnTrue() {
		System.out.println("The method executed!");
		return true;
	}


}
