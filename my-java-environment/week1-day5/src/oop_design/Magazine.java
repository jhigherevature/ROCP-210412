package oop_design;

public class Magazine extends Book{

	public Magazine(String bookText, String name, String author) {
		super(bookText, name, author);
		this.bookType = "magazine";
	}

}
