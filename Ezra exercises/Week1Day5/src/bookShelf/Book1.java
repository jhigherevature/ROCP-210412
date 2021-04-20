package bookShelf;

public class Book1 extends Book implements Readable{
	public String name = "Dianetics";
	public String author = "L Ron Hubbard";
	public String bookTest = "This is scientology!!!";
	
	Book1 var = new Book1();
	var.readable();
	
}
