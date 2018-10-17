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
	public static ValidatorFactory getCommandValidatorFactory() {
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

		if (CommandValidatorPredicates.EMPTY_CHECK.test(input)) {
			throw new InvalidInputException("empty input");
		}
		StringTokenizer tokenizer = new StringTokenizer(input, " ");
		String command = tokenizer.nextToken();

		if (CommandValidatorPredicates.CREATE_PARKING_LOT_CHECK.test(command)) {
			return new CreateParkinglotValidator();
		}

		if (CommandValidatorPredicates.PARK_CHECK.test(command)) {
			return new ParkValidator();
		}

		if (CommandValidatorPredicates.LEAVE_CHECK.test(command)) {
			return new LeaveValidator();
		}

		if (CommandValidatorPredicates.STATUS_CHECK.test(command)) {
			return new StatusValidator();
		}

		if (CommandValidatorPredicates.REGISTRATION_NUMBERS_WITH_COLOR_CHECK.test(command)) {
			return new RegistrationNumbersWithColorValidator();
		}

		if (CommandValidatorPredicates.SLOT_NUMBERS_WITH_COLOR_CHECK.test(command)) {
			return new SlotNumberWithColorValidator();
		}

		if (CommandValidatorPredicates.SLOT_NUMBER_FOR_REGISTRATION_NUMBER_CHECK.test(command)) {
			return new SlotNumbersWithRegistrationNumberValidator();
		}

		if (CommandValidatorPredicates.FILE_INPUT_CHECK.test(command)) {
			return new FileInputValidator();
		}

		throw new InvalidInputException("'" + input + "' is an invalid command. ");
	}

}
