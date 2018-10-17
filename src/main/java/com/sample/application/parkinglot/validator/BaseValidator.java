/**
 * 
 */
package com.sample.application.parkinglot.validator;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * @author sidonepudi
 *
 */
public abstract class BaseValidator implements CommandValidator {

	public abstract void validate(String input) throws InvalidInputException;

	public void verifySyntax(int expectedTokens, int acutalTokens) throws InvalidInputException {
		if (expectedTokens != acutalTokens) {
			throw new InvalidInputException("Invalid syntax");
		}
	}
}
