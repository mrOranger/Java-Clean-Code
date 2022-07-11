package gestione.biblioteca.prestito;

import gestione.biblioteca.servizi.Inoltro;
import gestione.biblioteca.servizi.ServizioRiparazione;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import gestione.biblioteca.prestito.base.Opera;
import gestione.biblioteca.prestito.base.OperaPrestabile;
import gestione.biblioteca.prestito.eccezioni.PrestitoNonEseguibileException;

public class Biblioteca {
	
	private final ServizioRiparazione servizioRiparazione = new ServizioRiparazione();
	
	private List<Studente> registroStudenti = new ArrayList<>();
	private List<OperaPrestabile> catalogo = new ArrayList<>();
	private LinkedList<Prestito> storicoPresiti = new LinkedList<>();
	
	public static final byte MAX_PRESTITI = 4;
	public static final byte MAX_STORICO = 30;
	
	public Biblioteca() {
		this.inizializzaCatalogo();
	}
	
	public void inizializzaCatalogo() {
		Libro testo1 = new Libro("Matematica 1", (byte)59);
		Libro testo2 = new Libro("Elementi di Algebra", (byte)69);
		Libro testo3 = new Libro("Guida Java", (byte)59);
		Libro testo4 = new Libro("Guida C++", (byte)59);
		Libro testo5 = new Libro("Inglese per il lavoro", (byte)59);
		
		CD cd1 = new CD("Canzoni di natale", (byte)18);
		CD cd2 = new CD("Raccolta Jazz", (byte)16);
		CD cd3 = new CD("Il meglio del Soul", (byte)22);
		
		this.catalogo.add(testo1);
		this.catalogo.add(testo2);
		this.catalogo.add(testo3);
		this.catalogo.add(testo4);
		this.catalogo.add(testo5);
		
		this.catalogo.add(cd1);
		this.catalogo.add(cd2);
		this.catalogo.add(cd3);
	}
	
	public void registraStudente(String nome, String cognome) {
		Studente nuovoStudente = new Studente(nome, cognome);
		this.registroStudenti.add(nuovoStudente);
	}
	
	public void effettuaPrestito(int idStudente, int idOpera) {
		try {
			/* Cerchiamo le posizioni di Studente ed Opera */
			Studente studente = this.registroStudenti.get(idStudente);
			OperaPrestabile opera = this.catalogo.get(idOpera);
			
			/* Verifichiamo se il prestito è attuabile */
			if(opera.inPrestito()) {
				System.out.println("Opera già in prestito a " + studente.toString());
			}else {
				try {
					studente.registraPrestito(opera);
					opera.registraPrestito();
					System.out.println("Prestito effettuato a " + studente.toString() + " del volume " + opera.getTitolo());
				} catch (PrestitoNonEseguibileException e) {
					System.out.println(e.getMessage());
				}
			}	
		}catch(IndexOutOfBoundsException e) {
			/* L'eccezione è di tipo unchecked, 
			 * quindi dobbiamo richiedere noi la gestione esplicita 
			 */
			System.out.println("Dai non validi!");
		}
	}
	
	public void restituisciPrestito(int idStudente, int idOpera) {
		try {
			Studente studente = this.registroStudenti.get(idStudente);
			OperaPrestabile daRestituire = this.catalogo.get(idOpera);
			
			Prestito inRestituzione = studente.restituisciPrestito(daRestituire);
			
			if(inRestituzione != null) {
				/* Lo Studente non aveva in prestito quell'opera */
				System.out.println("Prestito concluso di " + daRestituire.getTitolo() + " da " + studente.toString());
				daRestituire.restituisciPrestito();
				this.registraStorico(inRestituzione);
			}else {
				System.out.println("Errore durante la restituzione!");
			}
		}catch(IndexOutOfBoundsException outOfBounds) {
			System.out.println("Dati non validi!");
		}
	}
	
	private void registraStorico(Prestito ultimo) {
		if(this.storicoPresiti.size() == MAX_STORICO) {
			this.storicoPresiti.removeLast();
		}
		this.storicoPresiti.addFirst(ultimo);
	}
	
	public void segnalazioneOperaDanneggiata(Opera danneggiata) {
		Inoltro<Opera> inoltro = new Inoltro<>(danneggiata);
		String ricevuta = this.servizioRiparazione.ricezioneInoltro(inoltro);
		System.out.println(ricevuta);
	}
	
	public void situazioneUtente(int idUtente) {
		Studente studente = this.registroStudenti.get(idUtente);
		System.out.println(studente.situazionePrestiti());
	}
}
