package oop_design;

import java.util.ArrayList;
import java.util.List;

public class BookShelf {
	
	static List<Book> collection = new ArrayList<Book>();
	
	public static void main(String[] args) {
		
		Book People = new Magazine("Editors", "People", "Celebrity gossip");
		Book Shannara = new Novel("Terry Brooks", "Sword of Shannara", "A story about a warlock and truth");
		Book Science = new Textbook("Bill Nye", "Engineering", "Science even children can understand");
		Book Math = new Textbook("Bill Nye", "Mathematic", "Math even children can understand");
		Book MagicKingdom = new Novel("Terry Brooks", "Magic Kingdom for Sale", "A story about a laywer and his magical kingdom");
		Book Times = new Magazine("Editors", "Times", "Human-interest stories");
		
		collection.add(People);
		collection.add(Shannara);
		collection.add(Science);
		collection.add(Math);
		collection.add(MagicKingdom);
		collection.add(Times);
		
		for(int i = 0; i < collection.size(); i++) {
			System.out.println(collection.get(i).Author + " " + collection.get(i).Title + " " + collection.get(i).bookText);
		}

}
	
}
