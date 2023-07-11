package com.cerner.patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientExistException.
 */
@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class PatientExistException extends RuntimeException{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new patient exist exception.
	 *
	 * @param msg the msg
	 */
	public PatientExistException(String msg) {
		super(msg);
	}
}
