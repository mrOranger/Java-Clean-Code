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
import javafx.esercizio_login.exceptions.RegisterException;
import javafx.esercizio_login.services.Alertable;
import javafx.esercizio_login.services.Openable;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;

public class RegisterController implements Alertable, Openable{
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private Button register_button;
	
	private DatabaseManager database;
	
	public RegisterController() {
		this.database = new DatabaseManager();
	}

	@Override
	public void openWindow(String fxFile, String title) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource(fxFile));
		Stage stage = new Stage();
		Scene scene = new Scene(root, 450, 400);
		stage.setTitle(title);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void register(ActionEvent event) {
		try {
			this.registerUser();
			((Node)(event.getSource())).getScene().getWindow().hide();
			new LoginController().openWindow("login.fxml", "Login");
		} catch (RegisterException registerException) {
			registerException.printStackTrace();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			this.database.closeConnection();
		}
	}
	
	private void registerUser() throws RegisterException {
		if(!this.checkCredentials()) {
			this.showAlert("Invalid credentials!", "The credentials are not valid", AlertType.ERROR);
			throw new RegisterException("Invalid credentials!");
		} else {
			try {
				String username = this.username.getText();
				String password = this.password.getText();
				this.database.registerUser(username, password);
				this.showAlert("User registered", "User register with success", AlertType.INFORMATION);
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void showAlert(String title, String message, AlertType alertType) {
		Alert alert = new Alert(alertType, message);
		alert.setTitle(message);
		alert.show();
	}
	
	private boolean checkCredentials() {
		return (!this.username.getText().isBlank() || !this.password.getText().isBlank());
	}
}
