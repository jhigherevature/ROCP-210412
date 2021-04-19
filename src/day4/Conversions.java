package day4;

import java.util.Scanner;

public class Conversions {

	public static void main(String[] args) {

		/*
		 * Select a conversion: 1. Feet to Inches 2. Feet to Yards 3. Feet to Miles 4.
		 * Meters to Miles
		 */
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Select a conversion or press 9 to quit:");
			System.out.println("1. Feet to Inches");
			System.out.println("2. Feet to Yards");
			System.out.println("3. Feet to Miles");
			System.out.println("4. Meters to Miles");

			int userSelection = scanner.nextInt();
			if (userSelection == 9)
				break;

			System.out.print("Enter a value to convert: ");
			int valueToConvert = scanner.nextInt();

			double convertedValue = 0;

			switch (userSelection) {
			case 1:
				convertedValue = valueToConvert * 12;
				break;
			case 2:
				convertedValue = valueToConvert / 3;
				break;
			case 3:
				convertedValue = valueToConvert / 5280;
				break;
			case 4:
				convertedValue = valueToConvert / 1609;
				break;
			}

			System.out.println("The converted value is: " + convertedValue);
		}
	}

}
