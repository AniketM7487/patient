package com.cerner.patient.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/**
 * Instantiates a new error response.
 *
 * @param statusCode the status code
 * @param timestamp the timestamp
 * @param message the message
 * @param description the description
 */
@AllArgsConstructor

/**
 * Instantiates a new error response.
 */
@NoArgsConstructor
public class ErrorResponse {

	/** The status code. */
	private int statusCode;
	
	/** The timestamp. */
	private Date timestamp;
	
	/** The message. */
	private String message;
	
	/** The description. */
	private String description;
	
}
