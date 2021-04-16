package gatheringUserInput;

import java.util.Scanner;
import java.util.function.Function;

public class Exercise3 {
    public static String feetToInches(float feet) {
        return Float.toString(feet * 12) + " in";
    }

    public static String feetToYards(float feet) {
        return Float.toString(feet / 3) + " yds";
    }

    public static String feetToMiles(float feet) {
        return Float.toString(feet / 5280) + " mi";
    }

    public static String metersToMiles(float meters) {
        return Float.toString(meters / 1609) + " mi";
    }

    public static void menu() {
        String mainMenu = "Welcome to the unit converter.\n\n" + "(1) Feet to Inches\n" + "(2) Feet to Yards\n"
                + "(3) Feet to Miles\n" + "(4) Meters to Miles\n" + "(q) to quit\n\n" + "Please make your selection: ";
        Scanner scan = new Scanner(System.in);

        program: while (true) {
            System.out.print(mainMenu);
            String choice = "";
            Function<Float, String> method = null;

            do {
                String input = scan.nextLine();
                switch (input) {
                case "1":
                    choice = "Feet to Inches";
                    method = Exercise3::feetToInches;
                    break;
                case "2":
                    choice = "Feet to Yards";
                    method = Exercise3::feetToYards;
                    break;
                case "3":
                    choice = "Feet to Miles";
                    method = Exercise3::feetToMiles;
                    break;
                case "4":
                    choice = "Meters to Miles";
                    method = Exercise3::metersToMiles;
                    break;
                case "q":
                    break program;
                default:
                    System.out.print("Selection not found. Try again? : ");
                    break;
                }
            } while (method == null);

            Float number = null;
            System.out.print("\nSelected " + choice + ", input value: ");

            do {
                try {
                    number = Float.parseFloat(scan.nextLine());
                } catch (NumberFormatException e) {
                    System.out.print("Unable to cast to float, try again: ");
                }
            } while (number == null);

            String result = method.apply(number);
            System.out.print("\nThe result is : " + result + "\n\nGo again? (y/n) : ");

            quit: while (true) {
                String confirm = scan.nextLine();
                switch (confirm) {
                case "y":
                    break quit;
                case "n":
                    System.out.println("\nThank you!\n");
                    break program;
                default:
                    System.out.print("Choices are (y)es or (n)o: ");
                    continue quit;
                }
            }

            System.out.println();
        }
        scan.close();
    }

    public static void main(String[] args) {
        menu();
    }
}
