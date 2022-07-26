package com.example.psap.exception;

public class NoSuchParkingSlotException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchParkingSlotException(String message) {
		super(message);
	}
}
