package com.sample.application.parkinglot.validator;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * Validator for "slot_number_for_registration_number"
 * slot_number_for_registration_number <registration number>
 * 
 * @author sidonepudi
 *
 */
public class SlotNumbersWithRegistrationNumberValidator implements CommandValidator {

	@Override
	public void validate(String input) throws InvalidInputException {
		try {
			StringTokenizer inputTokenizer = new StringTokenizer(input, " ");
			assert (inputTokenizer.countTokens() == 2);
			String command = inputTokenizer.nextToken();
			String registrationNumber = inputTokenizer.nextToken();

		} catch (NoSuchElementException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}

}
