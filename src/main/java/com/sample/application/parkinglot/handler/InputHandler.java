package com.sample.application.parkinglot.handler;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * Handler, executes the Provided Command
 * 
 * @author sidonepudi
 *
 */
public interface InputHandler {
	void execute(String input) throws InvalidInputException;
}
