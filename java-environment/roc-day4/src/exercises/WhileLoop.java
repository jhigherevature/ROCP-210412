package exercises;

public class WhileLoop {
	public static void main(String[] args) {
		int x = 100;
		while (x >= -100) {
			
			if (x % 2 == 0)
				System.out.println(x);
			
			x-=2;
		}
	}
}
