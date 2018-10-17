package com.sample.application.parkinglot;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.sample.application.parkinglot.exceptions.InvalidInputException;
import com.sample.application.parkinglot.handler.InputHandler;
import com.sample.application.parkinglot.handler.HandlerFactory;
import com.sample.application.parkinglot.validator.ValidatorFactory;

/**
 * Parking lot application, can execute the following
 * 1. Input commands 
 * 2. Set of commands in file
 * 
 * It will be exited by the following commands 
 * 1. q
 * 2. Q
 * 3. quit
 * 4. QUIT
 * 5. exit
 * 6. EXIT
 * 
 * @author sidonepudi
 *
 */
public class ParkinglotApplication {
	private static final List<String> exitCommands = Arrays.asList("q", "Q", "quit", "QUIT", "exit", "EXIT");

	public static void main(String[] args) {
		System.out.print("Enter the input:");
		Scanner inputScanner = new Scanner(System.in);
		String input = inputScanner.nextLine();
		HandlerFactory factory = HandlerFactory.getInstance();
		ValidatorFactory validatorFactory = ValidatorFactory.getInstance();

		// as long as there is NO exit command
		while (!exitCommands.contains(input)) {
			try {
				validatorFactory.getValidator(input).validate(input);
				InputHandler handler = factory.createInputHandler(input);
				handler.execute(input);
			} catch (InvalidInputException e) {
				System.out.println(e.getMessage());
			}
			input = inputScanner.nextLine();
		}
		System.out.println("*** Parking lot application shutdown. ***");
		inputScanner.close();
	}
}
