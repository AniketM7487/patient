package com.cerner.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponseDTO {
	
	private Long key;
	private String firstName;
	private String lastName;
	private AddressDTO address;
	private String dob;
	private String gender;
	private String mobileNumber;

}
