package javafx.esercizio_login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;

public class RegisterController {
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private Button register_button;

	public void openWindow() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(root, 450, 400);
		stage.setTitle("Login");
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void register(ActionEvent event) {
		try {
			((Node)(event.getSource())).getScene().getWindow().hide();
			new LoginController().openWindow();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
