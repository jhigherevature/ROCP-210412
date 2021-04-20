/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_day4;

/**
 *
 * @author Brooke Billadeau
 */
public class Exceptions1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws OddNumberException {
        addEven(2,3 );
    }

    public static void addEven(int A, int B) throws OddNumberException {
        if (A % 2 != 0 || B % 2 != 0) {
            throw new OddNumberException();
        }
    }
}

class OddNumberException extends Exception {

}
