package gatheringUserInput;

public class Converter {

	public double feetToInches(double feet) {	
		return feet * 12;		
	}
	
	public double feetToYards(double feet) {
		return feet / 3;
	}
	
	public double feetToMiles(double feet) {
		return feet / 5280;
	}
	
	public double metersToMiles(double meters) {
		return meters / 1609.34;
	}
	
	public void conversionSelection() {
		System.out.println("Select a conversion:");
		System.out.println("1. Feet to Inches");
		System.out.println("2. Feet to Yards");
		System.out.println("3. Feet to Miles");
		System.out.println("4. Meters to Miles");
		System.out.println("9. Quit");
		System.out.println("--------------------");
	}
	
}
