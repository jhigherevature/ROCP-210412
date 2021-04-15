package methods;

public class Parrot {
	
	String name = "Polly";
	
	public void Talk()
	{
		System.out.println(name + " wants a cracker!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Parrot Polly = new Parrot();
		Polly.Talk();
	}
}