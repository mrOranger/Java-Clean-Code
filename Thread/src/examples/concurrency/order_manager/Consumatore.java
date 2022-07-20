package examples.concurrency.order_manager;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumatore implements Runnable{
	
	private BlockingQueue<Ordine> queue;
	private GestoreOrdini gestore;
	private boolean continua;
	
	public Consumatore(BlockingQueue<Ordine> queue, GestoreOrdini ordini) {
		this.queue = queue;
		this.gestore = ordini;
		this.continua = true;
	}
	
	public void stop() {
		this.continua = false;
	}

	@Override
	public void run() {
		
		while(continua) {
			try {
				Ordine nuovoOrdine = this.queue.poll(3, TimeUnit.MILLISECONDS);
				if(nuovoOrdine == null) {
					continue;
				}
				this.gestore.aggiungiOrdine(nuovoOrdine);
				this.gestore.incrementaOrdine();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Consumatore interrotto!");
	}
}
