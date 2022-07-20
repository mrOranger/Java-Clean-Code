package examples.concurrency.producer_consumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	
	private BlockingQueue<Integer> queue;
	
	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			for(int i = 0; i < 5; i++) {
				int valore = (int) (Math.random()*1000);
				queue.put(valore);
				System.out.println("Thread n." + Thread.currentThread().getId() + " produce " + valore);				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
}
