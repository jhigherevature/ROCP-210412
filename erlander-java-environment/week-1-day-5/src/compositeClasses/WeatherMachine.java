package compositeClasses;

public class WeatherMachine {
	private String city;
	private int[] pastTemps = new int[24];
	private Thermometer thermometer = new Thermometer();
	
	public WeatherMachine() {
		this.city = "Chicago";
	}
	
	public WeatherMachine(String city) {
		this.city = city;
	}
	
	private int[] getPastTemperatures() {
		for(int i = 0; i < pastTemps.length; i++) {
			pastTemps[i] = thermometer.getTemperature();
		}
		return pastTemps;
	}
	
	public void getWeatherReport() {
		int[] weather = getPastTemperatures();
		
		System.out.println(city + "'s Last 24 Hours:");
		System.out.println("");
		
		for(int i = 0; i < weather.length; i++) {
			System.out.println(i + ":00 - " + weather[i] + " degrees");
		}
	}
}
