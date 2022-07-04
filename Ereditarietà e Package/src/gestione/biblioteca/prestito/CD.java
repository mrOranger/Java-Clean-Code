package gestione.biblioteca.prestito;

import gestione.biblioteca.prestito.base.Opera;

public class CD extends Opera{
	
	private byte numeroTracce;
	
	public CD(String titolo, byte numeroTracce) {
		super(titolo);
		this.numeroTracce = numeroTracce;
	}

	public byte getNumeroTracce() {
		return numeroTracce;
	}

	public void setNumeroTracce(byte numeroTracce) {
		this.numeroTracce = numeroTracce;
	}
}
