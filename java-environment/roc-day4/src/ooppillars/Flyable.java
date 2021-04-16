package ooppillars;

public interface Flyable {
	public default void fly() {
		System.out.println("Soaring like a bird!");
	}
	
	public void soar();
}
