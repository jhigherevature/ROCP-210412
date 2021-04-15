package gatheringUserInput;

import java.util.*;

public class exercise1 {
    public static void main(String[] args) {
        Scanner textBot = new Scanner(System.in);
        System.out.print("Type something and hit ENTER so I can count the vowels: ");
        String input = textBot.nextLine();
        int vowelCount = 0;
        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
        for (int i = 0; i < input.length(); ++i) {
            for (char c : vowels) {
                if (c == input.charAt(i)) {
                    ++vowelCount;
                    break;
                }
            }
        }
        System.out.println("I counted " + vowelCount + " vowels in your input.");
        textBot.close();
    }
}
