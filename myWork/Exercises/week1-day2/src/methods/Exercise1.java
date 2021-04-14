package methods;

public class Exercise1 {
	
	public static void main(String[] args) {
		 System.out.println(randomNumber());
		}
	public static int randomNumber() {
		int generator = (int)(Math.random() * 51);
		return generator;
		}
	
	}