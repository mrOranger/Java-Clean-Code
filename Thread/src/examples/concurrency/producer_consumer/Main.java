package examples.concurrency.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Un esempio di collaborazione tra threaad prende il nome di Produttore/Consumatore,
 * in cui si vede la presenza di più flussi di esecuione in cui vengono svolte
 * operazioni di lettura/scrittura di una serie di oggetti. 
 * La struttura dai ideale su cui si possono effettuare operazioni tramite thread
 * implementa l'intefaccia BlockingQueue.
 */
public class Main {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		executor.submit(new Producer(queue));
		executor.submit(new Consumer(queue));
		executor.submit(new Consumer(queue));
		
		executor.shutdown(); // Elimina i thread dormienti
	}
}
