package com.sample.application.parkinglot.handler;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import com.sample.application.parkinglot.Command;
import com.sample.application.parkinglot.entity.Slot;
import com.sample.application.parkinglot.entity.Vehicle;
import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * Executes the given command Singleton
 * 
 * @author sidonepudi
 *
 */
public enum CommandHandler implements InputHandler {
	INSTANCE;

	private static Set<Slot> parkingLot = new LinkedHashSet<Slot>();

	/**
	 * Identifies & executes the given single command. It considers first word in a
	 * line is command
	 */
	public void execute(String input) throws InvalidInputException {
		StringTokenizer inputTokenizer = new StringTokenizer(input, " ");
		String command = inputTokenizer.nextToken();
		if (command.equalsIgnoreCase(Command.CRAEATE_PARKING_LOT.getValue())) {
			handleCreate(input);
			return;
		}
		if (command.equalsIgnoreCase(Command.PARK.getValue())) {
			handlePark(input);
			return;
		}
		if (command.equalsIgnoreCase(Command.LEAVE.getValue())) {
			handleLeave(input);
			return;
		}
		if (command.equalsIgnoreCase(Command.STATUS.getValue())) {
			handleStatus(input);
			return;
		}
		if (command.equalsIgnoreCase(Command.REGISTRATION_NUMBERS_WITH_COLOR.getValue())) {
			handleRegistrationNumbersWithColor(input);
			return;
		}
		if (command.equalsIgnoreCase(Command.SLOT_NUMBERS_WITH_COLOR.getValue())) {
			handleSlotNumbersWithColor(input);
			return;
		}
		if (command.equalsIgnoreCase(Command.SLOT_NUMBER_FOR_REGISTRATION_NUMBER.getValue())) {
			handleSlotNumberForRegistrationNumber(input);
			return;
		}

	}

	/**
	 * Park the Vehicle to the nearest exit if there is an empty parking lot
	 * 
	 * @param input
	 * @throws InvalidInputException
	 */
	private void handlePark(String input) throws InvalidInputException {
		if (parkingLot.stream().count() < 1) {
			throw new InvalidInputException("Please create the parkinglot first");
		}
		Optional<Slot> empty = parkingLot.stream().filter((slot) -> (slot.getVehicle() == null)).findFirst();
		if (empty.isPresent()) {

			StringTokenizer inputTokenizer = new StringTokenizer(input, " ");
			String command = inputTokenizer.nextToken();
			String registrationNumber = inputTokenizer.nextToken();
			String color = inputTokenizer.nextToken();
			Vehicle vehicle = new Vehicle(registrationNumber, color);
			empty.get().setVehicle(vehicle);
			System.out.println("Allocated slot number: " + empty.get().getSlotNumber());
		} else {
			throw new InvalidInputException("Sorry, parking lot is full");
		}
	}

	/**
	 * Prints the Vehicle details parked in each slot
	 * 
	 * @param input
	 */
	private void handleStatus(String input) {
		// if the parking lot is created
		if (parkingLot.size() > 0) {
			System.out.println("Slot No." + "\t" + "Registration No" + "\t" + "Colour");
			parkingLot.stream().forEach(s -> {
				// if there is at least one vehicle in parking-lot
				if (s.getVehicle() != null) {
					System.out.println(s.getSlotNumber() + "\t\t" + s.getVehicle().getRegistrationNumber() + "\t"
							+ s.getVehicle().getColor());
				}
			});
		}
	}

	/**
	 * Prints all the parking slot numbers that contains specific color vehicle
	 * 
	 * @param input
	 */
	private void handleSlotNumbersWithColor(String input) {
		StringTokenizer inputTokenizer = new StringTokenizer(input, " ");
		String command = inputTokenizer.nextToken();
		String color = inputTokenizer.nextToken();
		StringBuilder slotNumbers = new StringBuilder();
		parkingLot.stream().filter(s -> s.getVehicle().getColor().equalsIgnoreCase(color)).forEach(a -> {
			slotNumbers.append(a.getSlotNumber());
			slotNumbers.append(", ");
		});
		// remove last ","
		if (slotNumbers.length() > 1) {
			slotNumbers.deleteCharAt(slotNumbers.lastIndexOf(","));
		}
		System.out.println(slotNumbers);
	}

	/**
	 * Prints the parking slot number for a specific vehicle
	 * 
	 * @param input
	 */
	private void handleSlotNumberForRegistrationNumber(String input) {
		StringTokenizer inputTokenizer = new StringTokenizer(input, " ");
		String command = inputTokenizer.nextToken();
		String registrationNumber = inputTokenizer.nextToken();
		Optional<Slot> slot = parkingLot.stream()
				.filter(s -> s.getVehicle().getRegistrationNumber().equalsIgnoreCase(registrationNumber)).findFirst();

		if (slot.isPresent()) {
			System.out.println(slot.get().getSlotNumber());
		} else {
			System.out.println("Not found");
		}

	}

	/**
	 * Prints all the registration number of vehicles with a specific color
	 * 
	 * @param input
	 */
	private void handleRegistrationNumbersWithColor(String input) {
		StringTokenizer inputTokenizer = new StringTokenizer(input, " ");
		String command = inputTokenizer.nextToken();
		String color = inputTokenizer.nextToken();
		StringBuilder registrationNumbers = new StringBuilder();
		parkingLot.stream().filter(s -> s.getVehicle().getColor().equalsIgnoreCase(color)).forEach(a -> {
			registrationNumbers.append(a.getVehicle().getRegistrationNumber());
			registrationNumbers.append(", ");
		});
		// remove last ","
		if (registrationNumbers.length() > 1) {
			registrationNumbers.deleteCharAt(registrationNumbers.lastIndexOf(","));
		}
		System.out.println(registrationNumbers);
	}

	/**
	 * Free up the specified parking slot
	 * 
	 * @param input
	 * @throws InvalidInputException
	 */
	private void handleLeave(String input) throws InvalidInputException {
		StringTokenizer inputTokenizer = new StringTokenizer(input, " ");
		String command = inputTokenizer.nextToken();
		int slotNumber = Integer.parseInt(inputTokenizer.nextToken());
		if (slotNumber > parkingLot.size()) {
			throw new InvalidInputException("invalid slot number," + slotNumber);
		}
		parkingLot.stream().filter((s) -> s.getSlotNumber() == slotNumber).collect(Collectors.toList()).get(0)
				.setVehicle(null);
		System.out.println("Slot number " + slotNumber + " is free");
	}

	/**
	 * Creates the parking lot with the specified number of parking slots
	 * 
	 * @param input
	 * @throws InvalidInputException
	 */
	private void handleCreate(String input) throws InvalidInputException {
		StringTokenizer inputTokenizer = new StringTokenizer(input, " ");
		String command = inputTokenizer.nextToken();
		int noOfSlots = Integer.parseInt(inputTokenizer.nextToken());
		parkingLot.clear();
		for (int i = 1; i <= noOfSlots; i++) {
			parkingLot.add(new Slot(i, null));
		}
		System.out.println("Created a parking lot with " + noOfSlots + " slots");
	}

}
