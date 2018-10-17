package com.sample.application.parkinglot.handler;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * Handler, allows/executes direct commands/set of commands in file
 * 
 * @author sidonepudi
 *
 */
public interface InputHandler {
	void execute(String input) throws InvalidInputException;
}
