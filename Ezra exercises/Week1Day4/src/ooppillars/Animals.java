package ooppillars;

public abstract class Animals {
	public String name;
	public String type;
	public int age;
	
//	static NameGenerator generator = new NameGenerator();
	
	private static String defaultName = "";
	
	private static String generateDefaultName() {
		defaultName += "a";
		return defaultName;
	}
	
	public Animals() {
//		this.name = generator.generateDefaultName();
		this.type = "Animal";
		this.age = 0;
	}
	
	public Animals(String type, int age) {
		this (generateDefaultName(), type, age);
	}
	
	public Animals(String name, String type, int age) {
		this.name = name;
		this.type = type;
		this.age = age;
	}
	
	public void sleep() {
		System.out.println(this.name + " is sleeping!");
	}
}
