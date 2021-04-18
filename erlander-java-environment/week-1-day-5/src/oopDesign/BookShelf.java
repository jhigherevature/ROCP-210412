package oopDesign;

import java.util.List;
import java.util.ArrayList;

public class BookShelf {

	private List<Book> Books = new ArrayList<Book>();
	
	public void addBook(Book book) {
		Books.add(book);
	}
	
	public void removeBook(Book book) {
		Books.remove(book);
	}
	
	public List<Book> getBooks() {
		return Books;
	}
	
	
	public List<Book> getBooksByType(String type) {
		List<Book> BooksOfType = new ArrayList<Book>();
		switch(type.toLowerCase()) {
		case "novel" :
			for(Book book : Books) {
				if(book instanceof Novel) {
					BooksOfType.add(book);
				}
			}
			break;
		case "magazine" :
			for(Book book : Books) {
				if(book instanceof Magazine) {
					BooksOfType.add(book);
				}
			}
			break;
		case "collection" :
			for(Book book : Books) {
				if(book instanceof Collection) {
					BooksOfType.add(book);
				}
			}
			break;
		default :
			break;
		}
		return BooksOfType;
	}
	
	public Book getBookByTitle(String title) {
		for(Book book : Books) {
			if(book.getName().equalsIgnoreCase(title)) {
				return book;
			}
		}
		
		return null;
	}

}
