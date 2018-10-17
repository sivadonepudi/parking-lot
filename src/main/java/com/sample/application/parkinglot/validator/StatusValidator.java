package com.sample.application.parkinglot.validator;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * Validator for "status"
 * 
 * @author sidonepudi
 *
 */
public class StatusValidator extends BaseValidator implements CommandValidator {

	@Override
	public void validate(String input) throws InvalidInputException {
		try {
			StringTokenizer inputTokenizer = new StringTokenizer(input, " ");
			super.verifySyntax(1, inputTokenizer.countTokens());
			String command = inputTokenizer.nextToken();

		} catch (NoSuchElementException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}

}
