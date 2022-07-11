
package gestione.biblioteca.app;

import java.time.LocalDate;
import java.time.Month;

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

import gestione.biblioteca.prestito.Studente;
import gestione.biblioteca.prestito.Libro;
import gestione.biblioteca.prestito.Prestito;
import gestione.biblioteca.prestito.eccezioni.DataNonValidaException;
import gestione.biblioteca.prestito.eccezioni.NomeNonValidoException;

public class Main {
	public static void main(String[] args) {
		
		try {
			Studente studente = new Studente("Edoardo Martino", "Rossi", LocalDate.of(1992, Month.AUGUST, 5));
			Libro libro = new Libro("Manuale di Java", (byte)123);
			Prestito prestito = new Prestito(studente, libro);
			
			System.out.println(studente.toString());
			System.out.println("");
			System.out.println(prestito);			
		}catch(DataNonValidaException | NomeNonValidoException e) {
			System.out.println(e.getMessage());
		}
	}
}
