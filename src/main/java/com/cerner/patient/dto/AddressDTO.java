package com.cerner.patient.dto;

import javax.validation.constraints.NotBlank;

import com.cerner.patient.Generated;

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
 * Instantiates a new address DTO.
 *
 * @param address the address
 * @param city the city
 * @param state the state
 * @param pinCode the pin code
 */
@AllArgsConstructor

/**
 * Instantiates a new address DTO.
 */
@NoArgsConstructor

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Builder
@Generated
public class AddressDTO {

	/** The address. */
	@NotBlank(message = "Address shouldn't be NULL OR EMPTY")
	private String address;
	
	/** The city. */
	@NotBlank(message = "City shouldn't be NULL OR EMPTY")
	private String city;
	
	/** The state. */
	@NotBlank(message = "State shouldn't be NULL OR EMPTY")
	private String state;
	
	/** The pin code. */
	@NotBlank(message = "Pincode shouldn't be NULL OR EMPTY")
	private String pinCode;
}
