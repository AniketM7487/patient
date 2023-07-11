package com.cerner.patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientNotFoundException.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PatientNotFoundException extends RuntimeException{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new patient not found exception.
	 *
	 * @param msg the msg
	 */
	public PatientNotFoundException(String msg) {
		super(msg);
	}
}
