package com.sample.application.parkinglot.validator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		// validate every line/command in the given input file
		try (BufferedReader br = new BufferedReader(new FileReader(input))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				// avoid cyclic
				if (line.endsWith(".txt")) {
					throw new InvalidInputException(line+" is an invalid content present in "+input);
				}
				ValidatorFactory.getInstance().getValidator(line).validate(line);
			}
		} catch (FileNotFoundException e) {
			throw new InvalidInputException(e.getMessage());
		} catch (IOException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}

}
