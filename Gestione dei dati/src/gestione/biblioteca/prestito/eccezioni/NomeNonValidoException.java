package gestione.biblioteca.prestito.eccezioni;

public class NomeNonValidoException extends Exception{
	
	private String message;
	
	public NomeNonValidoException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
}
