/**
 * 
 */
package com.sample.application.parkinglot.handler;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author sidonepudi
 *
 */
public class FileInputHandlerTest {
	@Test
	public void testGetInstance() {
		Assert.assertNotNull(FileInputHandler.INSTANCE);
		int hashValue = FileInputHandler.INSTANCE.hashCode();
		Assert.assertEquals(hashValue, FileInputHandler.INSTANCE.hashCode());
	}

}
