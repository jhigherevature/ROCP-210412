package inheritance;

public class Simulator {
	public static void main(String[] args) {
		Animals anim = new Animals("Animal", "Animal", 10);
		anim.sleep();
		
		Dog dog = new Dog();
		dog.sleep();
		
		Cat cat = new Cat("Charles", 4);
		cat.sleep();
	}
}
