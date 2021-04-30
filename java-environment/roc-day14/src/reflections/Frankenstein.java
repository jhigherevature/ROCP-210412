package reflections;

public class Frankenstein {
	private int id;
	private String name;
	public double pubNumber;
	protected static boolean isHungry;

	public Frankenstein() {
		super();
	}

	public Frankenstein(int id, String name, double pubNumber) {
		super();
		this.id = id;
		this.name = name;
		this.pubNumber = pubNumber;
	}
	
	public void method(String a, int b, float c) {
		System.out.println("We will use this to examine methods in reflections");
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	protected double getPubNumber() {
		return pubNumber;
	}

	void setPubNumber(double pubNumber) {
		this.pubNumber = pubNumber;
	}

	public static boolean isHungry() {
		return isHungry;
	}

	public static void setHungry(boolean isHungry) {
		Frankenstein.isHungry = isHungry;
	}

	@Override
	public String toString() {
		return "Frankenstein [id=" + id + ", name=" + name + ", pubNumber=" + pubNumber + "]";
	}
}
