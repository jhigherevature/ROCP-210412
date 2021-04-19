package oop_design;

public abstract class Book implements Readable, BookInfo{
	String bookText;
	String name;
	String author;
	String bookType;
	
	public void read() {
		System.out.println("Reading " + this.name + "...");
		System.out.println(this.bookText);
	}
	
	public Book(String bookText, String name, String author) {
		super();
		this.bookText = bookText;
		this.name = name;
		this.author = author;
		this.bookType = null;
		
	}
	
	 
}




	

