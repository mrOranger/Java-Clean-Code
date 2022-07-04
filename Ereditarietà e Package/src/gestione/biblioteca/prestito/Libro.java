package gestione.biblioteca.prestito;

import gestione.biblioteca.prestito.base.Opera;

public class Libro extends Opera{
	
	private byte numeroPagine;
	
	public Libro(String titolo, byte numeroPagine) {
		super(titolo);
		this.numeroPagine = numeroPagine;
	}

	public byte getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(byte numeroPagine) {
		this.numeroPagine = numeroPagine;
	}
}
