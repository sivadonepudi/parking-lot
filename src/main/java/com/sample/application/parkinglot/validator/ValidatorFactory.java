/**
 * 
 */
package com.sample.application.parkinglot.validator;

import java.util.StringTokenizer;

import com.sample.application.parkinglot.exceptions.InvalidInputException;
import com.sample.application.parkinglot.handler.ParkinglotUtils;

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
	public static ValidatorFactory getInstance() {
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

		if (Predicates.EMPTY_CHECK.test(input)) {
			throw new InvalidInputException("empty input");
		}
		StringTokenizer tokenizer = new StringTokenizer(input, ParkinglotUtils.DELIMITER);
		String command = tokenizer.nextToken();

		if (Predicates.CREATE_PARKING_LOT_CHECK.test(command)) {
			return new CreateParkinglotValidator();
		}

		if (Predicates.PARK_CHECK.test(command)) {
			return new ParkValidator();
		}

		if (Predicates.LEAVE_CHECK.test(command)) {
			return new LeaveValidator();
		}

		if (Predicates.STATUS_CHECK.test(command)) {
			return new StatusValidator();
		}

		if (Predicates.REGISTRATION_NUMBERS_WITH_COLOR_CHECK.test(command)) {
			return new RegistrationNumbersWithColorValidator();
		}

		if (Predicates.SLOT_NUMBERS_WITH_COLOR_CHECK.test(command)) {
			return new SlotNumberWithColorValidator();
		}

		if (Predicates.SLOT_NUMBER_FOR_REGISTRATION_NUMBER_CHECK.test(command)) {
			return new SlotNumbersWithRegistrationNumberValidator();
		}

		if (Predicates.FILE_INPUT_CHECK.test(command)) {
			return new FileInputValidator();
		}

		throw new InvalidInputException("'" + input + "' is an invalid command. ");
	}

}
