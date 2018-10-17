/**
 * 
 */
package com.sample.application.parkinglot.exceptions;

/**
 * Application exception
 * 
 * @author sidonepudi
 *
 */
public class InvalidInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6364883025245634053L;

	public InvalidInputException() {
		super();
	}

	public InvalidInputException(String info) {
		super(info);
	}
}
