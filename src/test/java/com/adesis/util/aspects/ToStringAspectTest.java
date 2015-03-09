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
	
	@SuppressWarnings("unused")
	private String myField;

	@Test
	public void testEmptyCase() {
		// System.out.println(new ToStringAspectTest());
		assertTrue("", new ToStringAspectTest().toString().contains("empty"));
	}
	
	@Test
	public void testNonEmptyCase() {
		final ToStringAspectTest test = new ToStringAspectTest();
		test.myField = "nonNull";
		assertFalse("", test.toString().contains("empty"));
	}
	
}
