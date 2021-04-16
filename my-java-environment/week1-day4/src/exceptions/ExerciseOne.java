
package exceptions;

public class ExerciseOne {
	
	public static void main(String[] args) {
		
		try {
			System.out.println(addEven(1,2));
		}
		catch (OddNumberException o) {
			o.printStackTrace();	
		}

	}
	
	public static int addEven(int a, int b) throws OddNumberException {
		if(a % 2 != 0) {
			throw new OddNumberException("First Input was Odd");
		}
		if(b % 2 != 0) {
			throw new OddNumberException("Second Input was Odd");
		}	
		
		return a + b;
	}
	
	
}
