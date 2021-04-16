package ooppillars;

import java.util.Scanner;

public class AnimalPicker {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Animals anim = null;
		
		System.out.println("What animal do you want?");
		String input = scan.nextLine();
		
		switch (input) {
		case "dog":
//			creating an dog object but the variable is only taking the animal object info from that object
			anim = new Dog("Dillon", 4);
//			anim is referencing the animal info in the dog object so need to cast it to being a dog to ove reference variable to the dog object info
			((Dog) anim).bark();
			break;
		case "shark":
			
		}
	}

}
