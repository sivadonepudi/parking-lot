/**
 * 
 */
package com.sample.application.parkinglot;

import org.junit.Assert;
import org.junit.Test;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * @author sidonepudi
 *
 */
public class CommandTest {

	@Test
	public void testGetSupportedOperations() {
		Assert.assertNotNull(Command.getSupportedOperations());
		Assert.assertEquals(7, Command.getSupportedOperations().size());
	}

	@Test
	public void testGetCommand() {
		try {
			Assert.assertEquals(Command.CRAEATE_PARKING_LOT, Command.getCommand("create_parking_lot"));
			Assert.assertEquals(Command.REGISTRATION_NUMBERS_WITH_COLOR,
					Command.getCommand("registration_numbers_for_cars_with_colour"));
			Assert.assertEquals(Command.SLOT_NUMBERS_WITH_COLOR,
					Command.getCommand("slot_numbers_for_cars_with_colour"));
			Assert.assertEquals(Command.SLOT_NUMBER_FOR_REGISTRATION_NUMBER,
					Command.getCommand("slot_number_for_registration_number"));
			Assert.assertEquals(Command.LEAVE, Command.getCommand("leave"));
			Assert.assertEquals(Command.STATUS, Command.getCommand("status"));
			Assert.assertEquals(Command.PARK, Command.getCommand("park"));
		} catch (InvalidInputException e) {
			Assert.fail(e.getMessage());
		}
	}

}
