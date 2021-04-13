package methods; 

public class Excercise1 {

	public static void main(String[] args) {
		
		Excercise1 e = new Excercise1();
		
		System.out.println(e.randomNumber());
		
	}
	
	public int randomNumber() {
		
		int x = (int)(Math.random() * 49) + 1;
		
		return x;
		
	}

}
