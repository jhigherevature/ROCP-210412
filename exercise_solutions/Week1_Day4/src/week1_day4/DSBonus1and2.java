/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_day4;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Brooke Billadeau
 */
public class DSBonus1and2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Map<String, String> fruits = new TreeMap<>();
        fruits.put("apple", "A forbidden fruit");
        fruits.put("banana", "A yellow fruit that can be peeled");

        boolean exitCheck = true;
        while (exitCheck) {
            //Menu
            System.out.println("Select an option: ");
            System.out.println("1-Add ");
            System.out.println("2-Remove ");
            System.out.println("3-Edit ");
            System.out.println("4-Enter a fruit");

            Scanner keyboard = new Scanner(System.in);
            int selection = keyboard.nextInt();
            keyboard.nextLine();

            String key;
            String value;

            switch (selection) {
                case 1:
                    System.out.println("Enter a fruit.");
                    key = keyboard.nextLine();
                    System.out.println("Enter a definition.");
                    value = keyboard.nextLine();
                    fruits.put(key, value);
                    break;
                case 2:
                    System.out.println("Remove an available fruit.");
                    System.out.println(fruits.keySet());
                    key = keyboard.nextLine();
                    fruits.remove(key);
                    break;
                case 3:
                    System.out.println("Choose a fruit to edit the definition.");
                    System.out.println(fruits.keySet());
                    key = keyboard.nextLine();
                    System.out.println("Enter an updated definition.");
                    value = keyboard.nextLine();
                    fruits.replace(key, value);
                    break;
                case 4:
                    System.out.println("Enter a fruit.");
                    System.out.println(fruits.keySet());
                    key = keyboard.nextLine();
                    System.out.println(fruits.get(key));
                    break;
                default:
                    System.out.println("Item Not Selected");
            }//End of switch statement 
        }
    }

}
