package flowcontrol;

public class WhileLoop {

	public static void main(String[] args) {
		int x = 100;
		while (x < 10) {
			System.out.println("The value of x is: " + x);
			++x;
		}
		System.out.println("The While loop ended!");
		
		int y = 100;
		do {
			System.out.println("The value of y is: " + y);
			++y;
		} while(y < 10);
		System.out.println(y);
		System.out.println("The Do-While loop ended!");
	}
}
