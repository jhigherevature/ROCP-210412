package oopDesign;

import java.util.*;

public class Bookshelf {
    public ArrayList<Book> library = new ArrayList<Book>();

    public Book[] findByName(String name) {
        Book[] amazonBox = new Book[1];
        for (Book b : library) {
            if (b.name.equals(name)) {
                amazonBox[0] = b;
                return amazonBox;
            }
        }
        System.out.println(name + " not found.");
        return amazonBox;
    }

    public Book[] findByAuthor(String author) {
        ArrayList<Book> amazonBox = new ArrayList<Book>();
        for (Book b : library) {
            if (b.author.equals(author)) {
                amazonBox.add(b);
            }
        }
        Book[] shipment = (Book[]) amazonBox.toArray();
        System.out.println("Found " + shipment.length + " books");
        return shipment;
    }
}
