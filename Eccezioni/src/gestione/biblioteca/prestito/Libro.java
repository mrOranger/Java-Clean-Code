package gestione.biblioteca.prestito;

import gestione.biblioteca.prestito.base.OperaPrestabile;

public class Libro extends OperaPrestabile{
	
	private short numeroPagine;
	
	public static final byte MAX_SETTIMANE = 4;
	
	public Libro(String titolo, short numeroPagine) {
		super(titolo);
		this.numeroPagine = numeroPagine;
	}
	
	public short getNumeroPagine() {
		return this.numeroPagine;
	}
	
	@Override
	public String produciScheda() {
		return "Il libro " + this.getTitolo() + "(" + this.numeroPagine + " pagine in totale) " +
				"è concesso in prestito per " + MAX_SETTIMANE + " settimane";
	}
	
}
