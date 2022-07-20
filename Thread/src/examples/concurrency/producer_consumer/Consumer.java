package examples.concurrency.producer_consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{
	
	private BlockingQueue<Integer> queue;
	
	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	/*
	 * Usiamo il metodo poll, per verificare se esiste un valore da estrarre
	 * e se questo non è presente entro 3 secondi allora si blocca il thread.
	 */
	@Override
	public void run() {
		while(true) {
			try {
				var valore = queue.poll(3, TimeUnit.SECONDS);
				if(valore == null) {
					System.out.println("Timeout, thread in distruzione");
					break;
				}
				System.out.println("Il consumatore n." + Thread.currentThread().getId() + " consuma " + valore);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
}
