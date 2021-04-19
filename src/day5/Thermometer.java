package day5;

import java.util.Random;

public class Thermometer {
	
	public int getTemperature() {
		
		Random random = new Random();
		return random.nextInt(109);
	}

}
