package de.hoffit.tippfx;

import javax.enterprise.util.AnnotationLiteral;

public class ViewTypeQualifier extends AnnotationLiteral<ViewType> implements
		ViewType {

	private static final long serialVersionUID = 7207617174531076120L;

	private String type;

	public ViewTypeQualifier(String type) {
		this.type = type;
	}

	@Override
	public String value() {
		return this.type;
	}

}
