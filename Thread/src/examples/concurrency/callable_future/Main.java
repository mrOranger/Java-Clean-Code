package examples.concurrency.callable_future;

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
	}

}
