package gestione.biblioteca.prestito.base;

import java.time.LocalDate;

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
	
	public abstract LocalDate scadenzaPrestito();
	
	@Override
	public String toString() {
		return "Titolo: " + this.getTitolo() + 
				(this.inPrestito() ? " attualmente in prestito" : " attualmente disponibile");
	}
}
