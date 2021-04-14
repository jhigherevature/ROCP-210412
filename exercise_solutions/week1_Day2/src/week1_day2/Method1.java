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
public class Method1 {

    public static void main(String[] args) {
        randomNumber();
    }
       public static int randomNumber(){
      double d = Math.random(); //must be double
      d = d*50+1; //between 0 and 50
      int forcedInt = (int) d; //force the double into an integer
      System.out.println(forcedInt); //prints to system
      return forcedInt; //return type
   }
    
    
}
