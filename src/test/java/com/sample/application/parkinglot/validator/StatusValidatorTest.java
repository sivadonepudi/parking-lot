/**
 * 
 */
package com.sample.application.parkinglot.validator;

import org.junit.Before;
import org.junit.Test;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * @author sidonepudi
 *
 */
public class StatusValidatorTest {
	private BaseValidator validator;

	@Before
	public void init() {
		validator = new StatusValidator();
	}

	@Test(expected = InvalidInputException.class)
	public void testVerifySyntaxException() throws InvalidInputException {
		validator.verifySyntax(1, 2);
	}

	@Test
	public void testVerifySyntax() throws InvalidInputException {
		validator.verifySyntax(1, 1);
	}

}
