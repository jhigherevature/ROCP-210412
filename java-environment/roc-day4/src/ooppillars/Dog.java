package ooppillars;

public class Dog extends Animals implements Carnivorous, Herbivorous {
	
	Collar collar = new Collar();
	
	public void eat(String dogFood) {
		System.out.println("With my mouth full");
	}
	
	public Dog() {
		super();
	}
	
	public Dog(String name, int age) {
		super(name, "Dog", age);
	}
	
	public void bark() {
		System.out.println("Woof Woof!");
	}
	
	public void wagTag() {
		System.out.println(name + " is wagging its tail");
	}
}
