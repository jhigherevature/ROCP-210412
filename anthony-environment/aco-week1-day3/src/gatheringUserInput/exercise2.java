package gatheringUserInput;

import java.util.*;

public class exercise2 {
    public static void main(String[] arg) {
        Scanner textBot = new Scanner(System.in);
        menu: while (true) {
            System.out.print("Let's move! (1) right, (2) left, (3) up, (4) down, (q) quit: ");
            String input = textBot.nextLine();
            switch (input) {
            case "1":
                System.out.println("Moving Right");
                break;
            case "2":
                System.out.println("Moving Left");
                break;
            case "3":
                System.out.println("Moving Up");
                break;
            case "4":
                System.out.println("Moving Down");
                break;
            case "q":
                break menu;
            default:
                System.out.println(
                        "Try again. Acceptable input: [1 - Move right, 2 - Move Left, 3 - Move Up, 4 - Move Down, q - exit program]");
                break;
            }
        }
        textBot.close();
    }
}
