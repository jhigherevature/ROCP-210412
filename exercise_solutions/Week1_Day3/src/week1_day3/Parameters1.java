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
public class Parameters1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float[] array = square(2,3,4,5);
        
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    
        
    } //End of main
    public static float[] square (int one, int two, int three, int four){
        float[] theReturn = {(float) Math.pow(one,2), (float) Math.pow(two, 2), (float) Math.pow(three, 2), (float) Math.pow(four, 2) };
        return theReturn;
    }  //end of method 
}
