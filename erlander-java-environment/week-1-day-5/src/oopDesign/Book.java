package oopDesign;

public abstract class Book implements Readable{
	private String bookText;
	private String name;
	private String author;
	
	public Book() {
		this.setBookText(null);
		this.setName(null);
		this.setAuthor(null);
	}
	
	public Book(String bookText, String name, String author) {
		this.setBookText(bookText);
		this.setName(name);
		this.setAuthor(author);
	}
	
	public Book(String name, String author) {
		this.setBookText(null);
		this.setName(name);
		this.setAuthor(author);
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
	
	public void readBook() {
		System.out.println(this.getBookText());
	}
}
