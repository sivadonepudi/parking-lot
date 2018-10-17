/**
 * 
 */
package com.sample.application.parkinglot.validator;

import java.util.StringTokenizer;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * Factory of input validators
 * 
 * @author sidonepudi
 *
 */
public class ValidatorFactory {
	private static ValidatorFactory factory;

	private ValidatorFactory() {

	}

	/**
	 * Returns the singleton instance
	 * 
	 * @return
	 */
	public static ValidatorFactory getValidatorFactory() {
		if (factory == null) {
			factory = new ValidatorFactory();
		}
		return factory;
	}

	/**
	 * Returns the appropriate validator the given command
	 * 
	 * @param input
	 * @return
	 * @throws InvalidInputException
	 */
	public CommandValidator getValidator(String input) throws InvalidInputException {

		if (ValidatorPredicates.EMPTY_CHECK.test(input)) {
			throw new InvalidInputException("empty input");
		}
		StringTokenizer tokenizer = new StringTokenizer(input, " ");
		String command = tokenizer.nextToken();

		if (ValidatorPredicates.CREATE_PARKING_LOT_CHECK.test(command)) {
			return new CreateParkinglotValidator();
		}

		if (ValidatorPredicates.PARK_CHECK.test(command)) {
			return new ParkValidator();
		}

		if (ValidatorPredicates.LEAVE_CHECK.test(command)) {
			return new LeaveValidator();
		}

		if (ValidatorPredicates.STATUS_CHECK.test(command)) {
			return new StatusValidator();
		}

		if (ValidatorPredicates.REGISTRATION_NUMBERS_WITH_COLOR_CHECK.test(command)) {
			return new RegistrationNumbersWithColorValidator();
		}

		if (ValidatorPredicates.SLOT_NUMBERS_WITH_COLOR_CHECK.test(command)) {
			return new SlotNumberWithColorValidator();
		}

		if (ValidatorPredicates.SLOT_NUMBER_FOR_REGISTRATION_NUMBER_CHECK.test(command)) {
			return new SlotNumbersWithRegistrationNumberValidator();
		}

		if (ValidatorPredicates.FILE_INPUT_CHECK.test(command)) {
			return new FileInputValidator();
		}

		throw new InvalidInputException("'" + input + "' is an invalid command. ");
	}

}
