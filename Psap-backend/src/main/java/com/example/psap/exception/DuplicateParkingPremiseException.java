package com.example.psap.exception;

public class DuplicateParkingPremiseException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateParkingPremiseException(String message) {
		super(message);
	}
}
