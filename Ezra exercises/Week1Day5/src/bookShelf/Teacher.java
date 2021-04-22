// Readable Interface:
public interface Readable {
    public void read();
}
// book class
public abstract class Book implements Readable {
    private String name;
    private String author;
    private String text;
    public Book(String name, String author, String text) {
        this.name = name;
        this.author = author;
        this.text = text;
    }
    public void read() {
        System.out.println(text);
    }
    // getters and setters...
    public String getText() {
        return text;
    }
    // other getters and setters below...
}
// Implemented Book Class:
public class Novel extends Book {
    private String genre;
    public Novel (String name, String author, String text, String genre) {
        super(name, author, text);
        this.genre = genre;
    }
    // overridden read method
    public void read() {
        System.out.println(name + " written by : " + author);
        System.out.println(text);
    }
}
// BookShelf Class:
// make sure to import the List and ArrayList
public class BookShelf {
    public List<Book> books = new ArrayList<Book> ();
    public static void main(String[] args) {
        BookShelf shelf = new BookShelf();
        shelf.addNovel("Book Content", "Huck Finn", "Mark Twain", "Fiction");
        shelf.addNovel("Book Content", "Harry Potter", "JK Rowling", "Fantasy");
        shelf.addNovel("Book Content", "Lord of the Rings", "JRR Tolkein", "Fantasy");
        shelf.addNovel("Book Content", "Tom Sawyer", "Mark Twain", "Fiction");
        for (Book b : shelf.findBooksByAuthor("Mark Twain")) {
            System.out.println(b.getName());
        }
    }
    public void addNovel(String name, String author, String text, String genre) {
        books.add(new Novel(name, author, text, genre));
    }
    public List<Book> findBooksByAuthor(String author) {
        ArrayList<Book> temp = new ArrayList<Book> ();
        // iterate through all books in our collection
        for (Book b : books) {
            // if a book's author is the same as our input, return that book
            if (b.getAuthor().equals(author))
                temp.add(b);
        }
        return temp;
    }
}