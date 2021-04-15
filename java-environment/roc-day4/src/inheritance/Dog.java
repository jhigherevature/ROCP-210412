package inheritance;

public class Dog extends Animals {
	
	Collar collar = new Collar();
	
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
