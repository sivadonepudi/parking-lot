package com.sample.application.parkinglot.validator;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

public class LeaveValidator implements CommandValidator {

	@Override
	public void validate(String input) throws InvalidInputException {
		String slotNumber = "";
		try {
			StringTokenizer inputTokenizer = new StringTokenizer(input, " ");
			assert (inputTokenizer.countTokens() == 2);
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
