package Methods;

public class Exercise1 {

	public static void main(String[] args) {
		
		Exercise1 random = new Exercise1();	
		
		random.randomNumber();

	}
	
	public int randomNumber() {
		
		int d = (int) (Math.random() * 50);
		
		System.out.println(d);
		return d;
	}

}
