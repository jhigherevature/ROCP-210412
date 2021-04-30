package threadbasics;

public class RunnableThread implements Runnable {

	@Override
	public void run() {
		System.out.println("I am a thread which implemented Runnable");
		
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
	}	
}
