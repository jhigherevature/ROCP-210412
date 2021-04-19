package ooppillars;

import java.util.Scanner;

public class AnimalPicker {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Flyable flyable = new Bat();
		Flyable bird = new Bird();
		flyable.fly();
		flyable.soar();
		
		Animals anim = null;
		
		Animals[] zooAnimals = new Animals[3];
		Dog d = new Dog();
		zooAnimals[0] = d;
		
		System.out.println("Give me Input.");
		String input = scan.nextLine();
		
		switch (input.toLowerCase().intern()) {
		case "dog":
			anim = new Dog("Dillon", 4);
			((Dog) anim).bark();
			break;
		case "shark":
			anim = new Shark();
			((Shark)anim).maim();
			break;
		}
	}
}
