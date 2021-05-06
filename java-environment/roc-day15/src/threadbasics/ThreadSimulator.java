package threadbasics;

public class ThreadSimulator {
	public static void main(String[] args) {
		System.out.println("\t\tThis is the Start of the main method");
		/*
		 * We will use the overloaded version of the Thread method
		 * to create our thread. This is so that we can apply a name
		 * to our thread...
		 * 
		 * The overloaded version below takes a thread object, and a
		 * String argument for the name.
		 */
		Thread runThread = new Thread(new RunnableThread(), "RunThread");
		runThread.start();
		
		/*
		 * You can invoke the join method on a thread in order to have another
		 * wait for its operations to complete. The join method is not as
		 * intuitive as you may initially think. We call the join method
		 * on the Thread Object that we want to finish operations on. And
		 * this is invoked inside of the thread that we want to wait for
		 * those operations to conclude...
		 * 
		 * In this case, the main method is waiting on the runThread object
		 * to complete operations before it continues with it's work.
		 */
		try {
			runThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\t\tThis is the End of the main method");
	}
}
