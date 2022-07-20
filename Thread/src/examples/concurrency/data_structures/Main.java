package examples.concurrency.data_structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Tutte le strutture dati definite in java.util non sono thread-safe,
 * In alternativa è possibile usare una serie di strutture dati thread-safe
 * create grazie a dei metodi disponibili nel package java.util.
 */
public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		/* 
		 * Usando la classica ArrayList, noteremo come l'accesso ai metodi 
		 * è disordinato, senza alcun ordine.
		 */
		List<Integer> lista = new ArrayList<>();
		lista.addAll(List.of(1, 2, 3, 4, 5));
		
		new Thread(new Thread1(lista)).start();
		new Thread(new Thread2(lista)).start();
		
		Thread.sleep(5000);
		System.out.println("\n Accesso con struttura thread safe \n");
		/*
		 * Se invece usiamo i metodi offerti da Collections,
		 * per creare una struttura dati thread-safe, noteremo
		 * come i metodi accedono uno alla volta alla struttura dati
		 */
		
		lista = Collections.synchronizedList(List.of(1, 2, 3, 4, 5));
		
		new Thread(new Thread1(lista)).start();
		new Thread(new Thread2(lista)).start();
	}
	
}
