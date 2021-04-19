package day5;

public class ReadMain {

	public static void main(String[] args) {

		Memoir memoir = new Memoir("My fury is unrelenting","Kitana","Melanie");
		RomanticComedy romance =new RomanticComedy("A match made in Heaven","Tania","Sefa");
		AutoBiography autoBiography = new AutoBiography ("Life of My Father","Akwasi","Chevy");
		
		BookShelf bookShelf =new BookShelf();
		
		bookShelf.addBook(autoBiography);
		bookShelf.addBook(romance);
		bookShelf.addBook(memoir);
		
		
		
	}

}
