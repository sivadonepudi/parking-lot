package com.sample.application.parkinglot;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.sample.application.parkinglot.exceptions.InvalidInputException;
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

	public void execute(String input) throws InvalidInputException {
		ValidatorFactory.getInstance().getValidator(input).validate(input);
		HandlerFactory.getInstance().createInputHandler(input).execute(input);
	}

	public static void main(String[] args) {
		out.print("Enter the input:");
		Scanner inputScanner = new Scanner(System.in);
		String input = "";
		if (args != null && args.length == 1) {
			input = args[0];
		} else {
			input = inputScanner.nextLine();
		}
		ParkinglotApplication mySelf = new ParkinglotApplication();

		// as long as there is NO exit command
		while (!exitCommands.contains(input)) {
			try {
				mySelf.execute(input);
			} catch (InvalidInputException e) {
				out.println(e.getMessage());
			}
			input = inputScanner.nextLine();
		}
		out.println("*** Parking lot application shutdown. ***");
		inputScanner.close();
	}
}
