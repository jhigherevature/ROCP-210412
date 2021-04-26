package exceptions;

public class Exercise1 {

	public static void main(String[] args) throws OddNumberException {
		
		addEven(2, 3);

	}
	
	public static void addEven(int a, int b) throws OddNumberException {
		
		if (a % 2 != 0 || b % 2 != 0) {
			throw new OddNumberException();
		}
	}
	
	class OddNumberException extends Exception {

}
