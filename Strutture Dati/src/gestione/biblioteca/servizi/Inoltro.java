package gestione.biblioteca.servizi;

/**
 * La classe generica inoltro si occupa di inoltrare la richiesta di un oggetto della
 * biblioteca, ad un particolare servizio.
 */
public class Inoltro<T> {
	
	private T daInoltrare;
	
	public Inoltro(T daInoltrare) {
		this.daInoltrare = daInoltrare;
	}
	
	public String stampaScheda() {
		return this.daInoltrare.toString() + " (messaggio inoltrato)";
	}

}
