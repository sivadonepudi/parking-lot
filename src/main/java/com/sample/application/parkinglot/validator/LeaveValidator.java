package com.sample.application.parkinglot.validator;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import com.sample.application.parkinglot.exceptions.InvalidInputException;
import com.sample.application.parkinglot.handler.ParkinglotUtils;

/**
 * Validator for "leave"
 * 
 * @author sidonepudi
 *
 */
public class LeaveValidator extends BaseValidator {

	@Override
	public void validate(String input) throws InvalidInputException {
		String slotNumber = "";
		try {
			StringTokenizer inputTokenizer = new StringTokenizer(input, ParkinglotUtils.DELIMITER);
			super.verifySyntax(2, inputTokenizer.countTokens());
			String command = inputTokenizer.nextToken();
			slotNumber = inputTokenizer.nextToken();

			if (Integer.parseInt(slotNumber) < 1) {
				throw new InvalidInputException(slotNumber + " is not a valid slot number");
			}

		} catch (NumberFormatException e) {
			throw new InvalidInputException(slotNumber + " is not a valid slot number");
		} catch (NoSuchElementException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}

}
