package operators;

public class IntEvenOdd {

	public static void main(String[] args) {
		
		int number = 2;
		numberEvenOdd(number);
		

	}
	public static int numberEvenOdd(int number) {
		if (number %2 == 0) {
			System.out.println("even value");
			return number;
		}
		else {
			System.out.println("odd value");
			return number;
		}
	}
}

//For this exercise Create an executable class (a class with a main method). Within the main method create an integer variable called "number" and initialize it to any int value.

//Create an if statement below this variable that checks if the value is even or odd. If the number is even, print "Even value" to the console. If the number is false, print "False value" instead.