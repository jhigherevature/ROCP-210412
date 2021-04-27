package fuctionalinterfaces;

public class FuctionalInterfaceSimulator {

	public static void main(String[] args) {
//		typical method using interface
//		HelloWorldInterface hwi = new Hello WorldImplementation();
//		hwi.printHello();
		
//		vs using the lambda
		HelloWorldInterface helloLam = () -> {
			System.out.println("Hello World"); 
			};
		helloLam.printHello();
		
//	
		PrintInputInterface print = (str, num) -> {
			System.out.println("The input was: "+str+
					", add the number is: " + num);
		};
		print.printInformation("lambdas rock", 5);
		}
	
}
