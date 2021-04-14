package operators;

public class LogicalOperators {
	static boolean printAndReturnTrue() {
		System.out.println("The Method was executed");
		return true;
	}
	static boolean printAndReturnFalse() {
		System.out.println("The Method was executed");
		return false;
	}
	public static void main(String[] args) {
		if (printAndReturnFalse() && printAndReturnFalse()) {
			System.out.println("It was true");
		}
		
	}
	
}
