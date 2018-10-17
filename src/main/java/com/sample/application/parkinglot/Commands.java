/**
 * 
 */
package com.sample.application.parkinglot;

import java.util.stream.Stream;

/**
 * Commands supported by parking lot application
 * 
 * @author sidonepudi
 *
 */
public enum Commands {
	CRAEATE_PARKING_LOT("create_parking_lot"),
	REGISTRATION_NUMBERS_WITH_COLOR("registration_numbers_for_cars_with_colour"),
	SLOT_NUMBERS_WITH_COLOR("slot_numbers_for_cars_with_colour"),
	SLOT_NUMBER_FOR_REGISTRATION_NUMBER("slot_number_for_registration_number"),
	LEAVE("leave"),
	STATUS("status"),
	PARK("park");

	private String value;

	private Commands(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Stream<Commands> stream() {
		return Stream.of(Commands.values());
	}
}
