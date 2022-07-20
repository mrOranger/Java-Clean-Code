package examples.concurrency.order_manager;

import java.util.concurrent.BlockingQueue;

public class Produttore implements Runnable{
	
	private BlockingQueue<Ordine> queue;
	private String[] venditori;
	
	public Produttore(BlockingQueue<Ordine> queue) {
		this.queue = queue;
		this.venditori = new String[]{"RM010", "RM101", "EM122", "OP190"};
	}
	
	private Ordine generaOrdine() {
		int posizioneVenditore = (int) (Math.random()*this.venditori.length - 1);
		float importoOrdine = (float) (Math.random()*3000+500);
		return new Ordine(venditori[posizioneVenditore], importoOrdine);
	}

	@Override
	public void run() {
		this.queue.offer(this.generaOrdine());
	}
}
