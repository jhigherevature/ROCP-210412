package methods;

public class Dog {
	public String name;
	public int age;
	public String breed;
	public static int value = 15;
	
	// This is a constructor
	// constructors are used to initialize fields
	// on objects
	public Dog (String name, int age, String breed) {
		super();
		this.name = name;
		this.age = age;
		this.breed = breed;
		
		System.out.println("You created a Dog object");
	}
	
	public Dog () {
		this(null, 0, null);
	}
	
	/*
	 * methods MUST declare a return type, even
	 * if that type is 'void'
	 * 
	 * the void return type means the method will
	 * not use the return keyword, and will not
	 * return any data...
	 */
	public static void bark() {
		System.out.println("Woof Woof!");
//		this.name = "new name"; // this keyword cannot be used with static methods
	}
	
	public String getName() {
		System.out.println(value);
		return name;
	}
	
	/*
	 * Variable shadowing (variable name shadowing)
	 * is when a parameter of a method shares the same
	 * name as a field on our class. Inside the 
	 * method, the parameter is referred to when invoking
	 * the name of the variable.
	 * 
	 * i.e. the parameter is "shadowed" by the class
	 * variable.
	 */
	public void setName(String name) {
		this.name = name;
	}
}
