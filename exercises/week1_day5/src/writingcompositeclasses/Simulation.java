package writingcompositeclasses;

public class Simulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WeatherMachine wm = new WeatherMachine();
		WeatherMachine wm2 = new WeatherMachine("Topeka");
		wm.getWeatherReport();
		wm2.getWeatherReport();
	}
}