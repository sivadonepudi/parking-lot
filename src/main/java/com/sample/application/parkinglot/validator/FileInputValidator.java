package com.sample.application.parkinglot.validator;

import java.io.File;
import java.util.StringTokenizer;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

public class FileInputValidator implements CommandValidator {

	@Override
	public void validate(String input) throws InvalidInputException {
		// file should contain atleast one
		// all commmands should be valid
		StringTokenizer inputTokenizer = new StringTokenizer(input, " ");
		assert (inputTokenizer.countTokens() == 1);
		if (new File(input).isDirectory()) {
			throw new InvalidInputException(input + "is a directory");
		}
		if (!new File(input).exists()) {
			throw new InvalidInputException(input + " is not found");
		}
	}

}
