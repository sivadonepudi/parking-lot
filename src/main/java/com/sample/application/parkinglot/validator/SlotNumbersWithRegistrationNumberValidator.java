package com.sample.application.parkinglot.validator;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import com.sample.application.parkinglot.exceptions.InvalidInputException;
import com.sample.application.parkinglot.handler.ParkinglotUtils;

/**
 * Validator for "slot_number_for_registration_number"
 * slot_number_for_registration_number <registration number>
 * 
 * @author sidonepudi
 *
 */
public class SlotNumbersWithRegistrationNumberValidator extends BaseValidator {

	@Override
	public void validate(String input) throws InvalidInputException {
		try {
			StringTokenizer inputTokenizer = new StringTokenizer(input, ParkinglotUtils.DELIMITER);
			super.verifySyntax(2, inputTokenizer.countTokens());
			String command = inputTokenizer.nextToken();
			String registrationNumber = inputTokenizer.nextToken();

		} catch (NoSuchElementException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}

}
