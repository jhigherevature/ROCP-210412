package oopdesign;

public abstract class Book implements Readable{

	String bookText;
	String name;
	String author;
	
	public Book(String bookText, String name, String author)
	{
		this.bookText = bookText;
		this.name = name;
		this.author = author;
	}
}