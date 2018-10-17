package com.sample.application.parkinglot.validator;

import java.io.File;
import java.util.StringTokenizer;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * Validator file based commands
 * 
 * @author sidonepudi
 *
 */
public class FileInputValidator extends BaseValidator implements CommandValidator {

	@Override
	public void validate(String input) throws InvalidInputException {
		StringTokenizer inputTokenizer = new StringTokenizer(input, " ");
		super.verifySyntax(1, inputTokenizer.countTokens());
		if (new File(input).isDirectory()) {
			throw new InvalidInputException(input + "is a directory");
		}
		if (!new File(input).exists()) {
			throw new InvalidInputException(input + " is not found");
		}
	}

}
