package de.hoffit.tippfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TippFX extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Test");
		AnchorPane pane = new AnchorPane();
		Scene scene = new Scene(pane, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
