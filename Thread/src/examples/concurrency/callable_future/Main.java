package examples.concurrency.callable_future;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Uno dei difetti maggiori dell'uso dei Thread è l'impossibilità della funzione
 * run() di restituire un risultato. Le interfacce Callable e Future
 * vanno a colmare questo difetto passando tramite la funzione submit() 
 * di ExecutorService un'implementazione di Callable, che restituirà una classe
 * Future, sulla quale sarà possibile applicare il metodo get().
 */
public class Main {
	
	public static void main(String[] args) {
		ExecutorService newThread = Executors.newSingleThreadExecutor();
		Future<Data> data = newThread.submit(new LeggiFile());
		try {
			System.out.println(data.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		/*
		 * Siccome callable è un'interfaccia funzionale
		 * possiamo anche passare una classe anonima, che rende tutto molto
		 * simile a quanto accade per i Listerner in Android.
		 */
		newThread = Executors.newSingleThreadExecutor();
		Future<String> newData = newThread.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				var città = 0;
				var totale = 0;
				BufferedReader input = new BufferedReader(new FileReader(new File("data.dat")));
				String line;
				while((line = input.readLine()) != null) {
					città++;
					int tot = Integer.parseInt(line.split(":")[1]);
					totale += tot;
				}
				input.close();
				return "Citta: " + città + " - Totale: " + totale;
			}
		});
		
		try {
			System.out.println(newData.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
