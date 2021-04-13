package methods;

public class Car {
	String make;
	String model;
	String color;
	int numOfTires = 4;
	//this method has a parameter that is
	public void changeColor(String color) {
		//this keyword works only with objects, therefore you cannot use it with a static method
		this.color = color ;
	}

}
