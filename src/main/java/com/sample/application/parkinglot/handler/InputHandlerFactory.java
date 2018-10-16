package com.sample.application.parkinglot.handler;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Predicate;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * This factory constructs the necessary handler for a given input
 * 
 * @author sidonepudi
 *
 */
public class InputHandlerFactory {
	private static final List<String> validCommands = Arrays.asList("create_parking_lot",
			"registration_numbers_for_cars_with_colour", "slot_numbers_for_cars_with_colour",
			"slot_number_for_registration_number", "leave", "status", "park");

	public InputHandler createInputHandler(String input) throws InvalidInputException {
		// handing empty input
		if (input == null || input.length() < 1) {
			throw new InvalidInputException("Invalid input: " + input);
		}

		// if the input is ending with .txt, considering it as file input
		if (input.endsWith(".txt")) {
			return FileInputHandler.INSTANCE;

		}

		Predicate<String> commandValidator = (s) -> validCommands.contains(s);
		StringTokenizer inputTokenizer = new StringTokenizer(input, " ");

		// picking the first word from the given line
		String cmd = inputTokenizer.nextToken();
		// if is the the operation is supported
		if (commandValidator.test(cmd)) {
			return CommandInputHandler.INSTANCE;
		}

		throw new InvalidInputException("Invalid input: " + input);
	}
}
