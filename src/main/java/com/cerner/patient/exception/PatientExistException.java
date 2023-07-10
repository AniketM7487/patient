package com.cerner.patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class PatientExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PatientExistException(String msg) {
		super(msg);
	}
}
