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
public class Para_Bonus1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println(findFirstWord("cat", "dog"));
       
    }//End of main method
    public static String findFirstWord(String A, String B){
        if (A.compareTo(B) > 0){
            return B;
        }
        else if (A.compareTo(B) < 0){
           return A; 
        }
        else {
            return A;
        }
    }//End of findFirstWord Method
}
