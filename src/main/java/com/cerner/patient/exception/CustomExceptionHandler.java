package com.cerner.patient.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.cerner.patient.response.ErrorResponse;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(PatientNotFoundException.class)
	  @ResponseStatus(value = HttpStatus.NOT_FOUND)
	  public ErrorResponse resourceNotFoundException(PatientNotFoundException ex, WebRequest request) {
		ErrorResponse message = new ErrorResponse(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return message;
	  }

}
