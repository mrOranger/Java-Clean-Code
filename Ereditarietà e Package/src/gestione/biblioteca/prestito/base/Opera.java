package gestione.biblioteca.prestito.base;

/**
 * La classe Opera definisce un'opera in maniera generale, 
 * definita quindi da un titolo e da un marcatore che indica se 
 * l'opera attuale è o no in prestito.
 */
public class Opera {
	
	protected String titolo;
	private boolean inPrestito; 
	
	public Opera(String titolo) {
		this.titolo = titolo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public boolean isInPrestito() {
		return inPrestito;
	}
	
	public void registraPrestito() {
		this.inPrestito = true;
	}
	
	public void restituzionePrestito() {
		this.inPrestito = false;
	}
	
	@Override
	public String toString() {
		return " titolo: " + this.getTitolo() + (this.isInPrestito() ? " Attualmente in prestito" : "Non in prestito");
	}
}
