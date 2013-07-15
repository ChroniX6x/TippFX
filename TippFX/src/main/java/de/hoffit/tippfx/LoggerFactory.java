package de.hoffit.tippfx;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;

public class LoggerFactory {
	@Produces
	public Logger getLogger(InjectionPoint caller) {
		return org.slf4j.LoggerFactory.getLogger(caller.getMember()
				.getDeclaringClass().getName());
	}
}