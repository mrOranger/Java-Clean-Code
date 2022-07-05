
package gestione.biblioteca.app;

/**
 * Si vuole creare un gestionale per una biblioteca scolastica, 
 * in cui un utente può prendere in prestito al massimo due opere che possono cosistere in
 * CD o libri.
 * 
 * Si gestisce tutto tramite tre package:
 * - gestione.biblioteca.prestito.base contiene una sola classe "Opera", che è la classe
 *   base per ogni tipologia di oggetto che viene concesso in prestito.
 * - gestione.biblioteca.prestito contiene la classe Studente, e le classi Libro, CD e Biblioteca
 *   che ingloberà la logica del servizio di prestito.
 * - gestione.biblioteca.app che include la classe contenente il main in cui verranno provate
 *   le funzionalità.
 */

import gestione.biblioteca.prestito.Biblioteca;
import gestione.biblioteca.prestito.Studente;
import gestione.biblioteca.prestito.Libro;
import gestione.biblioteca.prestito.CD;

import gestione.biblioteca.prestito.base.OperaPrestabile;

public class Main {
	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		
		Studente pippo = new Studente("Pippo", "Disney");
		Studente pluto = new Studente("Pluto", "Diseny");
		
		OperaPrestabile libro1 = new Libro("Analisi 1", (byte)100);
		OperaPrestabile libro2 = new Libro("Programmazione 1", (byte)100);
		OperaPrestabile libro3 = new Libro("Fisica 2", (byte)200);
		OperaPrestabile cd = new CD("Canzoni di natale", (byte)12);
		
		System.out.println("*** Pluto prende in prestito due libri ***");
		biblioteca.effettuaPrestito(pluto, libro1);
		biblioteca.effettuaPrestito(pluto, libro2);
		
		System.out.println("*** Pluto genera l'eccezione ***");
		biblioteca.effettuaPrestito(pluto, libro3);
		
		System.out.println("*** Pippo prende in prestito un CD ***");
		biblioteca.effettuaPrestito(pippo, cd);
		
		System.out.println("*** Pippo prende in prestito un libro già occupato ***");
		biblioteca.effettuaPrestito(pippo, libro1);
		
		System.out.println("*** Pluto restituisce un libro");
		biblioteca.restituisciPrestito(pluto, libro1);
		
		System.out.println("*** Pippo prende in prestito un libro libero ***");
		biblioteca.effettuaPrestito(pippo, libro1);
		
		System.out.println(pippo);
		System.out.println(pluto);
	}
}
