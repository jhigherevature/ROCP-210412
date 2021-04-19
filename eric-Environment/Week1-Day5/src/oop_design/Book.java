package oop_design;

public abstract class Book implements Readable {

	String Author;
	String Title;
	String bookText;
	
	public Book(String a, String t, String bt) {
		
		Author = a;
		Title = t;
		bookText = bt;
		
	}
	
	public Book() {
		this("Author", "Title", "Text");
	}

}
