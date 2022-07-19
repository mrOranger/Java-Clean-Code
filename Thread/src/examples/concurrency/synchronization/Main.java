package examples.concurrency.synchronization;

/*
 * Usando il modificatore di accesso synchronized si permette ad un metodo
 * di attuare la "mutua esclusione", quindi di permettere l'accesso al metodo
 * da parte di un Thread, se e soltanto se non ci sono altri Thread che stanno
 * accedendo alle stesse risorse.
 */
public class Main {
	
	private static int number = 0;
	
	public static void main(String[] args) throws InterruptedException {
		/*
		 * Senza il modificatore synchronized la stampa sarà confusionaria.
		 */
		new Thread(new UnsynchronizedPrint(number)).start();
		number++;
		new Thread(new UnsynchronizedPrint(number)).start();
		number++;
		new Thread(new UnsynchronizedPrint(number)).start();
		
		System.out.println("\n");
		Thread.sleep(2000);
		/* 
		 * Usando il modificare sunchronized la stampa sarà ordinata
		 */
		number++;
		new Thread(new SynchronizedPrint(number)).start();
		number++;
		new Thread(new SynchronizedPrint(number)).start();
		number++;
		new Thread(new SynchronizedPrint(number)).start();
	}
}
