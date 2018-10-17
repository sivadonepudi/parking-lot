package com.sample.application.parkinglot.handler;

/**
 * Can execute the set of commands in file
 * Singleton
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.sample.application.parkinglot.exceptions.InvalidInputException;
import com.sample.application.parkinglot.validator.ValidatorFactory;

public enum FileInputHandler implements InputHandler {
	INSTANCE;
	/**
	 * Identifies & executes all the commands specified in a given file input
	 */
	public void execute(String fileName) throws InvalidInputException {
		HandlerFactory factory = HandlerFactory.getInstance();
		ValidatorFactory validatorFactory = ValidatorFactory.getInstance();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				// avoid cyclic
				if (line.endsWith(".txt")) {
					throw new InvalidInputException("Invalid content found in input file");
				}
				try {
					validatorFactory.getValidator(line).validate(line);
					factory.createInputHandler(line).execute(line);
				} catch (InvalidInputException e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (FileNotFoundException e) {
			throw new InvalidInputException(e.getMessage());
		} catch (IOException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}
}
