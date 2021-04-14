package moremethods;

public class MethodReturnsArray {
/*
 *   method to return a random number between 1 and 50
 */
	public static void main(String[] args) {
		int num1 = 0;
		randomNumber(num1);
		System.out.println("Random Number = " + num1);
	
	}
	public static double randomNumber(int num1) {
		double num2 = Math.random();
		return num2;
  }

}
