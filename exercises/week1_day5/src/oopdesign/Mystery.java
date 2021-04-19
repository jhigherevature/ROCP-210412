package oopdesign;

public class Mystery extends Book {

	public Mystery(String bookText, String name, String author)
	{
		super(bookText, name, author);
	}

	@Override
	public void Read() {
		// TODO Auto-generated method stub
		System.out.println(bookText);
	}
}