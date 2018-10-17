package com.sample.application.parkinglot.validator;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * Validator for "park" 
 * park <registration number> <color>
 * 
 * @author sidonepudi
 *
 */
public class ParkValidator implements CommandValidator {

	@Override
	public void validate(String input) throws InvalidInputException {
		try {
			StringTokenizer inputTokenizer = new StringTokenizer(input, " ");
			assert (inputTokenizer.countTokens() == 3);
			String command = inputTokenizer.nextToken();
			String registrationNumber = inputTokenizer.nextToken();
			String color = inputTokenizer.nextToken();

		} catch (NoSuchElementException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}

}
