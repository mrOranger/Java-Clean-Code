
package gestione.biblioteca.prestito;

import gestione.biblioteca.prestito.base.Opera;

public class Biblioteca {
	
	public void effettuaPrestito(Studente studente, Opera daPrendere) {
		if(daPrendere.inPrestito()) {
			System.out.println("Volume già in prestito!");
			return;
		}else if(!studente.prestitiDisponibili()) {
			System.out.println("Errore! Numero di prestiti esauriti: " + daPrendere.getTitolo());
			return;
		}
		if(studente.creaPrestito(daPrendere)) {
			System.out.println("Prestito effettuato " + daPrendere.getTitolo());
			daPrendere.collocazioneInPrestito();
		}else {
			System.out.println("Prestito non effettuato!");
		}
	}
	
	public void restituisciOpera(Studente studente, Opera daRestituire) {
		if(studente.restituzionePrestito(daRestituire)) {
			System.out.println("Prestito concluso: " + daRestituire.getTitolo());
			daRestituire.restituzionePrestito();
		}else {
			System.out.println("Errore in restituzione");
		}
	}
}
