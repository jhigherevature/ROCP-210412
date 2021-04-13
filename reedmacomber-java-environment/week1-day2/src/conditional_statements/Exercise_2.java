//For this exercise, create an executable class (a class with a main method). Within the main method create an integer variable called "number" and initialize it to any int value.

//Create an if statement below this variable that checks if the value is even or odd. If the number is even, print "Even value" to the console. If the number is false, print "False value" instead.

package conditional_statements;

public class Exercise_2 {
	int number;
	public Exercise_2() {
		number = 12;
	}	
	
// 	"public Exercise_2()" is a constructor and must have the same name as the class and cannot have a return type.
	
	public static void main(String[] args) {
		Exercise_2 thing = new Exercise_2();
		System.out.println(thing.number);
		
	}

	// "Exercise_2 thing = new Exercise_2();" is calling on the constructor to create a "number" called "thing".
	
}
