package day2;

public class Example1 {

	public static void main(String[] args) {
	
		int random = randomNumber();
		
		System.out.print(random);
	}
	
	public static int randomNumber() {
		int max = 50;
		int min = 1;
		
		int randomNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);
		
		return randomNumber;
	}
	

}
