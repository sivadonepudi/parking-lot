package com.sample.application.parkinglot.validator;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * Validator for "registration_numbers_for_cars_with_colour"
 * registration_numbers_for_cars_with_colour <color>
 * 
 * @author sidonepudi
 *
 */
public class RegistrationNumbersWithColorValidator extends BaseValidator implements CommandValidator {

	@Override
	public void validate(String input) throws InvalidInputException {
		try {
			StringTokenizer inputTokenizer = new StringTokenizer(input, " ");
			super.verifySyntax(2, inputTokenizer.countTokens());
			String command = inputTokenizer.nextToken();
			String color = inputTokenizer.nextToken();

		} catch (NoSuchElementException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}

}
