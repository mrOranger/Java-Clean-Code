package gestione.biblioteca.prestito.eccezioni;

public class DataNonValidaException extends Exception{
	
	private String message;
	
	public DataNonValidaException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}

}
