package javafx.esercizio_login.services;

import javafx.scene.control.Alert.AlertType;

public interface Alertable {
	public abstract void showAlert(String title, String message, AlertType alertType);
}
