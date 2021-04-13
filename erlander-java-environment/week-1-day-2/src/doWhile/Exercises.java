package doWhile;

public class Exercises {
	
	public static void main(String[] args) {
		//exercise 1	
		int i = 1;
	
		do {
			System.out.println(i);
			i += 2;
		} while (i < 50);
		
		//bonus
		char c = 'a';
		
		do {
			System.out.println(c++);
		} while (c <= 122);
	}
}