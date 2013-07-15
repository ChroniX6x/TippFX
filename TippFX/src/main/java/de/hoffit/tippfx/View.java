package de.hoffit.tippfx;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.slf4j.Logger;

public class View {

	@Inject
	@Any
	private Instance<FXMLView> views;

	@Inject
	private Logger log;

	public View() {
	}

	@PostConstruct
	public void test() {
		for (FXMLView view : views) {
			log.info("create view: " + view);
		}

		FXMLView selected = views.select(new ViewTypeQualifier("TippFXView"))
				.get();
		log.info("selected view: " + selected);
	}
}
