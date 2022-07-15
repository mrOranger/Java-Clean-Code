package eccezioni;

public class FileNotFoundException extends RuntimeException{
	
	private String message;
	
	public FileNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
