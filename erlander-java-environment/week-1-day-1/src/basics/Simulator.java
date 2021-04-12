package basics;

public class Simulator {

	public static void main(String[] args) {
		Person person = new Person("Mike", "1234 Anytown USA", 123456, 39);
		Person defaultPerson = new Person();
		
		person.print();
		System.out.println("------------------------------");
		defaultPerson.print();
		
		person.setName("Michael");
		System.out.println("------------------------------");
		person.print();
	}

}
