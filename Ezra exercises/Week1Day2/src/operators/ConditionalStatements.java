package operators;

public class ConditionalStatements {
	public static void main(String[] args) {
		bool(true);
		
	}
	public static boolean bool(boolean x) { 
		System.out.println(x);
		if (x == true) {
			System.out.println("argument was true");
			return true;
		}
		else if (x == false) {
			System.out.println("arguement was false");
			return false;
		}
		else {
			System.out.println("argument is neither true nor false...what happened??!");
			return x;
		}
	}
}



//For this exercise, create a method that takes a boolean value. If the boolean value is true, print "argument was true" to the console. If the boolean is false, print "argument was false".
