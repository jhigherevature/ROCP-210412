package oopDesign;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Simulator {

	public static void main(String[] args) {
		BookShelf shelf = new BookShelf();
		Map<String, String> magazine1Articles = new HashMap<String, String>();
		
		
		
		Novel novel1 = new Novel("some text", "Java Academy 6: Citizens On Patrol", "Michael Erlander");
		shelf.addBook(novel1);
		
		
		String[] storyTitles = {"Inheritence", "Polymorphism", "Abstraction"};
		Collection shortStories = new Collection("A bunch of text", "Scary Java Stories To Tell In the Dark", "Michael Erlander", 3, storyTitles);
		shelf.addBook(shortStories);
		
		magazine1Articles.put("Michael Erlander", "Great article about stuff");
		Magazine magazine1 = new Magazine("so many articles", "Java Weekly", 59, magazine1Articles);	
		shelf.addBook(magazine1);
		
		List<Book> allBooks = shelf.getBooks();
		
		for(Book book : allBooks) {
			System.out.println(book.getName());
		}
		
		List<Book> novels = shelf.getBooksByType("novel");
		for(Book book : novels) {
			System.out.println(book.getName());
		}
		
		shelf.getBookByTitle("Java Weekly").readBook();

	}

}
