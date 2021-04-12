package exercises;

public class Person {
	public String name;
	public String address;
	public long id;
	public int age;
	
	public static void main(String[] args) {
		Person person = new Person();
		person.name = "justin";
		person.address = "2932 horse";
		person.id = 26938981L;
		person.age = 24;
		System.out.println(person.address);
	}
	
}
