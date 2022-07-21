package javafx.esercizio_login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.esercizio_login.database.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;

public class RegisterController {
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private Button register_button;
	
	private Alert alert;
	private final String alertMessage = "Please enter valid credentials";
	private final String alertTitle = "Invalid credentials!";
	
	private DatabaseManager database;
	
	public RegisterController() {
		this.database = new DatabaseManager();
		this.setAlert();
	}

	public void openWindow() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(root, 450, 400);
		stage.setTitle("Register");
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void register(ActionEvent event) {
		this.registerUser();
		((Node)(event.getSource())).getScene().getWindow().hide();
		this.database.closeConnection();
		try {
			new LoginController().openWindow();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void registerUser() {
		if(!this.checkCredentials()) {
			this.alert.show();
		} else {
			String username = this.username.getText();
			String password = this.password.getText();
			this.database.registerUser(username, password);
			System.out.println("Utente registrato correttamente!");
		}
	}
	
	private boolean checkCredentials() {
		return (!this.username.getText().isBlank() || !this.password.getText().isBlank());
	}
	
	private void setAlert() {
		this.alert = new Alert(AlertType.INFORMATION, this.alertMessage);
		this.alert.setTitle(this.alertTitle);
	}
}
