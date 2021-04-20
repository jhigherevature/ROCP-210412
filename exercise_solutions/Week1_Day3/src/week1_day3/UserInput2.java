/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_day3;

import java.util.Scanner;

/**
 *
 * @author Brooke Billadeau
 */
public class UserInput2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Select an Option:\n1 - Move right\n2 - Move Left"
                + "\n3 - Move Up\n4 - Move Down\nq - exit program");
        boolean exitCheck = true;
        while (exitCheck) {

            switch (scan.nextLine()) {
                case "1":
                    System.out.println("Moving Right");
                    break;
                case "2":
                    System.out.println("Moving Left");
                    break;
                case "3":
                    System.out.println("Moving Up");
                    break;
                case "4":
                    System.out.println("Moving Down");
                    break;
                case "q":
                    exitCheck = false;
                    System.out.println("Exiting Program");
                    break;
                default:
                    System.out.println("Try again. Acceptable input: [1 - Move right, 2 - Move Left, 3 - Move Up, 4 - Move Down, q - exit program]");
            }
        }
        scan.close();
    }//end of main method

    public static String Input() {
        //Scanner input
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        return input;
    }//end of input method
}
