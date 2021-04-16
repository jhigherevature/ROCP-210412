package writingCompositeClasses;

import java.util.*;

public class WeatherMachine {
    public String city = "";

    public WeatherMachine() {
        city = "Location services disabled.";
    }

    public WeatherMachine(String s) {
        city = "Current location: " + s;
    }

    private static ArrayList<Integer> getPastTemperatures() {
        ArrayList<Integer> temps = new ArrayList<Integer>();
        for (int i = 0; i < 24; ++i) {
            temps.add(Thermometer.getTemperature());
        }
        return temps;
    }

    public void getWeatherReport() {
        System.out.println(city);
        System.out.println("Your Last 24 Hours:");
        ArrayList<Integer> temps = getPastTemperatures();
        for (int i = 0; i < 24; ++i) {
            String time = String.format("%2d", i);
            String temp = String.format("%3d", temps.get(i));
            System.out.println("* " + time + ":00 - " + temp + " degrees");
        }
    }
}
