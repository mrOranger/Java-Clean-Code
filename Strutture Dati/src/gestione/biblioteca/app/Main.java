
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
		
		biblioteca.registraStudente("Marco", "Rossi");
		biblioteca.registraStudente("Giuseppe", "Verdi");
		biblioteca.registraStudente("Anna", "Neri");
		
		biblioteca.effettuaPrestito(0, 1);
		biblioteca.effettuaPrestito(0, 2);
		
		biblioteca.effettuaPrestito(1, 1);
		biblioteca.effettuaPrestito(1, 5);
		
		biblioteca.restituisciPrestito(0, 2);
		biblioteca.restituisciPrestito(1, 5);
		
		biblioteca.situazioneUtente(0);
	}
}
