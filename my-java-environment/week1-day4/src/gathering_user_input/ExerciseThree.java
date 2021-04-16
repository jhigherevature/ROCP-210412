package gathering_user_input;

import java.util.Scanner;

public class ExerciseThree {
	public static void main(String[] args) {
		conversion();
	}

	private static void conversion() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("\n************");
		System.out.println("Select a Conversion:");
		System.out.println("[1] Feet to Inches");
		System.out.println("[2] Feet to Yards");
		System.out.println("[3] Feet to Miles");
		System.out.println("[4] Meter to Miles");
		System.out.println("[q] Quit the Program");		
		
		String input = s.nextLine();
		
		switch (input) {
			
		case "1": {
			double caseOneInput = valueInput("Feet", "Inches");
			System.out.println(caseOneInput + "(ft) = " + caseOneInput*12 + "(in)");
			conversion();
			break;
		}
		
		case "2": {
			double caseTwoInput = valueInput("Feet", "Yards");
			System.out.println(caseTwoInput + "(ft) = " + caseTwoInput*3 + "(yd)");
			conversion();
			break;
		}
		
		case "3": {
			double caseThreeInput = valueInput("Feet", "Miles");
			System.out.println(caseThreeInput + "(ft) = " + caseThreeInput/5280 + "(miles)");
			conversion();
			break;
		}
		
		case "4": {
			double caseFourInput = valueInput("Meters", "Miles");
			System.out.println(caseFourInput + "(m) = " + caseFourInput/1609.34 + "(miles)");
			conversion();
			break;
			
		}
		
		case "q": {
			System.out.println("Qutting program");
			System.exit(0);
			
		}
		default:
			System.out.println("Input not valid - only enter [1], [2], [3], [4], or [q]");
			conversion();
			break;
		}
	}

	private static double valueInput(String str1, String str2) {
		Double doubInput = (Double) null;
		Scanner ss = new Scanner(System.in);
		
		do {
			System.out.println("\n************");
			System.out.println("Enter a value to convert from " + str1 + " to " + str2 + ":");
			String input2 = ss.nextLine();
			
			for (int i = 0; i < input2.length(); i++) {
				if (Character.isDigit(input2.charAt(i))== true || input2.charAt(i) == '.') {
					doubInput = Double.parseDouble(input2);

				}
				else {
					System.out.println("Input not valid - only enter digits or '.' to indicate a decimal.");
				}
			}
		}
		while (doubInput == (Double) null);

		return doubInput;

		
	}
}
