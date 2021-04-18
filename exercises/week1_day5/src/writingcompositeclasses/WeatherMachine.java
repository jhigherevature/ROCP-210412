package writingcompositeclasses;

public class WeatherMachine {

	Thermometer thermometer = new Thermometer();
	String city = "Seattle";
	
	public WeatherMachine()
	{
		super();
	}
	
	public WeatherMachine(String city)
	{
		this.city = city;
	}
	
	private int[] getPastTemperatures()
	{
		int[] temperatures = new int[24];
		
		for(int i = 0; i < 24; i++)
		{
			temperatures[i] = thermometer.getTemperature();
		}
		return temperatures;
	}
	
	public void getWeatherReport()
	{
		int hour = 0;
		WeatherMachine wm = new WeatherMachine();
		int[] temperatures = wm.getPastTemperatures();
		
		for(int i = 0; i < temperatures.length; i++)
		{
			System.out.println(hour + ":00 - " + city + " - " + temperatures[i] + " degrees");
			hour++;
		}
	}
}
