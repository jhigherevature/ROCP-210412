package ooppillars;

/*
 * Interfaces can extend other interfaces.
 * 
 * Interfaces CANNOT extend classes or implement
 * interfaces
 */
public interface Carnivorous extends Digestion {
	public default void digest() {
		System.out.println("This is how I digest");
	}
}
