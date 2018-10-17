/**
 * 
 */
package com.sample.application.parkinglot;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * Commands supported by parking lot application
 * 
 * @author sidonepudi
 *
 */
public enum Command {
	CRAEATE_PARKING_LOT("create_parking_lot"),
	REGISTRATION_NUMBERS_WITH_COLOR("registration_numbers_for_cars_with_colour"),
	SLOT_NUMBERS_WITH_COLOR("slot_numbers_for_cars_with_colour"),
	SLOT_NUMBER_FOR_REGISTRATION_NUMBER("slot_number_for_registration_number"),
	LEAVE("leave"),
	STATUS("status"),
	PARK("park");

	private String value;

	private static List<String> commands;

	private Command(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static List<String> getSupportedOperations() {
		if (commands == null) {
			commands = Stream.of(Command.values()).map(c -> c.getValue()).collect(Collectors.toList());
		}
		return commands;
	}

	public static Command getCommand(String value) throws InvalidInputException {
		Optional<Command> command = Stream.of(Command.values()).filter(c -> c.getValue().equalsIgnoreCase(value))
				.findFirst();
		if (command.isPresent()) {
			return command.get();
		}
		throw new InvalidInputException(value + ", operation is not supproted.");
	}
}
