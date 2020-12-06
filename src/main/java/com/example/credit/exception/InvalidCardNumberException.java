package com.example.credit.exception;

public class InvalidCardNumberException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3878328332974412703L;

	public InvalidCardNumberException(String exception) {
		super(exception);
	}

}
