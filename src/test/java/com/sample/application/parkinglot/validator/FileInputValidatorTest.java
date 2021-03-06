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
public class FileInputValidatorTest {
	private BaseValidator validator;

	@Before
	public void init() {
		validator = new FileInputValidator();
	}

	@Test(expected = InvalidInputException.class)
	public void testVerifySyntaxException() throws InvalidInputException {
		validator.verifySyntax(2, 3);
	}

	@Test
	public void testVerifySyntax() throws InvalidInputException {
		validator.verifySyntax(2, 2);
	}
}
