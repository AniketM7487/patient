package com.cerner.patient.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
 * Instantiates a new patient request DTO.
 *
 * @param firstName the first name
 * @param lastName the last name
 * @param address the address
 * @param dob the dob
 * @param gender the gender
 * @param mobileNumber the mobile number
 */
@AllArgsConstructor

/**
 * Instantiates a new patient request DTO.
 */
@NoArgsConstructor

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Builder
public class PatientRequestDTO {
	
	/** The first name. */
	@NotBlank(message = "First name shouldn't be NULL OR EMPTY")
	private String firstName;
	
	/** The last name. */
	@NotBlank(message = "Last name shouldn't be NULL OR EMPTY")
	private String lastName;
	
	/** The address. */
	@Valid
	private AddressDTO address;
	
	/** The dob. */
	@NotBlank(message = "Date of Birth shouldn't be NULL OR EMPTY")
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Invalid date format. The expected format is yyyy-MM-dd")
	private String dob;
	
	/** The gender. */
	@NotBlank(message = "Gender shouldn't be NULL OR EMPTY")
	private String gender;
	
	/** The mobile number. */
	@NotBlank(message = "Mobile Number shouldn't be NULL OR EMPTY")
	@Size(min = 12, max = 12, message = "Mobile number is invalid ")
	private String mobileNumber;

}
