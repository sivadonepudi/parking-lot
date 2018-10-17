package com.sample.application.parkinglot.validator;

import java.util.function.Predicate;

import com.sample.application.parkinglot.Command;

/**
 * Various predicators to validate provided command
 * 
 * @author sidonepudi
 *
 */
public class ValidatorPredicates {
	public static final Predicate<String> EMPTY_CHECK = s -> s == null || s.isEmpty();
	public static final Predicate<String> CREATE_PARKING_LOT_CHECK = s -> s
			.equalsIgnoreCase(Command.CRAEATE_PARKING_LOT.getValue());
	public static final Predicate<String> PARK_CHECK = s -> s.equalsIgnoreCase(Command.PARK.getValue());
	public static final Predicate<String> LEAVE_CHECK = s -> s.equalsIgnoreCase(Command.LEAVE.getValue());
	public static final Predicate<String> STATUS_CHECK = s -> s.equalsIgnoreCase(Command.STATUS.getValue());
	public static final Predicate<String> REGISTRATION_NUMBERS_WITH_COLOR_CHECK = s -> s
			.equalsIgnoreCase(Command.REGISTRATION_NUMBERS_WITH_COLOR.getValue());
	public static final Predicate<String> SLOT_NUMBERS_WITH_COLOR_CHECK = s -> s
			.equalsIgnoreCase(Command.SLOT_NUMBERS_WITH_COLOR.getValue());
	public static final Predicate<String> SLOT_NUMBER_FOR_REGISTRATION_NUMBER_CHECK = s -> s
			.equalsIgnoreCase(Command.SLOT_NUMBER_FOR_REGISTRATION_NUMBER.getValue());
	public static final Predicate<String> FILE_INPUT_CHECK = s -> s.endsWith(".txt");
}
