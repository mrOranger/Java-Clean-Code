package javafx.esercizio_login.exceptions;

public class RegisterException extends Exception{

	private static final long serialVersionUID = -1724102607372816810L;
	private String message;
	
	public RegisterException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
}
