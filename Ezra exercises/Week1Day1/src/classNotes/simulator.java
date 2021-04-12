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
		
		d.bark();
	}
}
