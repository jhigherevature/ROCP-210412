package graysonbasics;

public class Simulator {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.name = "Tooth";
		dog.age = 38;
		dog.weight = "extra thicc";
		dog.breed = "Good";
		System.out.println(dog.name);
		System.out.println(dog.breed);
		System.out.println(dog.weight);
	}

}
