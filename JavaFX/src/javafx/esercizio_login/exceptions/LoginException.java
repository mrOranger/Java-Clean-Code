package javafx.esercizio_login.exceptions;

public class LoginException extends Exception{
	private static final long serialVersionUID = 8675025625685359637L;
	private String message;
	
	public LoginException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
