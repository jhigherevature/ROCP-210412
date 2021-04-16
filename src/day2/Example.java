package day2;

public class Example {

	public static void main(String[] args) {

		char unichar = '\u0061';

		do {
			System.out.print(unichar + " ");
			unichar++;
		} while (unichar < '\u007B');

	}

}
