package classes;

public class Basics {
	String name;
	int age;
	int phoneNumber;
	
	
	
	//CONSTRUCTOR: used to initialize fields on objects
	public Basics(String name, int age, int phoneNumber) {
		//1. invokes the constructor of the object class in java
		super();//invokes the constructor of the parent class
		
		
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		
	}
	
	//No Args Constructor
	public Basics() {
		//here this keyword is invoked(call to a constructor) and it is referring to the
		//constructor that has a String, int ant int as a parameter
		this("Default Name", 0, 1234567890);
		
	}
	

}
