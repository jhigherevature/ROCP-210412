package oop_design;

public class Fiction extends Book{

	public Fiction(String bookText, String name, String author) {
		super(bookText, name, author);
		this.bookType = "fiction";
	}

}
