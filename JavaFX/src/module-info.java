module JavaFX {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.media;
    requires javafx.web;
    requires javafx.swing;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.sql;
	
	opens javafx.examples.start to javafx.graphics, javafx.fxml;
	opens javafx.examples.fxml to javafx.graphics, javafx.fxml;
	opens javafx.esercizio_login to javafx.graphics, javafx.fxml;
}
