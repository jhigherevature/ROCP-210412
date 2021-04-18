package gatheringUserInput;

import java.util.Scanner;

public class Simulator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Converter converter = new Converter();
		int choice;
		String valueString;
		double value = 0;
		double convertedValue = 0;
		boolean valid = true;

		boolean quit = false;

		while (!quit) {
			converter.conversionSelection();

			if (scan.hasNextInt()) {

				choice = scan.nextInt();

				switch (choice) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 9:
					quit = true;
					break;
				default:
					valid = false;
					System.out.println("Please enter a valid choice. (1, 2, 3, 4, or 9 to quit)");
					break;
				}
			} else {
				System.out.println("Please enter a valid choice. (1, 2, 3, 4, or 9 to quit)");
				continue;
			}

			if (quit || !valid)
				continue;

			System.out.print("Enter a value to convert: ");
			if (scan.hasNext()) {
				valueString = scan.next();
				
				value = Double.parseDouble(valueString);

				switch (choice) {
				case 1:
					convertedValue = converter.feetToInches(value);
					break;
				case 2:
					convertedValue = converter.feetToYards(value);
					break;
				case 3:
					convertedValue = converter.feetToMiles(value);
					break;
				case 4:
					convertedValue = converter.metersToMiles(value);
					break;
				default:
					break;
				}
			}

			System.out.println("The converted value is: " + convertedValue);
			System.out.println("-----------------------------------");

		}
		
		System.out.println("Goodbye");

		scan.close();

	}

}
