package writing_composit_classes;

public class Simulation {
	
	public static void main(String[] args) {
		
		WeatherMachine wm = new WeatherMachine();
		
		wm.getWeatherReport();
		
		System.out.println();
		
		WeatherMachine wm2 = new WeatherMachine("Portland");
		
		wm2.getWeatherReport();
		
	}

}
