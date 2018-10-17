/**
 * 
 */
package com.sample.application.parkinglot.validator;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import com.sample.application.parkinglot.exceptions.InvalidInputException;

/**
 * @author sidonepudi
 *
 */
public class ValidatorFactoryTest {
	@Test
	public void testGetValidator() {
		ValidatorFactory factory = ValidatorFactory.getInstance();
		Assert.assertNotNull(factory);
		try {
			Assert.assertEquals(CreateParkinglotValidator.class,
					factory.getValidator("create_parking_lot 6").getClass());
			Assert.assertEquals(ParkValidator.class, factory.getValidator("park KA-01-HH-1234 White").getClass());
			Assert.assertEquals(LeaveValidator.class, factory.getValidator("leave 4").getClass());
			Assert.assertEquals(StatusValidator.class, factory.getValidator("status").getClass());
			Assert.assertEquals(RegistrationNumbersWithColorValidator.class,
					factory.getValidator("registration_numbers_for_cars_with_colour White").getClass());
			Assert.assertEquals(SlotNumberWithColorValidator.class,
					factory.getValidator("slot_numbers_for_cars_with_colour White").getClass());
			Assert.assertEquals(SlotNumbersWithRegistrationNumberValidator.class,
					factory.getValidator("slot_number_for_registration_number MH-04-AY-1111").getClass());
		} catch (InvalidInputException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}
}
