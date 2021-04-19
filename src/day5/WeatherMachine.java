package day5;

public class WeatherMachine {

	private Thermometer thermometer;
    private String city;
    
	public WeatherMachine() {
		this.thermometer = new Thermometer();
		this.city = "NeverLand";
	}
	
	public WeatherMachine(String city) {
		this();
		this.city = city;
	}

	private int[] getPastTemperatures() {
		int[] temperatures = new int[24];

		for (int i = 0; i < temperatures.length; i++) {
			temperatures[i] = thermometer.getTemperature();
		}

		return temperatures;
	}

	public void getWeatherReport() {
		System.out.println("Your weather report for " + this.city + " in the Last 24 Hours:");
		int[] temperatures = getPastTemperatures();

		for (int i = 0; i < temperatures.length; i++) {
			System.out.println("* " + i + ":00 - " + temperatures[i] + " degrees");
		}
	}

}
