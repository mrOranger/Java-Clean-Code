package examples.concurrency.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Se comunque Executor migliora il codice perchè evita che si instanzi un thread
 * e si invochi poi su questo il metodo run, non alleggerisce più di tanto
 * la creazione e l'esecuzione di un nuovo thread.
 * La classe ExecutorService che estende Executor ci permette di migliorare
 * la creazione e l'esecuzione.
 */
public class Main {
	
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new ThreadEseguibile("#1"));
		executorService.execute(new ThreadEseguibile("#2"));
		executorService.execute(new ThreadEseguibile("#3"));
		
		System.out.println("\n\n");
		
		executorService.execute(() -> {
			for(int i = 0; i < 5; i++) {
				System.out.println("Eseguo thread #1");
			}
		});
		
		executorService.execute(() -> {
			for(int i = 0; i < 5; i++) {
				System.out.println("Eseguo thread #2");
			}
		});
		
		executorService.execute(() -> {
			for(int i = 0; i < 5; i++) {
				System.out.println("Eseguo thread #3");
			}
		});

	}
}
