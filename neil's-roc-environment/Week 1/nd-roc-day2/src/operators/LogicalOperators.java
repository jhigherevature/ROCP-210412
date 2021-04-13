package operators;

public class LogicalOperators {
	@SuppressWarnings("unused")
	public static void main(String[]args) {
		
		System.out.println(true & true );
		System.out.println(true & false);
		System.out.println(false & true);
		System.out.println(false & false);
		
		System.out.println(true | true );
		System.out.println(true | false ); //true
		System.out.println(false | true ); //true
		System.out.println(false | false ); //false
		
		
		if(false & printAndReturnTrue()) {
			System.out.println("It was true!");
			
		}else {
			System.out.println("It was not true!");
		}
	}
	
	public static boolean printAndReturnTrue() {
		System.out.println("The method executed!");
		return true;
	}
}
