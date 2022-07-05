package gestione.biblioteca.prestito;

import gestione.biblioteca.prestito.base.OperaPrestabile;
import gestione.biblioteca.prestito.eccezioni.PrestitoNonEseguibileException;

public class Biblioteca {
	
	
	public void effettuaPrestito(Studente studente, OperaPrestabile daPrendere) {
		if(daPrendere.inPrestito()) {
			System.out.println("Il volume è già in prestito!");
			return;
		}
		try {
			studente.registraPrestito(daPrendere);
			daPrendere.registraPrestito();
			System.out.println("Effettuato prestito di " + daPrendere.getTitolo());
		} catch (PrestitoNonEseguibileException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void restituisciPrestito(Studente studente, OperaPrestabile daRestituire) {
		if(studente.restituisciPrestito(daRestituire)) {
			daRestituire.restituisciPrestito();
			System.out.println(daRestituire.getTitolo() + " restituito correttamente!");
		}else {
			System.out.println("Errore in fase di restituzione!");
		}
	}
}
