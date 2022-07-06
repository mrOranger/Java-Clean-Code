package esempi.liste;

import esempi.dati.ComparatorPersona;
import esempi.dati.Persona;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {
	
	/**
	 * La struttura dati più semplice ed intuitiva è la lista, 
	 * una serie di oggetti ai quali è possibile accedere e modificare i valori
	 * tramite l'uso degli indici.
	 * Java permette la creazione di liste tramite l'interfaccia List<T>,
	 * e dalla quale deriva la classe ArrayList, che implementa una lista
	 * basandosi sul funzionamento di un array.
	 */

	public static void main(String[] args) {
		
		List<Persona> persone = new ArrayList<>(); // Polimorfismo sui dai + diamond operator
		persone.add(new Persona("Mario", "Rossi"));
		persone.add(new Persona("Michele", "Bianchi"));
		persone.add(new Persona("Lucia", "Verdi"));
		
		/*
		 * E' possibile iterare gli elementi della lista in tre diversi modi:
		 * - Usando un ciclo for.
		 * - Usando un ciclo enhanced for.
		 * - Usando l'oggetto Iterator.
		 */
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < persone.size(); i++) {
			System.out.println(persone.get(i));
		}
		long finish = System.currentTimeMillis();
		System.out.println("Tempo totale per for: " + (finish - start));
		
		start = System.currentTimeMillis();
		for(Persona curr : persone) {
			System.out.println(curr);
		}
		finish = System.currentTimeMillis();
		System.out.println("Tempo totale per enhanced for: " + (finish - start));
		
		start = System.currentTimeMillis();
		Iterator<Persona> iterator = persone.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		finish = System.currentTimeMillis();
		System.out.println("Tempo totale per iterator: " + (finish - start));
		
		/* 
		 * Il confronto viene fanno sfruttando il metodo sort dell'interfaccia Collection,
		 * ed usando le due interfacce di Comparator o Comparable.
		 */
		System.out.println("Sort con Comparable");
		Collections.sort(persone);
		iterator = persone.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		finish = System.currentTimeMillis();
		System.out.println("Sort con Comparator");
		Collections.sort(persone, new ComparatorPersona());
		iterator = persone.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		finish = System.currentTimeMillis();
		
	}
	
}
