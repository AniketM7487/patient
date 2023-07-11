package com.cerner.patient.dto;

import javax.validation.constraints.NotBlank;

import com.cerner.patient.Generated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Generated
public class AddressDTO {

	@NotBlank(message = "Address shouldn't be NULL OR EMPTY")
	private String address;
	@NotBlank(message = "City shouldn't be NULL OR EMPTY")
	private String city;
	@NotBlank(message = "State shouldn't be NULL OR EMPTY")
	private String state;
	@NotBlank(message = "Pincode shouldn't be NULL OR EMPTY")
	private String pinCode;
}
