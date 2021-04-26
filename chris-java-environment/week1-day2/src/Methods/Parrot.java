package Methods;

public class Parrot {
	
	String name;

	public static void main(String[] args) {
		
		Parrot polly = new Parrot();
		polly.name = "Polly";
		polly.talk(polly.name);
		

	}
	
	public void talk(String input) {
		
		System.out.println(input + " wants a cracker!");
		
	}

}
