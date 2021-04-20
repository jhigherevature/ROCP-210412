/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_day5;

/**
 *
 * @author Brooke Billadeau
 */
public class weatherMachine {
    
    private int[] getPastTemperatures(){
        int[] tempArray = new int[24];
        for (int i = 0; i < tempArray.length; i++){
            Thermometer thermometer = new Thermometer();
            tempArray[i] = thermometer.getTemperature();
        }//End of for loop
        return tempArray;
    }//End of private method
    
    public void getWeatherReport(){
        int[] tempArray = getPastTemperatures();
        for (int i = 0; i < tempArray.length; i++){
            String s = String.valueOf(i);
            String s2 = String.valueOf(tempArray[i]);
            System.out.println(i + ":00 - " + s2 + " degrees");
            
        }//End of for loop
    }//End of public method
}
