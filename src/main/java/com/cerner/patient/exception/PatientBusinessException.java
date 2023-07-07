package com.cerner.patient.exception;

public class PatientBusinessException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PatientBusinessException(String msg) {
		super(msg);
	}
}
