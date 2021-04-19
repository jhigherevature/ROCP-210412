package oopdesign;

public class Fiction extends Book {

	public Fiction(String bookText, String name, String author)
	{
		super(bookText, name, author);
	}

	@Override
	public void Read() {
		// TODO Auto-generated method stub
		System.out.println(bookText);
	}
}