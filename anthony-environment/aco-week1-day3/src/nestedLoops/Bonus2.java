package nestedLoops;

public class Bonus2 {
    public static void main(String[] args) {
        String[] firstNames = { "Adam", "Alexis", "Dennis", "Jose", "Jessica", "Meghan", "Memphis", "Nicky", "Sarah",
                "William" };
        String[] lastNames = { "Adamson", "Bond", "Brown", "Johnson", "Gallagher", "Smith", "Thompson", "Perez", "Snow",
                "Tran" };

        for (String firstName : firstNames) {
            for (String lastName : lastNames) {
                System.out.println(firstName + " " + lastName);
            }
        }
    }
}
