package day5;

import java.util.ArrayList;
import java.util.List;

public class BookShelf {

	private List<Book> books;

	public BookShelf() {
		books = new ArrayList<Book>();
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void addBook(Book book) {
		this.books.add(book);
	}

	public List<Book> findBooks(String author) {
		List<Book> results = new ArrayList<Book>();

		for (Book book : this.books) {
			if (book.getAuthor().equals(author))
				results.add(book);
		}
		return results;
	}

	public Book findBook(String name) {
		Book result = null;

		for (Book book : this.books) {
			if (book.getName().equals(name)) {
				result = book;
				break;
			}
		}
		return result;
	}
}
