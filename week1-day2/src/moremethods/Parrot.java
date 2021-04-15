package moremethods;

public class Parrot {

	public static void main(String[] args) {
		String name = "Parrot";
	
		Talk bird = new Talk();
		bird.birdtalk = "wants a cracker!";
		System.out.println(name + " " + bird.birdtalk);
	
	}
}
