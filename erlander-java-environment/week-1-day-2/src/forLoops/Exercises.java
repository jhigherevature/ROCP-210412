package forLoops;

public class Exercises {

	public static void main(String[] args) {
		// exercise
		byte[] bytes = { 1, 9, 2, 8, 3, 7, 4, 6, 5, 0 };
		int i;

		for (i = 0; i < bytes.length; i++) {
			System.out.println(bytes[i]);
		}

		// bonus
		for (i = 100; i > 0; i--) {
			if (i % 2 == 0) {
				continue;
			}
			System.out.println(i);
		}

	}

}
