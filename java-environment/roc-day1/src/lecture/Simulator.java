package lecture;

public class Simulator {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.name = "Jazz";
		dog.age = 5;
		dog.breed = "Mastiff";
		dog.weight = 123.5;
		System.out.println(dog.name + " is a " + dog.age + " year old " + dog.breed + " and he weighs " + dog.weight + " pounds!!!!");

	}

}
