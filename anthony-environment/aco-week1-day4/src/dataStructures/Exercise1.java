package dataStructures;

import java.util.ArrayList;

public class Exercise1 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Jaque");
        names.add("Alex");
        names.add("Carrie");
        names.add("Ignacio");
        names.add("Byron");
        names.add("Gordon");
        names.add("Hazel");
        names.add("Max");
        names.add("Stephanie");
        names.add("Dev");
        names.add("Eric");
        names.add("Faith");

        for (String name : names) {
            System.out.println(name);
        }
    }
}
