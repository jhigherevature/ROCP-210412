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
public class While2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x = -10;
        while (x <= 10){
            if (x%2==0)
            System.out.println(x);
            x+=2;
        }
    }
    
}
