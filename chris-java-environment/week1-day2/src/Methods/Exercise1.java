package Methods;

public class Exercise1 {

	public static void main(String[] args) {
		
		Exercise1 e = new Exercise1();
		
		System.out.println(e.randomNumber());

	}
	
	public int randomNumber() {
		
		int x = (int)(Math.random() * 49) + 1;
		
		return x;
	}

}
