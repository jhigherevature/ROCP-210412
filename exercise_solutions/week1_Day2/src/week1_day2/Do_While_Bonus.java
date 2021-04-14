/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_day2;

/**
 *
 * @author Brooke Billadeau
 */
public class Do_While_Bonus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[] Array = {'A', 'B', 'C'}; //Imagine the whole alphabet
        int loop = 1; //To loop through the array
        do {
            System.out.println(Array);
            loop++; //To exit the loop
        } while (loop == 1);
    } 
    
}
