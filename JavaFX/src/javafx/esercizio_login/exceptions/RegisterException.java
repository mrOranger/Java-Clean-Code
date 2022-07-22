package javafx.esercizio_login.exceptions;

public class RegisterException extends Exception{

	private String message;
	
	public RegisterException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
}
