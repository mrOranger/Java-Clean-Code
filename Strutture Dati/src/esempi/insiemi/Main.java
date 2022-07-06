package esempi.insiemi;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import esempi.dati.ComparatorPersona;
import esempi.dati.Persona;

public class Main {
	
	/**
	 * Diversamente dalle liste, l'interfaccia Set non permette l'inserimento di duplicati.
	 * Dall'intefaccia Set, sono generate due classi:
	 * - HashSet non tiene traccia dell'ordine di inserimento.
	 * - LinkedHashSet tiene traccia dell'ordine di inserimento.
	 */
	
	public static void main(String[] args) {
		
		Set<Persona> personeHash = new HashSet<>();
		Set<Persona> personeLinked = new LinkedHashSet<>();
		
		personeHash.add(new Persona("Mario", "Rossi"));
		personeHash.add(new Persona("Giuseppe", "Verdi"));
		personeHash.add(new Persona("Lucia", "Bruni"));
		
		printCollection(personeHash);
		
		personeLinked.add(new Persona("Mario", "Rossi"));
		personeLinked.add(new Persona("Giuseppe", "Verdi"));
		personeLinked.add(new Persona("Lucia", "Bruni"));
		
		printCollection(personeLinked);
		
		/**
		 * Dall'interfaccia Set è derivata l'interfaccia SortedSet,
		 * e da questa la classe TreeSet, che inserisce gli elementi in base ad un ordinamento,
		 * passato tramite il costrutture, che può essere standard oppure custom.
		 */
		
		Collection<Persona> treeSet = new TreeSet<>(new ComparatorPersona());
		treeSet.add(new Persona("Mario", "Rossini"));
		treeSet.add(new Persona("Giuseppe", "Verdi"));
		treeSet.add(new Persona("Lucia", "Gialli"));
		
		printCollection(treeSet);
		
		treeSet = new TreeSet<>();
		treeSet.add(new Persona("Mario", "Rossi"));
		treeSet.add(new Persona("Giuseppe", "Verdi"));
		treeSet.add(new Persona("Lucia", "Bruni"));
		
		printCollection(treeSet);
		
	}
	
	public static void printCollection(Collection<?> collection) {
		System.out.println("Stampa di : " + collection.getClass().getName());
		Iterator<?> iterator = collection.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
