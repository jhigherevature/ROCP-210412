/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_day5;

import java.util.Random;

/**
 *
 * @author Brooke Billadeau
 */
public class Thermometer {
    public int getTemperature(){
        int max= 108; //Max boundry of 108
        Random rand = new Random(); //instantiates the Random object
        return rand.nextInt(max); //Generates and returns random value within the range
    }
}
