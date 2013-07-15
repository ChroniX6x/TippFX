package de.hoffit.tippfx;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppManager {

	@Inject
	Instance<Object> instance;

	@Inject
	Model model;

	@Inject
	View view;

	public void startup(@Observes @Startup Stage s) {
		s.setTitle("Test");
		AnchorPane pane = new AnchorPane();
		Scene scene = new Scene(pane, 300, 300);
		s.setScene(scene);
		s.show();
	}

}
