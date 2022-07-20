package javafx.examples.start;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/*
 * L'elemento alla base delle interfacce in JavaFX è lo Stage,
 * che potremmo dire rappresenti la finetra stessa mostrata dal Sistema Operativo.
 * Allo Stage viene attaccata una Scene, che contiene tutti gli elementi
 * grafici che definiscono l'interfaccia, e che richiede le dimensioni
 * di altezza (height) e larghezza (width).
 * Ad una Scene deve essere aggiunto un pannello (Pane) che definisce come gli elementi
 * vengono logicamente impostanti nella scena, in questo caso
 * abbiamo usato uno StackPane che inserisce gli elementi uno sopra l'altro. 
 * Possiamo quindi aggiungere ad un pannello degli elementi grafici, e solo 
 * successivamente dei listener se questi implementano degli eventi.
 */
public class Main extends Application {
	
	private int numeroClick = 0;
	private static final int WIDTH = 450;
	private static final int HEIGHT = 300;
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Prova");
		Button button = new Button();
		button.setText("Cliccato " + this.numeroClick + " volte");
		button.setOnAction(new ButtonListener(button, this.numeroClick));
		
		StackPane pane = new StackPane();
		pane.getChildren().add(button);
		
		primaryStage.setScene(new Scene(pane, WIDTH, HEIGHT));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
