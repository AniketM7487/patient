package com.cerner.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerner.patient.entity.Patient;
import com.cerner.patient.repository.PatientRepository;
import com.cerner.patient.response.GenericApiResponse;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;

	public GenericApiResponse<Patient> getPatients() {
		List<Patient> patients= patientRepository.findAll();
		if(patients != null) {
			return buildResponse(patients,"SUCCESS","Patient found!");
		}else {
			return buildResponse(patients,"FAILED","Patient Not found!");
		}
		
	}

	private GenericApiResponse<Patient> buildResponse(List<Patient> patients, String status, String message) {
		GenericApiResponse<Patient> response = new GenericApiResponse<Patient>();

		if (patients == null) {
			response.setStatus(status);
			response.setMessage(message);
			return response;
		}

		response.setStatus(status);
		response.setMessage(message);
		response.setData(patients);

		return response;
	}

}
