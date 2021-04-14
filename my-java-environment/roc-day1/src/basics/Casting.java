package basics;

public class Casting {

	public static void main(String[] args) {
		int num = 65;
		double decimal = num;
		
		double decimal_2 = 65.0;
		int num_2 = (int) decimal_2;
		
		char letter = (char) num;
		System.out.println(letter);
		
		byte b = (byte)-129;
		System.out.println(b);
		
		for (int i=-128; i<1000; i++) {
			byte bb = (byte)i;
			System.out.println(bb);
		}
	}

}
