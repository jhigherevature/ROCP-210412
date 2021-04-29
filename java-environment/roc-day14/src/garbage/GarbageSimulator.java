package garbage;

public class GarbageSimulator {
/*
 * We will use the following loop to create a lot of Trash objects.
 * These objects will have an overridden finalize method (the finalize
 * method is inherited from the Object class) which will print a
 * message to our console. This will give us some insight when an object
 * is collected by the garbage collector.
 */
	public static void main(String[] args) {
		for (int i = 0; i < 1_000_000; i++) {
			Trash t = new Trash(i);
			System.gc();
		}
	}
}
