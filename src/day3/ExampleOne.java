package day3;

public class ExampleOne {

	public static void main(String[] args) {

		int[] a = { 1, 3, 4, 7, 5, 9, 6, 10, 12, 100};
		int[] b = { 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 15 };

		displayArrayStatistics(a, b);

	}

	static void displayArrayStatistics(int[] a, int[] b) {

		int countEvenForA = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				countEvenForA++;
			}
		}

		int countEvenForB = 0;
		
		for (int i = 0; i < b.length; i++) {
			if (b[i] % 2 == 0) {
				countEvenForA++;
			}
		}

		if (countEvenForA > countEvenForB) {
			System.out.println("A contains more even numbers");
		} else {
			System.out.println("B contains more even numbers");
		}
		
		if (a.length > b.length) {
			System.out.println("A contains more numbers");
		} else {
			System.out.println("B contains more numbers");
		}
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 3 == 0) {
				countEvenForA++;
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 3 == 0) {
				countEvenForA++;
			}
		}
		if (countEvenForA > countEvenForB) {
			System.out.println("A contains more value that are multiples of 3");
		} else {
			System.out.println("B contains more value that are multiples of 3");
		}
	}
}
