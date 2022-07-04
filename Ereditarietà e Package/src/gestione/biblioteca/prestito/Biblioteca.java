package gestione.biblioteca.prestito;

import gestione.biblioteca.prestito.base.Opera;


public class Biblioteca {
	
	
	public void effettuaPrestito(Studente studente, Opera daPrendere) {
		if(daPrendere.isInPrestito()) {
			System.out.println("Il volume è già in prestito!");
			return;
		}
		if(!studente.prestitiDisponibili()) {
			System.out.println("Lo studente " + studente.getNome() + " " + studente.getCognome() +
					" ha esaurito il numero di prestiti!"
			);
			return;
		}
		if(studente.registraPrestito(daPrendere)) {
			daPrendere.registraPrestito();
			System.out.println("Effattuato prestito di " + daPrendere.getTitolo());
		}else {
			System.out.println("Prestito non registrato!");
		}
	}
	
	public void restituisciPrestito(Studente studente, Opera daRestituire) {
		if(studente.restituisciPrestito(daRestituire)) {
			daRestituire.restituzionePrestito();
			System.out.println(daRestituire.getTitolo() + " restituito correttamente!");
		}else {
			System.out.println("Errore in fase di restituzione!");
		}
	}
}
