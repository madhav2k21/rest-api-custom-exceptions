package com.techleads.app.exceptions;

public class MemberNumberInvalidException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MemberNumberInvalidException() {
		super();
	}

	public MemberNumberInvalidException(String message) {
		super(message);
	}

}
