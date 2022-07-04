package gestione.biblioteca.prestito;

import gestione.biblioteca.prestito.base.Opera;

public class Libro extends Opera{
	
	private short numeroPagine;
	
	public Libro(String titolo, short numeroPagine) {
		super(titolo);
		this.numeroPagine = numeroPagine;
	}
	
	public int getNumeroPagine() {
		return this.numeroPagine;
	}
}
