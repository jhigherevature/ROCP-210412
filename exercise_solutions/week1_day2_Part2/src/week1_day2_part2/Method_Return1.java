/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_day2_part2;

/**
 *
 * @author Brooke Billadeau
 */
public class Method_Return1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getAlphabetArray();
    }
    public static void getAlphabetArray(){
        for (char alpha = 'a'; alpha <= 'z'; alpha++){
            System.out.println(alpha);
        }
    }
    
}
