package bookShelf;

public interface Readable {
	String bookText = null;

	public default void readable() {
		System.out.println(bookText);
//		return bookText;
	}

}
