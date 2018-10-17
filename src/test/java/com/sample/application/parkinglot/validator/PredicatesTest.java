/**
 * 
 */
package com.sample.application.parkinglot.validator;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author sidonepudi
 *
 */
public class PredicatesTest {
	@Test
	public void testPredicates() {
		Assert.assertEquals(true, Predicates.EMPTY_CHECK.test(null));
		Assert.assertEquals(true, Predicates.EMPTY_CHECK.test(""));
		Assert.assertEquals(true, Predicates.CREATE_PARKING_LOT_CHECK.test("create_parking_lot"));
		Assert.assertEquals(true, Predicates.REGISTRATION_NUMBERS_WITH_COLOR_CHECK
				.test("registration_numbers_for_cars_with_colour"));
		Assert.assertEquals(true, Predicates.LEAVE_CHECK.test("leave"));
		Assert.assertEquals(true, Predicates.PARK_CHECK.test("park"));
		Assert.assertEquals(true,
				Predicates.SLOT_NUMBERS_WITH_COLOR_CHECK.test("slot_numbers_for_cars_with_colour"));
		Assert.assertEquals(true, Predicates.SLOT_NUMBER_FOR_REGISTRATION_NUMBER_CHECK
				.test("slot_number_for_registration_number"));
		Assert.assertEquals(true, Predicates.FILE_INPUT_CHECK.test("file_input.txt"));

	}

}
