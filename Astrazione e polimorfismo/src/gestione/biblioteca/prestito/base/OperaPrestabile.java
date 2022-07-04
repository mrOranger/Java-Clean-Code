package gestione.biblioteca.prestito.base;

public abstract class OperaPrestabile extends Opera implements Prestabile{
	
	private boolean inPrestito;
	
	public OperaPrestabile(String titolo) {
		super(titolo);
	}

	@Override
	public boolean inPrestito() {
		return this.inPrestito;
	}

	@Override
	public void registraPrestito() {
		this.inPrestito = true;
	}

	@Override
	public void restituisciPrestito() {
		this.inPrestito = false;
	}
	
	public String getTitolo() {
		return this.titolo;
	}
	
	public abstract String produciScheda();
	
	@Override
	public String toString() {
		return "Titolo: " + this.getTitolo() + 
				(this.inPrestito() ? " attualmente in prestito" : " attualmente disponibile");
	}
}
