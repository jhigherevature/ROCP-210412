package basics;

public class Person {

	private String name;
	private String address;
	private long id;
	private int age;
	
	public Person(String name, String address, long id, int age) {
		this.name = name;
		this.address = address;
		this.id = id;
		this.age = age;
	}
	
	public Person() {
		this.name = null;
		this.address = null;
		this.id = -1;
		this.age = -1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void print() {
		System.out.println("Name: " + this.name);
		System.out.println("Address: " + this.address);
		System.out.println("ID: " + this.id);
		System.out.println("Age: " + this.age);
	}
	
public static class TestPerson{
	public static void main(String[] args) {
		Person person = new Person("Mike", "1234 Anytown USA", 123456, 39);
		person.print();
	}
}
}
