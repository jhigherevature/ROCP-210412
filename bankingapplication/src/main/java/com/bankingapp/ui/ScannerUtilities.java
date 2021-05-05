package com.bankingapp.ui;

import java.util.Scanner;

public class ScannerUtilities {
	private static Scanner scanner;

	private static void ensureScanner() {
		if (scanner == null)
			scanner = new Scanner(System.in);
	}

	public static int getResponse(int min, int max) {
		ensureScanner();
		int response = -1;
		try {
			response = Integer.parseInt(scanner.nextLine());
			if (response < min || response > max) {
				System.out.println("Please enter a number representing an option");

				return getResponse(min, max);
			}
		} catch (NumberFormatException e) {
			System.out.println("Please enter a number representing an option");
			return getResponse(min, max);
		}
		return response;
	}

	public static double getAmountOfMoney(String prompt) {
		ensureScanner();
		System.out.println(prompt);
		double amount = 0;
		try {
			amount = Double.parseDouble(scanner.nextLine());
			if (amount <= 0) {
				System.out.println("Please enter a valid value for amount");
				return getAmountOfMoney(prompt);
			}

		} catch (NumberFormatException e) {
			System.out.println("Please enter a valid value for amount");
			return getAmountOfMoney(prompt);
		}
		return amount;
	}

	public static String getInputString() {
		ensureScanner();
		return scanner.nextLine();
	}
}
