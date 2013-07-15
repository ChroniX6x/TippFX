package de.hoffit.tippfx;

import javafx.application.Application.Parameters;
import javafx.stage.Stage;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

@Singleton
public class ApplicationStartupProvider {

	private Parameters parameters;
	private Stage stage;

	void setParameters(Parameters p) {
		this.parameters = p;
	}

	@Produces
	public Parameters getParameters() {
		return parameters;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@Produces
	public Stage getStage() {
		return stage;
	}
}
