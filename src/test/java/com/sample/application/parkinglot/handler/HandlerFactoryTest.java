package com.sample.application.parkinglot.handler;

import org.junit.Assert;
import org.junit.Test;

import com.sample.application.parkinglot.Command;
import com.sample.application.parkinglot.exceptions.InvalidInputException;
import com.sample.application.parkinglot.handler.CommandHandler;
import com.sample.application.parkinglot.handler.FileInputHandler;
import com.sample.application.parkinglot.handler.HandlerFactory;

public class HandlerFactoryTest {

	@Test
	public void testCreateInputHandler() {
		HandlerFactory factory = HandlerFactory.getInstance();
		try {
			Assert.assertNotNull(factory);
			Assert.assertEquals(FileInputHandler.class, factory.createInputHandler("file_inputs.txt").getClass());
			Assert.assertEquals(CommandHandler.class,
					factory.createInputHandler(Command.CRAEATE_PARKING_LOT.getValue()).getClass());
			Assert.assertEquals(CommandHandler.class,
					factory.createInputHandler(Command.LEAVE.getValue()).getClass());
			Assert.assertEquals(CommandHandler.class,
					factory.createInputHandler(Command.STATUS.getValue()).getClass());
			Assert.assertEquals(CommandHandler.class,
					factory.createInputHandler(Command.PARK.getValue()).getClass());
			Assert.assertEquals(CommandHandler.class,
					factory.createInputHandler(Command.REGISTRATION_NUMBERS_WITH_COLOR.getValue()).getClass());
			Assert.assertEquals(CommandHandler.class,
					factory.createInputHandler(Command.SLOT_NUMBERS_WITH_COLOR.getValue()).getClass());
			Assert.assertEquals(CommandHandler.class,
					factory.createInputHandler(Command.SLOT_NUMBER_FOR_REGISTRATION_NUMBER.getValue()).getClass());

		} catch (InvalidInputException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

}
