package accessmodsone;

public class Data {
	private String name;
	private int id;
	private double value;
	
	String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	
}
