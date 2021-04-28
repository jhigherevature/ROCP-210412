package functionalinterfaces;

public class FunctionalInterfaceSimulator {

	public static void main(String[] args) {
		// This creates an object that implements the interface
		HelloWorldInterface hwi = new HelloWorldImplementation();
		hwi.printHello();
		
		// This creates an object using Lambdas!
		HelloWorldInterface helloLam = () -> { 
			System.out.println("Hello World - Lambda Version!"); 
		};
		helloLam.printHello();
		
		
		PrintInputInterface print = (str, num) -> {
			System.out.println("The input was: " + str + 
					", the number plus 5 is: " + (num+5));
		};
		
		print.printInformation("Lambdas are kinda cool!", 10);
	}
}
