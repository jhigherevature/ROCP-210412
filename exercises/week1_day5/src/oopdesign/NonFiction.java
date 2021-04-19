package oopdesign;

public class NonFiction extends Book {

	public NonFiction(String bookText, String name, String author)
	{
		super(bookText, name, author);
	}

	@Override
	public void Read() {
		// TODO Auto-generated method stub
		System.out.println(bookText);
	}
}