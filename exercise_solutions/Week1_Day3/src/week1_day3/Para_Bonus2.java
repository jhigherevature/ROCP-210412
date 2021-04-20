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
public class Para_Bonus2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] A = {7,8,9,10,11,12};
        int [] B = {1,2,3,4};
        displayArrayStatistics(A,B);
    }//End of main method
    
    public static void displayArrayStatistics(int [] A, int [] B){
        
        String moreData = "A and B have the same amount of data.";
        String moreEvens = "A and B have the same number of even elements.";
        String moreThrees = "A and B have the same number of elements that are multiples of 3.";
        
        //more Data
        if (A.length<B.length){
            moreData = "B has more data.";
        }
        else if (A.length>B.length) {
            moreData = "A has more data.";
        }
        
        int evenNum;
        int multiThree;
        int countEven = 0;
        int countThree = 0;
        for (int i = 0; i < A.length; i++){
            if (A[i]%2 == 0){
                countEven++;
            }
            if(A[i]%3 == 0){
                countThree++;
            }
        }
        
        evenNum = countEven;
        countEven = 0;
        multiThree= countThree;
        countThree= 0;
        
        for (int i = 0; i < B.length; i++){
            if (B[i]%2 == 0){
                countEven++;
            }
            if(B[i]%3 == 0){
                countThree++;
            }
        }
        
        if (countEven>evenNum){
            moreEvens = "B contains more even numbers.";
        }
        if (countEven<evenNum){
            moreEvens = "A contains more even numbers.";
        }
        if (countThree>multiThree){
            moreThrees = "B contains more multiples of three.";
        }
        if (countThree<multiThree){
            moreThrees = "A contains more multiples of three.";
        }
        
        System.out.println(moreData);
        System.out.println(moreEvens);
        System.out.println(moreThrees);
    }//End of method
}
