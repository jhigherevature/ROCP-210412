package oopDesign;

import java.io.*;
import java.util.*;

public class ToyStoreMain implements Serializable {
    private static final long serialVersionUID = 1l;

    public static void main(String[] args) {
        ToyStore kbtoys = new ToyStore();

        ArrayList<String> employees = new ArrayList<String>();
        employees.add("Wilbur");
        kbtoys.setEmployees(employees);

        ToyConsole nintendoSwitch = new ToyConsole();
        nintendoSwitch.setName("Nintendo Switch");
        nintendoSwitch.setNumber(5);
        nintendoSwitch.setPrice(299.99f);
        nintendoSwitch.setManufacturer("Nintendo");

        ToyYoyo duncan = new ToyYoyo();
        duncan.setName("Duncan");
        duncan.setNumber(30);
        duncan.setPrice(4.99f);
        duncan.setMaterial("Synthetic");

        Toy3x3Cube moyuAolong = new Toy3x3Cube();
        moyuAolong.setName("MoYu Aolong v2");
        moyuAolong.setNumber(12);
        moyuAolong.setPrice(9.99f);
        moyuAolong.setManufacturer(false);

        ArrayList<Toy> toys = new ArrayList<Toy>();
        toys.add(nintendoSwitch);
        toys.add(duncan);
        toys.add(moyuAolong);

        ToyStoreShelf shelf = new ToyStoreShelf();
        shelf.setShelf(toys);
    }
}
