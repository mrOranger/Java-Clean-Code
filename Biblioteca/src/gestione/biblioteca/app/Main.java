package gestione.biblioteca.app;

import gestione.biblioteca.prestito.Biblioteca;
import gestione.biblioteca.prestito.CD;
import gestione.biblioteca.prestito.Libro;
import gestione.biblioteca.prestito.Studente;

public class Main {
	public static void main(String[] args) {
		
		Biblioteca biblioteca = new Biblioteca();
		
		Studente studente1 = new Studente("Edoardo", "Oranger", "727331");
		Studente studente2 = new Studente("Elena", "Celesti", "656601");
		
		Libro testo1 = new Libro("Elettronica 1", (short)594);
		Libro testo2 = new Libro("Matematica 1", (short)387);
		
		CD cd = new CD("Canzoni di natale", (byte)18);
		
		System.out.println("\n *** Studente1 prende un libro ed un CD *** \n");
		biblioteca.effettuaPrestito(studente1, testo1);
		biblioteca.effettuaPrestito(studente1, cd);
		
		System.out.println("\n *** Studente1 tenta di prendere un nuovo libro in prestito *** \n");
		biblioteca.effettuaPrestito(studente1, testo2);
		
		System.out.println("\n *** Studente2 tenta di prendere un libro già in prestito *** \n");
		biblioteca.effettuaPrestito(studente2, testo1);
		
		System.out.println("\n *** Studente1 restituisce un libro *** \n");
		biblioteca.restituisciOpera(studente1, testo1);
		
		System.out.println("\n *** Studente2 prende in prestito un libro *** \n");
		biblioteca.effettuaPrestito(studente2, testo1);
		
		System.out.println("\n *** Situzione finale *** \n");
		System.out.println(studente1);
		System.out.println(studente2);
	}
}
