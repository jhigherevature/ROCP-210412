package methods;
	
public class Dog {
	public String name;
	public int age;
	public String breed;
	public static int value = 15;
	
	
	//this is a constructor
	//constructor are used to initialize fields on objects
	public Dog(String name, int age, String breed) {
		//super();
		this.name = name;
		this.age = age;
		this.breed = breed;
		System.out.println("you created a Dog object");
	}
	public Dog( ) {
		this("default name", 0, "dog");
	}
	
	/*
	 * the void return type means the method will not use
	 * the return, keyword, and will not return any data...
	 * 
	 * methods MUST declare a return type, even if that
	 * type is 'void'
	 */
	public static void bark() {
		System.out.println("Woof Woof!");
	}
	public String getName() {
		return name;
	}
	/* variable shadowing(variable name shadowing)
	 * is when a parameter of a method shares the same name
	 * as field on our class. inside the method, the 
	 * parameter is referred to when invoking
	 * the name of the variable.
	 * 
	 * i.e. the parameter is "shadowed" by the class
	 * variable
	 */
	public void changeName(String name) {
		this.name = name;
	}
}
