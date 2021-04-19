package writing_composite_classes;

public class WeatherMachine {
	private String city;
	
	private static int[] getPastTemperatures() {
		int[] temps = new int[24];
		for (int i = 0; i < 24; i++) {
			temps[i] = Thermometer.getTemperature();
			
		}
		return temps;	
	}

	
	public void getWeatherReport() {
		int[] temps = getPastTemperatures();
		System.out.println(city + "'s Last 24 Hours:");
		
		for (int i = 0; i < 24; i++) {
			System.out.println(i + ":00 - " + temps[i] + " degrees");
		}

	}

	WeatherMachine() {
		this.city = "City";
	}
	
	WeatherMachine(String city2) {
		this.city = city2;
	}
}
