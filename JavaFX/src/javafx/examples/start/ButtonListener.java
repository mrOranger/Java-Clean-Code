package javafx.examples.start;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonListener implements EventHandler<ActionEvent>{
	
	private Button button;
	private int numeroClick;
	
	public ButtonListener(Button button, int numeroClick) {
		this.button = button;
		this.numeroClick = numeroClick;
	}

	@Override
	public void handle(ActionEvent arg0) {
		this.numeroClick++;
		this.button.setText("Cliccato " + this.numeroClick + " volte");
	}
}
