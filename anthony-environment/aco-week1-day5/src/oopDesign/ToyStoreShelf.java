package oopDesign;

import java.io.*;
import java.util.*;

public class ToyStoreShelf implements Serializable {
    private static final long serialVersionUID = 1l;
    private ArrayList<Toy> shelf = new ArrayList<Toy>();

    public ArrayList<Toy> getShelf() {
        return shelf;
    }

    public void setShelf(ArrayList<Toy> shelf) {
        this.shelf = shelf;
    }
}
