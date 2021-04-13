package methods;

public class Parrot {
	
	String name;
	
	public static void main(String[] args) {
		
		Parrot p = new Parrot();
		p.name = "Polly";
		p.talk(p.name);
	}
	
	public void talk(String input) {
		
		System.out.println(input + " wants a cracker!");
		
	}

}
