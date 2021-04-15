/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_day3;

/**
 *
 * @author Brooke Billadeau
 */
public class NL_Bonus1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] numbers = {1,2,3};
        String [] alphabet = {"A", "B", "C"};
        letters: for (char letter = 'A'; letter <= 'C'; letter++){
            numbers: for(int num = 1; num <= 3; num++){
                System.out.println(letter+ "-" + num);
                break numbers;
            }
        }
    }
    
}
