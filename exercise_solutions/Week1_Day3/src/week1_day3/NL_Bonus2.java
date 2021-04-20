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
public class NL_Bonus2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] First = {"Adam", "Alexis", "Dennis"};
        String[] Second = {"Adamson", "Bond", "Brown"};
        for (int i = 0; i <= First.length-1; i++){
            for (int j = 0; j <= Second.length-1; j++){
                System.out.println(First[i] + " " + Second[j]);
            }
        }
    }
    
}
