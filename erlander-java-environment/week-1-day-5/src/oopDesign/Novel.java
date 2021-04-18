package oopDesign;

public class Novel extends Book{
	private boolean fiction;
	
	public Novel() {
		super();
		this.setFiction(true);
	}
	
	public Novel(String bookText, String name, String author) {
		super(bookText, name, author);
		this.setFiction(true);
	}
	
	public Novel(String name, String author) {
		super(name, author);
		this.setFiction(true);
	}

	public boolean isFiction() {
		return fiction;
	}

	public void setFiction(boolean fiction) {
		this.fiction = fiction;
	}
}
