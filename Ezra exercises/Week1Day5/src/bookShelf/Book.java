package bookShelf;

import java.util.List;

public abstract class Book {
	public String name = "title";
	public String author = "author";
	public String bookTest = "Text of the book";
//	hash;
	public Integer publish = null;
	
	
	public Book(String name, String author, String bookTest) {
		this.name = name;
		this.author = author;
		this.bookTest = bookTest;
	}
	
	public Book() {
		this.name = "title";
		this.author = "author";
		this.bookTest = "content";
	}
	
	
	
}
