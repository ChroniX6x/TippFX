package de.hoffit.tippfx;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.slf4j.Logger;

public class TippFX extends Application {

	@Inject
	Instance<Logger> l;

	@Override
	public void start(Stage primaryStage) {

		// Let's initialize CDI/Weld.
		WeldContainer weldContainer = new Weld().initialize();

		// Make the application parameters injectable with a standard CDI
		// annotation
		ApplicationStartupProvider provider = weldContainer.instance()
				.select(ApplicationStartupProvider.class).get();
		provider.setParameters(getParameters());
		provider.setStage(primaryStage);

		// Now that JavaFX thread is ready
		// let's inform whoever cares using standard CDI notification mechanism:
		// CDI events
		weldContainer.event()
				.select(Stage.class, new AnnotationLiteral<Startup>() {
				}).fire(primaryStage);

	}

	public static void main(String[] args) {
		launch(args);
	}
}
