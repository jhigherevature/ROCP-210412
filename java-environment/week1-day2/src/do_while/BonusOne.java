package do_while;

public class BonusOne {
	public static void main(String[] args) {
		char letter = '`';
		int i = 1;
		
		do {
			System.out.println((char)(letter + i));
			i++;
		}
		while (i <= 26);
		
		
	}


}
