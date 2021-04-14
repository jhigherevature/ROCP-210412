package day2;

public class Odd {
	public static void main(String[] args) {

		int start = 1;
		
		do {
			
			if (start % 2 == 1)
				System.out.println(start);
			
			start = start + 1;
			
		} while (start <= 49);

	}
}
