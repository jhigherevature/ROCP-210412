package oopDesign;

import java.io.*;
import java.util.*;

public class ToyStore implements Serializable {
    private ArrayList<String> employees;
    private ArrayList<ToyStoreShelf> shelves;

    public ArrayList<String> getEmployees() {
        return employees;
    }

    public ArrayList<ToyStoreShelf> getShelves() {
        return shelves;
    }

    public void setEmployees(ArrayList<String> employees) {
        this.employees = employees;
    }

    public void setShelves(ArrayList<ToyStoreShelf> shelves) {
        this.shelves = shelves;
    }

    private static final long serialVersionUID = 1l;
}
