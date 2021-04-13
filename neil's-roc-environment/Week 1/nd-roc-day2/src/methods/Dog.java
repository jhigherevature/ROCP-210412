package methods;

public class Dog {
	public String name;
	public static int value = 15;
	
	//This is a constructor
	//Constructors are used to initialize fields on objects.
	public Dog (String name) {
		this.name = name;
	}
	
	public static void bark() {
		System.out.println("Woof Woof!");
	}
	
	public String getName() {
		System.out.println(value);
		return name;
	}
	

}
