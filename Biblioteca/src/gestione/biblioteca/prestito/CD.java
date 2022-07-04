package gestione.biblioteca.prestito;

import gestione.biblioteca.prestito.base.Opera;

public class CD extends Opera{
	
	private byte numeroTracce;
	
	public CD(String titolo, byte numeroTracce) {
		super(titolo);
		this.numeroTracce = numeroTracce;
	}
	
	public int getNumeroTracce() {
		return this.numeroTracce;
	}
}
