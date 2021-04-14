package methods;

public class parrot {
    public String name;

    public parrot(String s) {
        name = s;
    }

    public void talk() {
        String words = name + " wants a cracker!";
        System.out.println(words);
    }
}