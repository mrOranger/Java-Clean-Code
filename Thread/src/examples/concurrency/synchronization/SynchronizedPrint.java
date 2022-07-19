package examples.concurrency.synchronization;

public class SynchronizedPrint implements Runnable{
	
	private int printNumber;
	
	public SynchronizedPrint(int printNumber) {
		this.printNumber = printNumber;
	}

	@Override
	public synchronized void run() {
		System.out.println("Entra il Thread " + Thread.currentThread().getId());
		System.out.println("Stampa: " + this.printNumber++);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Esce il Thread " + Thread.currentThread().getId());
	}
}
