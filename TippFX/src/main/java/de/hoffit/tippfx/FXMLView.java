package de.hoffit.tippfx;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javax.inject.Inject;

public abstract class FXMLView {

	private static final String DEFAULT_ENDING = "view";

	@Inject
	private FXMLLoader loader;

	private FXMLController controller;

	public FXMLView() {
		// this.init(getClass(), getFXMLName());
	}

	private void init(Class<?> clazz, String conventionalName) {
		final URL resource = clazz.getResource(conventionalName);
		loader.setLocation(resource);
		try {
			loader.load();
		} catch (IOException e) {
			throw new IllegalStateException("Cannot load FXML login screen", e);
		}
	}

	public Parent getView() {
		Parent parent = this.loader.getRoot();
		addCSSIfAvailable(parent);
		return parent;
	}

	public FXMLController getController() {
		return this.loader.getController();
	}

	void addCSSIfAvailable(Parent parent) {
		URL uri = getClass().getResource(getStyleSheetName());
		if (uri == null) {
			return;
		}
		String uriToCss = uri.toExternalForm();
		parent.getStylesheets().add(uriToCss);
	}

	String getStyleSheetName() {
		return getConventionalName(".css");
	}

	final String getFXMLName() {
		return getConventionalName(".fxml");
	}

	String getConventionalName(String ending) {
		String clazz = this.getClass().getSimpleName().toLowerCase();
		return stripEnding(clazz) + ending;
	}

	static String stripEnding(String clazz) {
		if (!clazz.endsWith(DEFAULT_ENDING)) {
			return clazz;
		}
		int viewIndex = clazz.lastIndexOf(DEFAULT_ENDING);
		return clazz.substring(0, viewIndex);
	}
}
