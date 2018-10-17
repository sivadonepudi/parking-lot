package com.sample.application.parkinglot.validator;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * Validator for the input
 * 
 * @author sidonepudi
 *
 */
public interface CommandValidator {
	void validate(String input) throws InvalidInputException;
}
