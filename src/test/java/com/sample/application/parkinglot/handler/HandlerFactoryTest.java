package com.sample.application.parkinglot.handler;

import org.junit.Assert;
import org.junit.Test;

import com.sample.application.parkinglot.Commands;
import com.sample.application.parkinglot.exceptions.InvalidInputException;
import com.sample.application.parkinglot.handler.CommandHandler;
import com.sample.application.parkinglot.handler.FileInputHandler;
import com.sample.application.parkinglot.handler.HandlerFactory;

public class HandlerFactoryTest {

	@Test
	public void testCreateInputHandler() {
		HandlerFactory factory = HandlerFactory.getInputHandlerFactory();
		try {
			Assert.assertNotNull(factory);
			Assert.assertEquals(FileInputHandler.class, factory.createInputHandler("file_inputs.txt").getClass());
			Assert.assertEquals(CommandHandler.class,
					factory.createInputHandler(Commands.CRAEATE_PARKING_LOT.getValue()).getClass());
			Assert.assertEquals(CommandHandler.class,
					factory.createInputHandler(Commands.LEAVE.getValue()).getClass());
			Assert.assertEquals(CommandHandler.class,
					factory.createInputHandler(Commands.STATUS.getValue()).getClass());
			Assert.assertEquals(CommandHandler.class,
					factory.createInputHandler(Commands.PARK.getValue()).getClass());
			Assert.assertEquals(CommandHandler.class,
					factory.createInputHandler(Commands.REGISTRATION_NUMBERS_WITH_COLOR.getValue()).getClass());
			Assert.assertEquals(CommandHandler.class,
					factory.createInputHandler(Commands.SLOT_NUMBERS_WITH_COLOR.getValue()).getClass());
			Assert.assertEquals(CommandHandler.class,
					factory.createInputHandler(Commands.SLOT_NUMBER_FOR_REGISTRATION_NUMBER.getValue()).getClass());

		} catch (InvalidInputException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

}
