package com.example.psap.exception;

public class NoSuchParkingPremiseException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchParkingPremiseException(String message) {
		super(message);
	}
}
