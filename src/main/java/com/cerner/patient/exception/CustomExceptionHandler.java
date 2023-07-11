package com.cerner.patient.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import com.cerner.patient.response.ErrorResponse;
import com.cerner.patient.response.GenericApiResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomExceptionHandler.
 */
@RestControllerAdvice
public class CustomExceptionHandler {

	/**
	 * Handle method argument exception.
	 *
	 * @param exception the exception
	 * @return the generic api response
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public GenericApiResponse<?> handleMethodArgumentException(MethodArgumentNotValidException exception) {
		GenericApiResponse<?> serviceResponse = new GenericApiResponse<>();
		List<ErrorResponse> errors = new ArrayList<>();
		exception.getBindingResult().getFieldErrors().forEach(error -> {
			ErrorResponse errorDTO = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(),
					error.getField(), error.getDefaultMessage());
			errors.add(errorDTO);
		});
		serviceResponse.setStatus("FAILED");
		serviceResponse.setError(errors);
		return serviceResponse;
	}

	/**
	 * Resource not found exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the generic api response
	 */
	@ExceptionHandler(PatientNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public GenericApiResponse<?> resourceNotFoundException(PatientNotFoundException ex, WebRequest request) {
		GenericApiResponse<?> response = new GenericApiResponse<>();
		response.setStatus("FAILED");
		response.setError(Collections.singletonList(new ErrorResponse(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(),
				request.getDescription(false))));
		return response;
	}

	/**
	 * Patient exist exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the generic api response
	 */
	@ExceptionHandler(PatientExistException.class)
	@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
	public GenericApiResponse<?> patientExistException(PatientExistException ex, WebRequest request) {
		GenericApiResponse<?> response = new GenericApiResponse<>();
		response.setStatus("FAILED");
		response.setError(Collections.singletonList(new ErrorResponse(HttpStatus.ALREADY_REPORTED.value(), new Date(), ex.getMessage(),
				request.getDescription(false))));

		return response;
	}

	/**
	 * Handle service exception.
	 *
	 * @param exception the exception
	 * @return the generic api response
	 */
	@ExceptionHandler(PatientBusinessException.class)
	public GenericApiResponse<?> handleServiceException(PatientBusinessException exception) {
		GenericApiResponse<?> response = new GenericApiResponse<>();
		response.setStatus("FAILED");
		response.setError(Collections.singletonList(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				new Date(), exception.getMessage(), exception.getMessage())));
		return response;
	}

}
