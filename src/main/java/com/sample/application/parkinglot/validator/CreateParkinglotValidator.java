package com.sample.application.parkinglot.validator;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import com.sample.application.parkinglot.exceptions.InvalidInputException;
import com.sample.application.parkinglot.handler.ParkinglotUtils;

/**
 * Validator for "create_parking_lot"
 * 
 * @author sidonepudi
 *
 */
public class CreateParkinglotValidator extends BaseValidator {

	@Override
	public void validate(String input) throws InvalidInputException {
		String noOfSlots = "";
		try {
			StringTokenizer inputTokenizer = new StringTokenizer(input, ParkinglotUtils.DELIMITER);
			super.verifySyntax(2, inputTokenizer.countTokens());
			String command = inputTokenizer.nextToken();
			noOfSlots = inputTokenizer.nextToken();
			if (Integer.parseInt(noOfSlots) < 1) {
				throw new InvalidInputException("minimum number of slots required = 1");
			}

		} catch (NumberFormatException e) {
			throw new InvalidInputException(noOfSlots + " is not a valid number to create parkinglot");
		} catch (NoSuchElementException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}

}
