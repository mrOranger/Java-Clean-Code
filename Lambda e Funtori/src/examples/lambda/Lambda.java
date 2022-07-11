package examples.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Tradizionalmente una funzione lambda è una funzione senza alcun nome,
 * a cui non ci si può riferire in alcun modo.
 * Su questo concetto da Java 8 vengono introdotte le espressioni lambda,
 * con lo scopo di ridurre il codice con concetti ed espressioni che possono essere
 * facilmente intuiti dal compilatore.
 * In termini tecnici, le espressioni lambda sostituiscono gli oggetti di classi anonime
 * basate su interfacce funzionali.
 */
public class Lambda {
	
	/*
	 * Il modo più classico per confrontare due stringhe usando un metodo 
	 * custom è quello di definire una classe che implementa l'interfaccia
	 * Comparator.
	 */
	private static class ComparatorStringhe implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return o1.length() - o2.length();
		}
	}
	
	public static void main(String[] args) {
		
		ComparatorStringhe comparatorStringheClassic = new ComparatorStringhe();
		/*
		 * Una valida alternativa consiste nell'usare una classe anonima
		 * se questa verrà utilizzata una sola volta.
		 */
		Comparator<String> comparatorStringhe = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		};
		
		/*
		 * Se la prima alternativa potrebbe essere uno spreco di memoria,
		 * la seconda è visibilamente brutta da vedere, la terza alternativa
		 * cosiste nell'usare le funzioni lambda.
		 */
		
		Comparator<String> lambdaComparator = (String o1, String o2) -> {
			return o1.length() - o2.length();
		};
		
		System.out.println(comparatorStringheClassic.compare("Michele", "Giovanni"));
		System.out.println(comparatorStringhe.compare("Michele", "Giovanni"));
		System.out.println(lambdaComparator.compare("Michele", "Giovanni"));
		
		List<String> nomi = new ArrayList<String>(Arrays.asList("Michelangelo", "Elisabetta", "Arturo"));
		Collections.sort(nomi, lambdaComparator);
		Stampa stampa = lista -> {
			for(String nome : lista) {
				System.out.println(nome);
			}
		};
		stampa.stampa(nomi);
	}

}
