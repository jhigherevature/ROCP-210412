package basics;

import second.Cat;

public class Simulator {
	public static void main(String[]args) {
		Dog dog = new Dog();
		dog.name = "Milo";
		dog.age = 1;
		dog.weight = 94.5;
		dog.breed = "Golden Doodle";
		System.out.println("Dog name: " + dog.name);
		System.out.println("Dog age: " + dog.age);
		System.out.println("Dog weight: " + dog.weight);
		System.out.println("Dog breed: " + dog.breed);
		dog.bark();
		
		
		Cat cat = new Cat();
	}
	
	
}
