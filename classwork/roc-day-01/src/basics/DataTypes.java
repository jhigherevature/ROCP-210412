package basics;

public class DataTypes {
    public static void print(Object s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        byte b = 63;
        short s = 300;
        char c = 'p';
        int i = 128_000;
        long l = 256_000_000;
        float f = 512.1024f;
        double d = 1.2345678901234567890;
        boolean bool = true;
        print(b);
        print(s);
        print(c);
        print(i);
        print(l);
        print(f);
        print(d);
        print(bool);
    }
}
