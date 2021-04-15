package inheritance;

public class Cat extends Animals {
	
	public Cat(int age) {
		super("Cat", age);
	}
	
	public Cat(String name, int age) {
		super(name, "Cat", age);
	}
}
