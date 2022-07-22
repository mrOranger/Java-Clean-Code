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

import javafx.esercizio_login.database.DatabaseManager;
import javafx.esercizio_login.exceptions.LoginException;
import javafx.esercizio_login.services.Alertable;
import javafx.esercizio_login.services.Openable;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;

public class LoginController implements Alertable, Openable{
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private Button register_button;
	@FXML private Button login_button;
	
	private DatabaseManager database;
	
	public LoginController() {
		this.database = new DatabaseManager();
	}

	@FXML
	public void register(ActionEvent event) {
		try {
			((Node)(event.getSource())).getScene().getWindow().hide();
			this.database.closeConnection();
			new RegisterController().openWindow("register.fxml", "Register");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void login(ActionEvent event) throws LoginException {
		if(!this.checkCredentials()) {
			this.showAlert("Invalid credentials!", "Please write valid credentials", AlertType.WARNING);
			throw new LoginException("Invalid credentials!");
		} else {
			String username = this.username.getText();
			String password = this.password.getText();
			User user = this.database.getUser(username);
			
			if(!this.isPresentUser(user)) {
				if(user.getPassword().equals(password)) {
					this.showAlert("Login successfull", "Login complete with success", AlertType.INFORMATION);
				} else {
					this.showAlert("Wrong password", "The password is not correct!", AlertType.ERROR);
					throw new LoginException("The password is not correct!");
				}				
			} else {
				this.showAlert("User not registered", "The user is not registered in the Database", AlertType.ERROR);
				throw new LoginException("User not registered!");
			}
		}
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
	
	@Override
	public void showAlert(String title, String message, AlertType alertType) {
		Alert alert = new Alert(alertType, message);
		alert.setTitle(message);
		alert.show();
	}
	
	private boolean checkCredentials() {
		return (!this.username.getText().isBlank() || !this.password.getText().isBlank());
	}
	
	private boolean isPresentUser(User user) {
		return user != null;
	}
}
