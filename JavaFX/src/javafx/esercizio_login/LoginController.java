package javafx.esercizio_login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;

public class LoginController {
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private Button register_button;
	@FXML private Button login_button;

	@FXML
	public void register(ActionEvent event) {
		System.out.println("Register: " + username.getText() + " " + password.getText());
	}
	
	@FXML
	public void login(ActionEvent event) {
		System.out.println("Login: " + username.getText() + " " + password.getText());
	}
}
