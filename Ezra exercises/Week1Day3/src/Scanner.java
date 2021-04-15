import java.util.Scanner;

public class Scanner {

	
//	calls scanner - ability to input info
	Scanner scan = new Scanner(System.in);
	
//	print msg to user asking for input
	System.out.println("Input!!!!!!");
	
//	take entire line of input from console that user types and stores it as String called input
	String input = scan.nextLine();
	
//	print it out for fun
	System.out.println(input);
	
//	close scanner
	scan.close();
}
}
