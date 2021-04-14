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
public class For_Loop1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       byte[] arrayName = {1,2,3,4,5,6,7,8,9,10};
       for (int index = 0; index < arrayName.length; index++){
           System.out.println(arrayName[index]);
       }
    }
    
}
