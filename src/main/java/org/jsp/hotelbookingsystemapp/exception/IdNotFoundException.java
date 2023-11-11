package org.jsp.hotelbookingsystemapp.exception;

public class IdNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "The Id Is Invaid";
	}

}
