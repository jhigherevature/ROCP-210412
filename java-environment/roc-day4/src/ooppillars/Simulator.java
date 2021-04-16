package ooppillars;

public class Simulator {
	public static void main(String[] args) {
		Animals anim = new Shark();
//		anim.sleep();
		
		Dog dog = new Dog();
		dog.sleep();
		
		Cat cat = new Cat("Charles", 4);
		cat.sleep();
	}
}
