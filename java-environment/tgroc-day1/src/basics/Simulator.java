package basics;

public class Simulator {
	
	public static void main(String[] args) {
		
		Dog dog = new Dog();
		dog.name = "Fido";
		dog.age = 4;
		dog.weight = 40.5;
		dog.breed = "Black Lab";
				System.out.println(dog.name);
		System.out.println(dog.age);
		dog.bark();
		
	
		
	}
}
