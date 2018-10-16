package com.sample.application.parkinglot;

import org.junit.Assert;
import org.junit.Test;

import com.sample.application.parkinglot.exceptions.InvalidInputException;
import com.sample.application.parkinglot.handler.CommandInputHandler;
import com.sample.application.parkinglot.handler.FileInputHandler;
import com.sample.application.parkinglot.handler.InputHandlerFactory;

public class InputHandlerFactoryTest {

	@Test
	public void testCreateInputHandler() {
		InputHandlerFactory factory = new InputHandlerFactory();
		try {
			Assert.assertEquals(FileInputHandler.class, factory.createInputHandler("inputFile.txt").getClass());
			Assert.assertEquals(CommandInputHandler.class,
					factory.createInputHandler(Commands.CRAEATE_PARKING_LOT.getValue()).getClass());
			Assert.assertEquals(CommandInputHandler.class,
					factory.createInputHandler(Commands.REGISTRATION_NUMBERS_WITH_COLOR.getValue()).getClass());
			Assert.assertEquals(CommandInputHandler.class,
					factory.createInputHandler(Commands.SLOT_NUMBERS_WITH_COLOR.getValue()).getClass());
			Assert.assertEquals(CommandInputHandler.class, factory.createInputHandler(Commands.LEAVE.getValue()).getClass());
			Assert.assertEquals(CommandInputHandler.class,
					factory.createInputHandler(Commands.STATUS.getValue()).getClass());

		} catch (InvalidInputException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

}
