package examples.concurrency.order_manager;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		
		GestoreOrdini gestore = new GestoreOrdini();
		BlockingQueue<Ordine> ordini = new LinkedBlockingQueue<>();
		
		ScheduledExecutorService produttore = Executors.newSingleThreadScheduledExecutor();
		produttore.scheduleAtFixedRate(new Produttore(ordini), 0, 10, TimeUnit.SECONDS);
		
		ExecutorService pool = Executors.newFixedThreadPool(4);
		
		Consumatore consumatore1 = new Consumatore(ordini, gestore);
		Consumatore consumatore2 = new Consumatore(ordini, gestore);
		
		pool.submit(consumatore1);
		pool.submit(consumatore2);
		
		Scanner input = new Scanner(System.in);
		String comando = null;
		System.out.print(">>>   ");
		while(input.hasNext()) {
			comando = input.nextLine();
			switch(comando) {
				case "mappa":
					gestore.stampaOrdini();
					pool.shutdown();
					break;
				case "elaborati":
					System.out.println("Ordini elaborati: " + gestore.ordiniElaborati());
					System.out.println();
					break;
				case "fine":
					System.exit(0);
					break;
				default:
					System.err.println("Comando non valido!");
					break;					
			}
			System.out.print(">>>   ");
		}
		input.close();
	}
}
