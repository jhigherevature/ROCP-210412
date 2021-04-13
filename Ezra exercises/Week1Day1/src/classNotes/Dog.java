package classNotes;

public class Dog {
	String name;
	int age;
	double weight;
	String breed;
	
//	default variables seem to break it
	
//	static initializer block
	{
	name = "Rudolph";
	age = 3;
	weight = 30;
	breed = "unknown";
	}
	
	public void bark()	{
		System.out.println("bark, bark");
	}
	public void mark() {
		System.out.println("pssss(this code now belongs to me)");
	}
		

}
