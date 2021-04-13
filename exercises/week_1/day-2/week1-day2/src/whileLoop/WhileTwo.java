package whileLoop;

public class WhileTwo {
	public static void main(String[] args) {
		int i = -100;
			while(i<101) {
				int even = i % 2;
				
				if (even == 0) {
					int num = i;
					System.out.println(num);
				}
				i++;
			}
	}
}
