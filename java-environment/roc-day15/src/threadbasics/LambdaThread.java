package threadbasics;

public class LambdaThread {
	public static void main(String[] args) {
		System.out.println("Main method in 'LambdaThread' class");
		
		Runnable r = () -> {
			System.out.println("I am a thread created with Lambdas!");
			
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + " is running");
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
					
					/*
					 *  If the thread is interrupted, we want this loop
					 *  to stop, so that we do not potentially cause a
					 *  stop in our system 
					 */
					break;
				}
			}
			
			System.out.println(Thread.currentThread().getName() + " has finished");
		};
		
	}
}
