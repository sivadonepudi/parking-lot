package com.sample.application.parkinglot.validator;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

public class CreateParkinglotValidator implements CommandValidator {

	@Override
	public void validate(String input) throws InvalidInputException {
		String noOfSlots = "";
		try {
			StringTokenizer inputTokenizer = new StringTokenizer(input, " ");
			assert (inputTokenizer.countTokens() == 2);
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
