package ooppillars;

public interface Flyable {
	public default void fly() {
		System.out.println("soaring like a bird!");
	}
	
}
