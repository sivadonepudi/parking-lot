package com.sample.application.parkinglot.handler;

import java.util.StringTokenizer;
import java.util.function.Predicate;

import com.sample.application.parkinglot.Command;
import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * This factory, constructs the necessary handler for a given input
 * 
 * @author sidonepudi
 *
 */
public class HandlerFactory {

	private static HandlerFactory factory;

	private HandlerFactory() {
	}

	public static HandlerFactory getInstance() {
		if (factory == null) {
			factory = new HandlerFactory();
		}
		return factory;
	}

	public InputHandler createInputHandler(String input) throws InvalidInputException {

		// if the input is ending with .txt, considering it as file input
		if (input.endsWith(".txt")) {
			return FileInputHandler.INSTANCE;
		}

		Predicate<String> commandValidator = (s) -> Command.getSupportedOperations().contains(s);
		StringTokenizer inputTokenizer = new StringTokenizer(input, " ");

		// picking the first word from the given line
		String cmd = inputTokenizer.nextToken();
		// if the the operation is supported
		if (commandValidator.test(cmd)) {
			return CommandHandler.INSTANCE;
		}

		throw new InvalidInputException("Invalid input: " + input);
	}
}
