package ooppillars;

public class Shark extends Animals implements Carnivorous {

	public void maim() {
		System.out.println("Ouch");
	}

	@Override
	public void eat(String food) {
		System.out.println("Sharks Eat Fish");
	}
}
