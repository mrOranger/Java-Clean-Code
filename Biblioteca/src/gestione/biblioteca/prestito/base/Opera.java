package gestione.biblioteca.prestito.base;

public class Opera {
	
	protected String titolo;
	protected boolean inPrestito;
	
	protected Opera(String titolo) {
		this.titolo = titolo;
	}
	
	public boolean inPrestito() {
		return this.inPrestito;
	}
	
	public void collocazioneInPrestito() {
		this.inPrestito = true;
	}
	
	public void restituzionePrestito() {
		this.inPrestito = false;
	}
	
	public String getTitolo() {
		return this.titolo;
	}
	
	@Override
	public String toString() {
		return this.titolo + (this.inPrestito ? " - Attualmente in prestito " : " - Disponibile");
	}
}
