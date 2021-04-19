package writing_composit_classes;

public class WeatherMachine {
	
Thermometer thermometer = new Thermometer();//this creates a composite relationship between WeatherMachine and thermometer
	
	private int[]pasttemps;//this array will record the temperature, gets its values from the getPastTemperature method
	
	private String[] pasttime = {"0:00","1:00","2:00","3:00","4:00","5:00","6:00","7:00","8:00","9:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00","24:00"};
	//the array above is filled in here because this will be a common array for all instances of this class
		
	public WeatherMachine () {}//nothing special when the no args constructor is used
	
	public WeatherMachine (String city) {//the city we name will be printed before the temps are given
		
		System.out.println(city);
		
	}
	
	private void getPastTemperature() {//we make this private so only this class can call this method
		
		this.pasttemps = new int[25];//you need to create an array with 1 more space than needed
		
		for (int i = 0; i < pasttemps.length; i++) {//this is why it needs to be 1 longer: it holds all the data, and sets your ending parameter
			
			double fill = thermometer.getTemperature();//this has to be a double type, since the getTemperature method uses the double type
			
			this.pasttemps[i] = (int)fill;//fills this pasttemps array in index spot i with the value of fill, which we cast as an int value to fit in the array
			
		}
		
	}
	
	public void getWeatherReport() {//we make this public so the simulation class can call this method
		
		getPastTemperature();//since this method is in the same class it is accessible
		
		System.out.println("Your last 24 hours:");
		System.out.println();//this adds an extra space, looks better
		
		for (int i = 0; i < this.pasttemps.length; i++) {//i represents the index position
			
			System.out.println(this.pasttime[i] + " " + "- " + this.pasttemps[i] + " " + "degrees");
			System.out.println();
			
		}
		
	}

}
