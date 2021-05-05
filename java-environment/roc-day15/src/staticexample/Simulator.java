package staticexample;

public class Simulator {
	
	double word;
	
	public static void main(String[] args) {
		
		Data.singletonData.word = "Revature";
		Data.word = "Revature";
		
		System.out.println(Data.singletonData.word);
		
		Simulator sim = new Simulator();
		sim.word = 99.9;
		
		DataChild.word = "Hello";
	}
}
