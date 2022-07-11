package gestione.biblioteca.prestito.base;

public class Opera {
	
	protected String titolo;
	
	protected Opera(String titolo) {
		this.titolo = titolo;
	}
	
	@Override
	public String toString() {
		return this.titolo;
	}
	
}
