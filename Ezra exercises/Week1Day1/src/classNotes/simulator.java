package classNotes;
 

public class simulator {
	public static void main(String[] args) {
		Dog d = new Dog();
		d.name = "Fido";
		d.age = 4;
		d.weight = 40.5;
		d.breed = "black lab";
		System.out.println(d.name);
		System.out.println(d.age);
		System.out.println(d.weight);
		System.out.println(d.breed);
		
		d.bark();
		d.mark();
		

		Dog Brandon = new Dog();
		System.out.println(Brandon.name + " name of Brandon dog object");
		
		Dog dog = new Dog();
		System.out.println(dog.name);
		System.out.println(dog.age);
		System.out.println(dog.weight);
		System.out.println(dog.breed);

		
	}
}
