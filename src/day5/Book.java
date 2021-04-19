package day5;

public abstract class Book implements Readable {

	private String bookText;
	private String name;
	private String author;
	
	public Book(String bookText, String name, String author) {
		this.bookText = bookText;
		this.name= name;
		this.author = author;
	}
	
	public void read() {
		System.out.print(bookText);
	}

	public String getBookText() {
		return bookText;
	}

	public void setBookText(String bookText) {
		this.bookText = bookText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
