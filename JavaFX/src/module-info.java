module JavaFX {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.media;
    requires javafx.web;
    requires javafx.swing;
    requires javafx.graphics;
	
	opens javafx.examples.start to javafx.graphics, javafx.fxml;
}
