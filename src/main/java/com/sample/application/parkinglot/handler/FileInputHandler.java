package com.sample.application.parkinglot.handler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.sample.application.parkinglot.exceptions.InvalidInputException;
import com.sample.application.parkinglot.validator.CommandValidatorFactory;

public enum FileInputHandler implements InputHandler {
	INSTANCE;
	public void execute(String fileName) throws InvalidInputException {
		InputHandlerFactory factory = new InputHandlerFactory();
		CommandValidatorFactory validatorFactory = new CommandValidatorFactory();
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
