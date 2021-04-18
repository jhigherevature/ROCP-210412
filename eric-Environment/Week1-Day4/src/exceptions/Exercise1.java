package exceptions;

public class Exercise1 {

	public static void main(String[] args) {
		
		try {//this lets us know that we are going to be catching a custom exception
			addEven(1,4);
		}
		catch(OddNumberException custom) {//this is our exception, we want it first so the program will check for it first
			custom.printStackTrace();//custom is the name of the reference variable that points to our custom exception
		}
		catch(Exception ex) {//this makes sure the program checks for standard exceptions
			ex.printStackTrace();//instantiates an object so we can print a stacktrace for standard exceptions
		}
		
	}
	
	public static void addEven(int a, int b) throws OddNumberException{ //has to have the throws keyword to set the parameters for the custom exception
	
		if (a % 2 == 1 || b % 2 == 1) {
			throw new OddNumberException("input is odd!");
		}
		
		System.out.println(a + b);
		
	}

}
