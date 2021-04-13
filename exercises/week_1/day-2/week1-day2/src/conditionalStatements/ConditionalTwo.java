package conditionalStatements;

public class ConditionalTwo {

	public static void main(String[] args) {
		int number = 0;
		number = number %2;
		if(number ==1) {
			System.out.println("number is odd");
		}
		else if(number ==0) {
			System.out.println("number is even");
		}
		else {
			System.out.println("False Value");
		}
		}
	
}
