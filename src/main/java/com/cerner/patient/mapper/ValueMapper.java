package com.cerner.patient.mapper;

import java.time.LocalDate;

import com.cerner.patient.dto.AddressDTO;
import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.entity.Address;
import com.cerner.patient.entity.Patient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValueMapper {

	public static String jsonAsString(Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

	public static Patient convertToEntity(PatientRequestDTO patientRequestDTO) {
		Patient patient=new Patient();
		Address address=new Address();
		patient.setFirstName(patientRequestDTO.getFirstName());
		patient.setLastName(patientRequestDTO.getLastName());
		address.setAddress(patientRequestDTO.getAddress().getAddress());
		address.setCity(patientRequestDTO.getAddress().getCity());
		address.setState(patientRequestDTO.getAddress().getState());
		address.setPinCode(patientRequestDTO.getAddress().getPinCode());
		patient.setAddress(address);
		patient.setDob(LocalDate.parse(patientRequestDTO.getDob()));
		patient.setGender(patientRequestDTO.getGender());
		patient.setMobileNumber(patientRequestDTO.getMobileNumber());
		return patient;
	}

	public static PatientResponseDTO convertToDTO(Patient patientResults) {
		PatientResponseDTO patient=new PatientResponseDTO();
		AddressDTO address=new AddressDTO();
		patient.setKey(patientResults.getKey());
		patient.setFirstName(patientResults.getFirstName());
		patient.setLastName(patientResults.getLastName());
		address.setAddress(patientResults.getAddress().getAddress());
		address.setCity(patientResults.getAddress().getCity());
		address.setState(patientResults.getAddress().getState());
		address.setPinCode(patientResults.getAddress().getPinCode());
		patient.setAddress(address);
		patient.setDob(patientResults.getDob().toString());
		patient.setGender(patientResults.getGender());
		patient.setMobileNumber(patientResults.getMobileNumber());
		return patient;
	}
	
	public static Patient updateEntity(Patient patient,PatientRequestDTO patientRequestDTO) {
		Address address=patient.getAddress();
		patient.setFirstName(patientRequestDTO.getFirstName());
		patient.setLastName(patientRequestDTO.getLastName());
		address.setAddress(patientRequestDTO.getAddress().getAddress());
		address.setCity(patientRequestDTO.getAddress().getCity());
		address.setState(patientRequestDTO.getAddress().getState());
		address.setPinCode(patientRequestDTO.getAddress().getPinCode());
		patient.setAddress(address);
		patient.setDob(LocalDate.parse(patientRequestDTO.getDob()));
		patient.setGender(patientRequestDTO.getGender());
		patient.setMobileNumber(patientRequestDTO.getMobileNumber());
		return patient;
	}
}
