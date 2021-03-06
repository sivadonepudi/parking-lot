package com.sample.application.parkinglot.handler;

import static java.lang.System.out;

/**
 * Can execute the set of commands in file
 * Singleton
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

public enum FileInputHandler implements InputHandler {
	INSTANCE;
	/**
	 * Identifies & executes all the commands specified in a given file input
	 */
	public void execute(String fileName) throws InvalidInputException {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				try {
					HandlerFactory.getInstance().createInputHandler(line).execute(line);
				} catch (InvalidInputException e) {
					out.println(e.getMessage());
				}
			}
		} catch (FileNotFoundException e) {
			throw new InvalidInputException(e.getMessage());
		} catch (IOException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}
}
