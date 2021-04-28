package functionalinterfaces;

/*
 * Functional interfaces are ones which only define
 * a single method
 */
@FunctionalInterface
public interface HelloWorldInterface {
	public abstract void printHello();

	/*
	 *  if we include a second method, this ceases to be
	 *  a functional interface
	 */
//	public void otherMethod(); 
}
