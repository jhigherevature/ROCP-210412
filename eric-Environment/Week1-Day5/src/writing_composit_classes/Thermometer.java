package writing_composit_classes;

import java.lang.Math;

public class Thermometer {
	
	public double getTemperature(){
		//this returns a random value between 0 and 108 Fahrenheit
		return Math.random()*108 + 0;//Math.random provides a numb between 0 and 1, 108 sets the max value, 0 sets the min value
	}

}
