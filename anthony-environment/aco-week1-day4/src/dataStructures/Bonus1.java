package dataStructures;

import java.util.*;

public class Bonus1 {
    public static void main(String[] args) {
        TreeMap<String, String> dict = new TreeMap<String, String>();
        dict.put("apple", "A forbidden fruit");
        dict.put("banana", "A yellow fruit that can be peeled");
        dict.put("cantaloupe", "A melon fruit that has an orange flesh");

        Scanner input = new Scanner(System.in);
        loop: while (true) {
            System.out.println("Welcome to the dictionary.");
            System.out.println("(c) to check, (r) to read, (a) to add, (d) to delete, (q) to quit");
            System.out.print("What would you like? ");
            String menu = input.nextLine();
            switch (menu) {
            case "q":
                break loop;
            case "c":
                System.out.println("These words are currently in the dictionary:");
                System.out.println(String.join(", ", dict.keySet()));
                break;
            case "r":
                System.out.print("What word would you like to read? ");
                String check = input.nextLine();
                if (dict.containsKey(check)) {
                    System.out.println(check + ": " + dict.get(check));
                } else {
                    System.out.println("Word not found in the dictionary.");
                }
                break;
            case "a":
                System.out.print("Input new word: ");
                String word = input.nextLine();
                System.out.print("Input definition: ");
                String def = input.nextLine();
                dict.put(word, def);
                System.out.println(word + " was added to the dictionary.");
                break;
            case "d":
                System.out.print("What word should be deleted? (q) to quit: ");
                String del = input.nextLine();
                if (del.equals("q")) {
                    break;
                } else if (dict.containsKey(del)) {
                    dict.remove(del);
                    System.out.println(del + " was removed from the dictionary.");
                } else {
                    System.out.println(del + " was not found.");
                }
                break;
            default:
                System.out.println("That wasn't a valid option.");
                break;
            }
        }
        input.close();
    }
}