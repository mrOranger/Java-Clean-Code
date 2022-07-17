package examples.concurrency.executor;

import java.util.concurrent.Executor;

/*
 * Il nuovo package java.util.concurrent mette a disposizione tre diverse classi
 * per la gestione dei threads:
 * - Executor. Un semplice esecutore di un'interfaccia Runnable.
 * - ExecutorService. Estende Executor ed offre diversi overload per gestire
 *   anche classi oltre a Runnable.
 * - ScheduleExecutorService specializzato per la temporalizzazione dei thread.
 */
public class Main {
	
	public static void main(String[] args) {
		Executor executor = new EsecutoreThread();
		executor.execute(new ThreadEseguibile("#1"));
		executor.execute(new ThreadEseguibile("#2"));
		executor.execute(new ThreadEseguibile("#3"));
		
		System.out.println("\n\n");
		
		/*
		 * Siccome Runnable è un'intefaccia funzionale, 
		 * possiamo anche passarci una lambda-funzione,
		 * anche se ne risente la leggibilità del codice ...
		 */
		
		executor.execute(() -> {
			for(int i = 0; i < 5; i++) {
				System.out.println("Eseguo thread #1");
			}
		});
		
		executor.execute(() -> {
			for(int i = 0; i < 5; i++) {
				System.out.println("Eseguo thread #2");
			}
		});
		
		executor.execute(() -> {
			for(int i = 0; i < 5; i++) {
				System.out.println("Eseguo thread #3");
			}
		});
	}
}
