package com.sample.application.parkinglot.validator;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * Validator for "park" park <registration number> <color>
 * 
 * @author sidonepudi
 *
 */
public class ParkValidator extends BaseValidator implements CommandValidator {

	@Override
	public void validate(String input) throws InvalidInputException {
		try {
			StringTokenizer inputTokenizer = new StringTokenizer(input, " ");
			super.verifySyntax(3, inputTokenizer.countTokens());
			String command = inputTokenizer.nextToken();
			String registrationNumber = inputTokenizer.nextToken();
			String color = inputTokenizer.nextToken();

		} catch (NoSuchElementException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}

}
