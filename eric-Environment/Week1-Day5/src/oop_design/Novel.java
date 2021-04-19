package oop_design;

public class Novel extends Book {
	
	public Novel() {
		super();
	}
	
	public Novel (String a, String t, String bt) {
		super( a, t, bt);
	}

	@Override
	public String getAuthor() {
		return Author;
	}

	@Override
	public void setAuthor(String Author) {
		this.Author = Author;
	}

	@Override
	public String getTitle() {
		return Title;
	}

	@Override
	public void setTitle(String Title) {
		this.Title=Title;
	}

	@Override
	public String getbookText() {
		return bookText;
	}

	@Override
	public void setBookText(String bookText) {
		this.bookText=bookText;
	}

}
