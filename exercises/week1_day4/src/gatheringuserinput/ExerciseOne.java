package gatheringuserinput;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ExerciseOne {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		String userInput;
		double valueToConvert;
		boolean done = false;
		
		do
		{
			System.out.println("Select a conversion:");
			System.out.println("1. Feet to Inches");
			System.out.println("2 Feet to Yards");
			System.out.println("3 Feet to Miles");
			System.out.println("4 Meters to Miles");
			System.out.println("q to exit.");
			userInput = console.next();
		
			switch(userInput)
			{
			case "1": 
				System.out.println("Enter a value to convert: ");
				valueToConvert = console.nextDouble();
				System.out.println(feetToInches(valueToConvert));
				break;
			case "2": 
				System.out.println("Enter a value to convert: ");
				valueToConvert = console.nextDouble();
				System.out.println(feetToYards(valueToConvert));
				break;
			case "3":
				System.out.println("Enter a value to convert: ");
				valueToConvert = console.nextDouble();
				System.out.println(feetToMiles(valueToConvert));
				break;
			case "4":
				System.out.println("Enter a value to convert: ");
				valueToConvert = console.nextDouble();
				System.out.println(metersToMiles(valueToConvert));
				break;
			case "q":
				done = true;
				break;
			default:
				System.out.println("Please enter a valid value.");
				break;
			}
		}
		while(!done);
	}
	
	public static String feetToInches(double feet)
	{
		DecimalFormat df = new DecimalFormat(".00");
		double inches = feet * 12.0;
		String strInches = df.format(inches);
		return strInches;
	}
	
	public static String feetToYards(double feet)
	{
		DecimalFormat df = new DecimalFormat(".00");
		double yards = feet / 3.0;
		String strYards = df.format(yards);
		return strYards;
	}
	
	public static String feetToMiles(double feet)
	{
		DecimalFormat df = new DecimalFormat(".00");
		double miles = feet / 5280.0;
		String strMiles = df.format(miles);
		return strMiles;
	}
	
	public static String metersToMiles(double meters)
	{
		DecimalFormat df = new DecimalFormat(".00");
		double miles = meters / 1609.344;
		String strMiles = df.format(miles);
		return strMiles;
	}
}