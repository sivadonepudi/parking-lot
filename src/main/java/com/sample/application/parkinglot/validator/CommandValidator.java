package com.sample.application.parkinglot.validator;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

public interface CommandValidator {
	void validate(String input) throws InvalidInputException;
}
