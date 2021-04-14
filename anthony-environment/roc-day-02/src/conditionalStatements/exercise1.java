package conditionalStatements;

public class exercise1 {
    public static void boolPrinter(boolean b) {
        if (b) {
            System.out.println("argument was true");
        } else {
            System.out.println("argument was false");
        }
    }

    public static void main(String[] args) {
        boolPrinter(true); // argument was true
        boolPrinter(false); // argument was false
    }
}