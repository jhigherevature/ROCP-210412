package operators;

public class LogicalOperators {
	// & and | will evaluate both expressions
	//&& and || will not check second expression if first is false
	public static boolean printAndReturnTrue() {
		System.out.println("The method executed");
		return true;
	};
	public static void main(String[] args) {
		System.out.println(true & true);	// true
		System.out.println(true & false);	// false
		System.out.println(false & true);	// false
		System.out.println(false & false);	// false
		
		System.out.println(true | true);	// true
		System.out.println(true | false);	// true
		System.out.println(false | true);	// true
		System.out.println(false | false);	// false
		
		System.out.println("The method returns true: " + printAndReturnTrue());
		
		if(false & printAndReturnTrue()) {
			System.out.println("It was true!!!");
		} else {
			System.out.println("It was not true!!!");
		}
		
		if(false | printAndReturnTrue()) {
			System.out.println("It was true!!!");
		} else {
			System.out.println("It was not true!!!");
		}
		
//		if(true) {
//			System.out.println("This always executes!!!");
//		}
		
	}

}
