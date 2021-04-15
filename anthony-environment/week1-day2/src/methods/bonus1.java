package methods;

public class bonus1 {
    public static void main(String[] args) {
        Parrot molly = new Parrot("Molly");
        Parrot polly = new Parrot("Polly");
        molly.talk();
        polly.talk();
    }

    public static class Parrot {
        public String name;

        public Parrot(String s) {
            this.name = s;
        }

        public void talk() {
            String words = this.name + " wants a cracker!";
            System.out.println(words);
        }
    }
}
