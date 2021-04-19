package oop_design;

public class Nonfiction extends Book{

	public Nonfiction(String bookText, String name, String author) {
		super(bookText, name, author);
		this.bookType = "nonfiction";
	}

}
