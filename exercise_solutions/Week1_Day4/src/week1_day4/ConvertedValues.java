/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_day4;

import java.util.Scanner;

/**
 *
 * @author Brooke Billadeau
 */
public class ConvertedValues {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instance of a class
        conversions convert = new conversions();

        boolean exitCheck = true;
        while (exitCheck) {
            //Menu
            System.out.println("Select a conversion: ");
            System.out.println("1-Feet to Inches ");
            System.out.println("2-Feet to Yards ");
            System.out.println("3-Feet to Miles ");
            System.out.println("4-Meters to Miles ");
            System.out.println("5-Exit");
            //Receiving Menu Input
            Scanner keyboard = new Scanner(System.in);
            int selection = keyboard.nextInt();

            //Receive Input
            if (selection == 5) {
                exitCheck = false;
                System.out.println("Exiting Program");
                System.exit(0);
            } else {
                System.out.println("Enter a value to convert: ");
                convert.setInput(keyboard.nextDouble());
            }
            //Switch statement for menu options

            switch (selection) {
                case 1:
                    System.out.println("Feet to inches: " + convert.feetInches() + " inches.");
                    break;
                case 2:
                    System.out.println("Feet to Yards: " + convert.feetYards() + " yards.");
                    break;
                case 3:
                    System.out.println("Feet to Miles: " + convert.feetMiles() + " Miles.");
                    break;
                case 4:
                    System.out.println("Meters to Miles: " + convert.metersMiles() + " Miles.");
                    break;
                default:
                    System.out.println("Item Not Selected");
            }//End of switch statement   
        }//End of while loop

    }//End of main method

    public static class conversions {

        double inputNum;

        public void setInput(double input) {
            inputNum = input;
        }

        public double getInput() {
            return inputNum;
        }

        //Convert feet to inches
        public double feetInches() {
            return inputNum * 12;
        }

        //Convert feet to yards
        public double feetYards() {
            return inputNum / 3;
        }

        //Convert feet to miles
        public double feetMiles() {
            return inputNum / 5280;
        }

        //Convert meters to miles
        public double metersMiles() {
            return inputNum / 1609.34;
        }
    }//End of conversions class
}
