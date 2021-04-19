package exercises;



public class WeatherMachine {

	String city = "Atlanta";
	
	public WeatherMachine() {
	}
	
	public WeatherMachine(String city) {	
		this.city=city;	
	}
	

	
	private static int[] getPastTemps() {
		Thermometer ther = new Thermometer();
		int [] temps = new int[24];
		for (int i=0; i <= temps.length-1; i++) {
			temps[i] = ther.getTemperature();
//			System.out.println(temps[i]);
		}
		return temps;
	}
	
	public void getWeatherReport() {
		int[] z = getPastTemps();
		System.out.println("Your Last 24 hours:"); 
		for (int i=0; i <= z.length-1; i++) {
			System.out.println(i+":00 - "+ z[i]+" degrees");
		}
//		Wierd that it works here but not if I try to add it to line 30..
		System.out.println("We hope you enjoyed the weather in: " + city);
		
	}
	
}
