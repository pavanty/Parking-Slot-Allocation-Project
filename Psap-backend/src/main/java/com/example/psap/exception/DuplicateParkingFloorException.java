package com.example.psap.exception;

public class DuplicateParkingFloorException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateParkingFloorException(String message) {
		super(message);
	}
}
