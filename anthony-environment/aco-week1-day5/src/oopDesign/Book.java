package oopDesign;

public abstract class Book implements Readable {
    public String bookText;
    public String name;
    public String author;

    public void read() {
        System.out.println(bookText);
    }
}
