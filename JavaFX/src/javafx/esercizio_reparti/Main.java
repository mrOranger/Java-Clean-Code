package javafx.esercizio_reparti;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("esercizio_reparti.fxml"));
		Scene scene = new Scene(root);
		
		stage.setTitle("Esercizio Reparti");
		stage.setScene(scene);
		stage.show();
	}
}
