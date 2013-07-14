package de.hoffit.tippfx;

import javax.inject.Inject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TippFX extends Application {

	@Inject
	Logger l;
	
	@Override
	public void start(Stage primaryStage) {

		Weld weld = new Weld();

		WeldContainer container = weld.initialize();

		container.instance().select(TippFX.class).get();

		weld.shutdown();

//		Logger logger = LoggerFactory.getLogger(TippFX.class);
		l.debug("BLA");

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
