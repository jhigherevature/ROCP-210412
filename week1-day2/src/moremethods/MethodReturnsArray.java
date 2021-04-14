package moremethods;

public class MethodReturnsArray {
/*
 *   write a method to return a random number between 1 and 50
 */
	public static void main(String[] args) {
		double num1 = 0;
		num1 = randomNumber();
		System.out.println("Random Number = " + num1);
	
	}
	public static double randomNumber() {
		double num2 = Math.random();
		return num2;
  }

}
