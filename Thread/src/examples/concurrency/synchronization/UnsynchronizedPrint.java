package examples.concurrency.synchronization;

public class UnsynchronizedPrint implements Runnable{
	
	private int printNumber;
	
	public UnsynchronizedPrint(int printNumber) {
		this.printNumber = printNumber;
	}

	@Override
	public void run() {
		System.out.println("Entra il Thread " + Thread.currentThread().getId());
		System.out.println("Stampa: " + printNumber++);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Esce il Thread " + Thread.currentThread().getId());
	}
}
