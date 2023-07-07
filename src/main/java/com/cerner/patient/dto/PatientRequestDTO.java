package com.cerner.patient.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PatientRequestDTO {
	
	private String firstName;
	private String lastName;
	private AddressDTO address;
	private Date dob;
	private Character gender;
	private String mobileNumber;

}
