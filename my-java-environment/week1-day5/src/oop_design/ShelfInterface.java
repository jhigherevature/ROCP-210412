package oop_design;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class ShelfInterface{
		
	public static void main(String[] args) {
		Map <String, Book> shelf = new HashMap <String, Book>();
		Magazine m1 = new Magazine("Here is what is in the magazine...", "Magazine Title", "Author M");
		Fiction f1 = new Fiction("Here is what is in the fiction...","Fiction Title", "Author F");
		Nonfiction n1 = new Nonfiction("Here is what is in the nonfiction...","Nonfiction Title", "Author N");
		shelf.put(m1.name, m1);
		shelf.put(f1.name, f1);
		shelf.put(n1.name, n1);


		
		//shelfSearch(shelf);
		
		
		
		
	}
/*
	private static void shelfSearch(Map<String, Book> shelf) {
		Scanner s = new Scanner(System.in);
		System.out.println("How do you want to search for a book?");
		System.out.println("[1] - Title");
		System.out.println("[2] - Author");
		String searchType = s.nextLine();
		
		switch (searchType) {
		case "1": {
			searchByTitle(shelf);
		}
		case "2": {
			searchByAuthor(shelf);
		}
		case "q": {
			System.out.println("\nClosing Shelf");
			System.exit(0);
		}
		default : {
			System.out.println("\nInvalid input, try again");
			shelfSearch(shelf);     
			break;
		}
		}
		
		
		
	}

	private static void searchByTitle(Map<String, Book> shelf) {
		Scanner s = new Scanner(System.in);
		System.out.println("What is the title of the book?");
		String searchTitle = s.nextLine();
		System.out.println(shelf.get(searchTitle));
		
	}

	private static void searchByAuthor(Map<String, Book> shelf) {
		Scanner s = new Scanner(System.in);
		System.out.println("What is the author of the book?");
		String searchAuthor = s.nextLine();
		System.out.println(shelf
			      .entrySet()
			      .stream()
			      .filter(entry -> value.equals(entry.getValue(searchAuthor))))
			      .map(Map.Entry::getKey);

	}
*/	

	
}
