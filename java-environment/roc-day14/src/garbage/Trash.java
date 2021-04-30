package garbage;

public class Trash {
	private int id;
	
	public Trash (int id) {
		this.id = id;
		System.out.println("New Trash Created, id: " + id);
	}
	
	public void finalize() throws Throwable {
		/*
		 * The '\t' below is used to tabulate our text out...
		 */
		System.out.println("\tTrash ID: " + id + " is heading to the dump!");
	}
}
