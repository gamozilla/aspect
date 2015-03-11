package com.adesis.util.aspects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 * @author Adesis
 *
 */
public class ToStringAspectTest {

	// private static final String A_CONSTANT = "with value";

	private String myField;

	@Test
	public void testEmptyCase() {
		// System.out.println(new ToStringAspectTest());
		assertTrue("to string must be an empty bean", new ToStringAspectTest()
				.toString().contains("empty"));
	}

	@Test
	public void testNonEmptyCase() {
		final ToStringAspectTest test = new ToStringAspectTest();
		test.myField = "nonNull";
		assertFalse("This bean is not empty", test.toString().contains("empty"));
	}

	// This accesors are here in order to test TraceAspect - point-cuts for
	// accesors.
	public void setMyField(final String myField) {
		this.myField = myField;
	}

	public String getMyField() {
		return myField;
	}

}
