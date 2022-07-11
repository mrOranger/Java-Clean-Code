package gestione.biblioteca.prestito;

import java.time.LocalDate;

import gestione.biblioteca.prestito.base.OperaPrestabile;

public class CD extends OperaPrestabile{
	
	private byte numeroTracce;
	public static final byte MAX_SETTIMANE = 5;
	
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

	@Override
	public String produciScheda() {
		return "Il CD " + this.getTitolo() + " (" + this.numeroTracce + " tracce) è concesso in prestito per " + 
					MAX_SETTIMANE + " settimane";
	}

	@Override
	public LocalDate scadenzaPrestito() {
		return LocalDate.now().plusWeeks(MAX_SETTIMANE);
	}	
}
