package basics;

import second.Cat;

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
		
		Cat cat = new Cat();

		/* Since Parrot is in the default package
		 * we cannot reference where to import
		 * the data from. 
		 */
//		Parrot p = new Parrot();
		
	}
}
