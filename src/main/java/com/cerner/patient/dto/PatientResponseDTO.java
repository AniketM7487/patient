package com.cerner.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/**
 * Instantiates a new patient response DTO.
 *
 * @param key the key
 * @param firstName the first name
 * @param lastName the last name
 * @param address the address
 * @param dob the dob
 * @param gender the gender
 * @param mobileNumber the mobile number
 */
@AllArgsConstructor

/**
 * Instantiates a new patient response DTO.
 */
@NoArgsConstructor

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Builder
public class PatientResponseDTO {
	
	/** The key. */
	private Long key;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The address. */
	private AddressDTO address;
	
	/** The dob. */
	private String dob;
	
	/** The gender. */
	private String gender;
	
	/** The mobile number. */
	private String mobileNumber;

}
