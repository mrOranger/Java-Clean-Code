package javafx.examples.fxml;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("prova.fxml"));
		Scene scene = new Scene(root);
		
		stage.setTitle("Prova");
		stage.setScene(scene);
		stage.show();
	}
}
