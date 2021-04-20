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
public class UserInput1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanner input
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        //counts the number of vowels
        int counter = 0;
        //iterates through input string
        for (int i = 0; i < input.length(); i++) {
            //extracts character and assigns it to match against
            String test = "" + input.charAt(i);
            //checks if test character matches a vowel
            if (test.matches("[aeiou]")){
                counter++;
            }
        }//End of for loop
        
        System.out.println("The number of vowels: " + counter);
    }
    
}
