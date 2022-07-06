package esempi.code;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import esempi.dati.ComparatorPersona;
import esempi.dati.Persona;

public class Main {
	
	/**
	 * Queue è l'interfaccia che permette la creazione di Code, che implementano una politica FIFO.
	 * Dall'intefaccia derivano una classe ed un'altra interfaccia:
	 * - PriorityQueue che definisce una coda con proprità.
	 * - Deque che definisce le code che si comportano anche come Pile, da questa derivano:
	 *   - LinkedList che implementa una lista con comportamento di Coda e Pila,
	 *     ma senza usare un'array, diversamente da ArrayList. Quindi più efficace,
	 *     se non per le operazioni di accesso che non usano l'indice.
	 *   - ArrayDeque che implementa una Coda insieme ad una Pila.
	 */
	
	public static void main(String[] args) {
		
		Queue<Persona> priorityQueue = new PriorityQueue<>();
		Deque<Persona> linkedList = new LinkedList<>();
		Deque<Persona> arrayDeque = new ArrayDeque<>();
		
		popolaCollection(priorityQueue);
		popolaCollection(linkedList);
		popolaCollection(arrayDeque);
		
		printCollection(priorityQueue);
		printCollection(linkedList);
		printCollectionGeneric(arrayDeque);
		
		priorityQueue = new PriorityQueue<>(new ComparatorPersona());
		popolaCollection(priorityQueue);
		printCollection(priorityQueue);
	}
	
	public static void popolaCollection(Collection<Persona> collection){
		collection.add(new Persona("Mario", "Rossi"));
		collection.add(new Persona("Giuseppe", "Verdi"));
		collection.add(new Persona("Lucia", "Bruni"));
	}
	
	public static void printCollection(Collection<?> collection) {
		System.out.println("Stampa di : " + collection.getClass().getName());
		Iterator<?> iterator = collection.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public static <T> void printCollectionGeneric(Collection<T> collection) {
		System.out.println("Stampa di : " + collection.getClass().getName());
		Iterator<T> iterator = collection.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
