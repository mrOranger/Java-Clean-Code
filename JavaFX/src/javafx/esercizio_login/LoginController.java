package javafx.esercizio_login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;

public class LoginController {
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private Button register_button;
	@FXML private Button login_button;
	
	private Alert alert;
	private final String alertMessage = "Please enter valid credentials";
	private final String alertTitle = "Invalid credentials!";
	
	public LoginController() {
		this.setAlert();
	}

	@FXML
	public void register(ActionEvent event) {
		try {
			((Node)(event.getSource())).getScene().getWindow().hide();
			new RegisterController().openWindow();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void login(ActionEvent event) {
		if(!this.checkCredentials()) {
			this.alert.show();
		} else {
			System.out.println("Login: " + username.getText() + " " + password.getText());	
		}
	}
	
	public void openWindow() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(root, 450, 400);
		stage.setTitle("Login");
		stage.setScene(scene);
		stage.show();
	}
	
	private boolean checkCredentials() {
		return (!this.username.getText().isBlank() || !this.password.getText().isBlank());
	}
	
	private void setAlert() {
		this.alert = new Alert(AlertType.INFORMATION, this.alertMessage);
		this.alert.setTitle(this.alertTitle);
	}
}
