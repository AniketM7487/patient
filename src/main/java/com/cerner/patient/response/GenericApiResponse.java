package com.cerner.patient.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/**
 * Instantiates a new generic api response.
 *
 * @param status the status
 * @param error the error
 * @param message the message
 * @param data the data
 */
@AllArgsConstructor

/**
 * Instantiates a new generic api response.
 */
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Builder
public class GenericApiResponse<T> {

	/** The status. */
	private String status;
    
    /** The error. */
    private List<ErrorResponse> error;
    
    /** The message. */
    private String message;
    
    /** The data. */
    private T data;
    
}
