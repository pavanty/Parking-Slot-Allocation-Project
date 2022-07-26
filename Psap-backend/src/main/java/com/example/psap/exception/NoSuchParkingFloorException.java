package com.example.psap.exception;

public class NoSuchParkingFloorException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchParkingFloorException(String message) {
		super(message);
	}
}
