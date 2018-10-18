/**
 * 
 */
package com.sample.application.parkinglot.handler;

import org.junit.Assert;
import org.junit.Test;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * @author sidonepudi
 *
 */
public class CommandHandlerTest {
	@Test
	public void testGetInstance() {
		Assert.assertNotNull(CommandHandler.INSTANCE);
	}

	@Test
	public void testExecute() {
		try {
			CommandHandler.INSTANCE.execute("create_parking_lot 6");
			CommandHandler.INSTANCE.execute("park KA-01-HH-1234 White");
			CommandHandler.INSTANCE.execute("park KA-01-HH-9999 White");
			CommandHandler.INSTANCE.execute("park KA-01-BB-0001 Black");
			CommandHandler.INSTANCE.execute("park KA-01-HH-7777 Red");
			CommandHandler.INSTANCE.execute("park KA-01-HH-2701 Blue");
			CommandHandler.INSTANCE.execute("park KA-01-HH-3141 Black");
			CommandHandler.INSTANCE.execute("leave 4");
			CommandHandler.INSTANCE.execute("status");
			CommandHandler.INSTANCE.execute("park KA-01-P-333 White");
			try {
				CommandHandler.INSTANCE.execute("park DL-12-AA-9999 White");
			} catch (InvalidInputException e) {
			}
			CommandHandler.INSTANCE.execute("registration_numbers_for_cars_with_colour White");
			CommandHandler.INSTANCE.execute("slot_numbers_for_cars_with_colour White");
			CommandHandler.INSTANCE.execute("slot_number_for_registration_number KA-01-HH-3141");
			CommandHandler.INSTANCE.execute("slot_number_for_registration_number MH-04-AY-1111");

		} catch (InvalidInputException e) {
			Assert.fail();
		}
	}

	@Test(expected = InvalidInputException.class)
	public void testExecuteException() throws InvalidInputException {
		CommandHandler.INSTANCE.execute("park KA-01-HH-1234 White");
		CommandHandler.INSTANCE.execute("leave 4");
		CommandHandler.INSTANCE.execute("abcd");
	}

}
