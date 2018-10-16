package com.sample.application.parkinglot;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.sample.application.parkinglot.exceptions.InvalidInputException;
import com.sample.application.parkinglot.handler.InputHandler;
import com.sample.application.parkinglot.handler.InputHandlerFactory;
import com.sample.application.parkinglot.validator.CommandValidatorFactory;

public class ParkinglotApplication {
	private static final List<String> exitCommands = Arrays.asList("q", "Q", "quit", "QUIT", "exit", "EXIT");

	public static void main(String[] args) {
		System.out.print("Enter the input:");
		Scanner inputScanner = new Scanner(System.in);
		String input = inputScanner.nextLine();
		InputHandlerFactory factory = new InputHandlerFactory();
		CommandValidatorFactory validatorFactory = new CommandValidatorFactory();

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
		System.out.println("*** Parkinglot application shutdown. ***");
		inputScanner.close();
	}

}
