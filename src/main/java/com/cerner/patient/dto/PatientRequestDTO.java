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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequestDTO {
	
	@NotBlank(message = "First name shouldn't be NULL OR EMPTY")
	private String firstName;
	
	@NotBlank(message = "Last name shouldn't be NULL OR EMPTY")
	private String lastName;
	
	@Valid
	private AddressDTO address;
	
	@NotBlank(message = "Date of Birth shouldn't be NULL OR EMPTY")
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Invalid date format. The expected format is yyyy-MM-dd")
	private String dob;
	
	@NotBlank(message = "Gender shouldn't be NULL OR EMPTY")
	private String gender;
	
	@NotBlank(message = "Mobile Number shouldn't be NULL OR EMPTY")
	@Size(min = 12, max = 12, message = "Mobile number is invalid ")
	private String mobileNumber;

}
