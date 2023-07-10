package com.cerner.patient.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
