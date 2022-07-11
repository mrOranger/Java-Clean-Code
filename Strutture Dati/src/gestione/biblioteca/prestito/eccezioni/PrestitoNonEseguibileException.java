package gestione.biblioteca.prestito.eccezioni;

import gestione.biblioteca.prestito.base.OperaPrestabile;

/**
 * La classe serve a gestire l'errore che si verifica quando un prestito non è disponibile.
 * Essendo un'estensione di Exception, la gestione è checked, diversamente da
 * RuntimeException che è unchecked.
 * L'eccezione viene sollevata in due situzioni:
 * - L'opera è già in prestito da un altro utente.
 * - L'utente corrente ha già in prestito due opere.
 */
public class PrestitoNonEseguibileException extends Exception{
	
	private OperaPrestabile opera;
	
	public PrestitoNonEseguibileException(OperaPrestabile opera) {
		this.opera = opera;
	}
	
	@Override
	public String getMessage() {
		return "Eccezioni sollevata: fallito il prestito dell'opera " + this.opera.getTitolo();
	}
}
