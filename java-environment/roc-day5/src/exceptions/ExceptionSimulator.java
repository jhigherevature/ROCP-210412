package exceptions;

public class ExceptionSimulator {
	public static void main(String[] args) {
		
		boolean callExit = true;
		
		try {
			
			System.out.println("Should I call exit?: " + callExit);
			if (callExit)
				System.exit(0);
			
			System.out.println(sumOddNumbers(3,4));
		} catch (EvenNumberException even) {
			even.printStackTrace();
		} catch(Exception except) {
			except.printStackTrace();
		} finally {
			System.out.println("This (almost) always occurs!");
		}
		
	}
	
	public static int sumOddNumbers(int a, int b) 
			throws EvenNumberException {
		if (a % 2 == 0) {
			throw new EvenNumberException("First Input was Even, you entered: " + a);
		} else if (b % 2 == 0) {
			throw new EvenNumberException("Second Input was Even, you entered: " + b);
		}
		
		return a+b;
	}
}
