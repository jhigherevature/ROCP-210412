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
        int i = 1;
        for (char letter = 'A'; letter <= 'Z'; letter++){
            System.out.print(letter + "-" );
            for( ; ; ){
                System.out.println(i);
                i++;
                break;
            } //End of inner numbers
        }//End of outer letters
    } //End of Main
    
}
