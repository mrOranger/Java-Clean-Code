package examples.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * Per usare un'espressione lambda, è quindi necessaria un'interfaccia funzionale
 * ossia un'interfaccia che possiede una sola funzione implementabile.
 * Per sollevare il programmatore dall'onere di definire sempre questo tipo di interfacce,
 * e migliorare la JDK, nel package java.util.function è disponibile un insieme di interfacce:
 * - Consumer<T> -> void accept(T): definisce la trasformazione di un oggetto T.
 * - Function<T, R> -> R apply(T), astrae il concetto di funzione.
 * - Predicate<T> -> boolean test(T) effettua un test sull'oggetto T.
 * - Supplier<T> -> T get() restituisce un oggetto T.
 */

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Functions {
	
	public static void main(String[] args) {
		/*
		 * Potremmo definire una funzione che data una stringa, 
		 * non fa altro che modificarla e stampara il maiuscolo.
		 * L'interfaccia contiene anche un altro metodo chiamato andThen, che applica 
		 * una seconda funzione dopo aver applicato quella di accept.
		 */
		Consumer<String> stampaInMaiuscolo = (s) -> System.out.println(s.toUpperCase());
		Consumer<String> stampaInMinuscolo = (s) -> System.out.println(s.toLowerCase());
		Consumer<Float> stampaMedia = (m) -> System.out.println("La media è: " + m);

		stampaInMaiuscolo.
			andThen(stampaInMinuscolo).
			andThen(stampaInMaiuscolo).
			andThen(stampaInMinuscolo).
			accept("ciao");
		
		/* Non stampa nulla, perchè manca il metodo accept! */
		stampaInMaiuscolo.
			andThen(stampaInMinuscolo).
			andThen(stampaInMinuscolo);
		
		/*
		 * L'interfaccia Function astrae proprio il concetto di funzione, 
		 * richiedendo quindi un parametro di input ed uno di output. 
		 */
		Function<List<Integer>, Float> calcolaMedia = l -> {
			Iterator<Integer> iterator = l.iterator();
			float totale = 0;
			while(iterator.hasNext()) {
				totale += iterator.next();
			}
			return totale/l.size();
		};
		
		Function<List<Integer>, List<Integer>> eliminaEstremi = l -> {
			l.remove(0);
			l.remove(l.size() - 1);
			return l;
		};
		
		/*
		 * Possiamo comporre le funzioni in due modi, usando il metodo andThen,
		 * che quindi applica una funzione al risultato di apply. Oppure usare
		 * la composizione compose, che compone due funzioni, in maniera simile 
		 * a quanto avviene in matematica.
		 */
		List<Integer> elementi = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		stampaMedia.accept(calcolaMedia.compose(eliminaEstremi).apply(elementi));
		
		/*
		 * Un predicato è effettivamente qualcosa che predica qualcos'altro,
		 * quindi ne valuta il contenuto e restituisce un valore booleano.
		 */
		Predicate<List<Integer>> testLunghezza = l -> {
			return l.size() < 10;
		};
		
		System.out.println(testLunghezza.test(elementi));
		
		/*
		 * L'interfaccia Supplier permette invece di generare un elemento,
		 * tramite l'uso della funzione get, 
		 * che viene specificato come parametro all'interfaccia stessa.
		 */
		Supplier<List<Integer>> getLista = () -> {
			return new LinkedList<Integer>(Arrays.asList(9, 10, 11, 12));
		};
		
		System.out.println(getLista.get());
		
		/*
		 * Se le espressioni lambda hanno modificato il modo di scrivere
		 * del codice, hanno il limite di essere specifiche per il compito che 
		 * svolgono. Per questo motivo è stato introdotto l'operatore ::
		 * che passa una generica funzione per riferimento ad un'espressione lambda.
		 * In questa maniera, possiamo definire un'espressione lambda, e passarci
		 * in base alle necessità, la funzione da stampare.
		 */
		
		/* Possiamo usare un'espressione lambda, per creare una funzione che arrotondi
		 * un valore da double a float. */
		Function<Double, Long> arrotonda = d -> Math.round(d);
		
		/* ... però il compilatore può anche capire da solo che deve essere applicato
		 * ad una funzione. */
		Function<Double, Long> arrotondaNew = Math::round;
		
		System.out.println(arrotonda.apply(0.91));
		System.out.println(arrotondaNew.apply(0.91));
	}

}
