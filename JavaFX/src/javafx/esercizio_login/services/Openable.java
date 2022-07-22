package javafx.esercizio_login.services;

import java.io.IOException;

public interface Openable {
	public abstract void openWindow(String fxFile, String title) throws IOException;
}
