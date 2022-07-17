package examples.priority;

/*
 * La definizione della priorità per un thread, permette alla CPU
 * di definire con quale ordine questi devono essere eseguiti e quindi hanno
 * diritto ad accedere alle risorse. 
 */
public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		// Stessa priorità => stampa confusionaria 
		new ThreadPrioritario(5, "#1").start();
		new ThreadPrioritario(5, "#2").start();
		new ThreadPrioritario(5, "#3").start();

		Thread.sleep(5000);
		System.out.println("\nStampa con ordine\n");

		new ThreadPrioritario(Thread.MAX_PRIORITY, "#1").start();
		new ThreadPrioritario(Thread.NORM_PRIORITY, "#2").start();
		new ThreadPrioritario(Thread.MIN_PRIORITY, "#3").start();
	}

}
