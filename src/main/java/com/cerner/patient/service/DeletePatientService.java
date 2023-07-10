package com.cerner.patient.service;

import org.springframework.http.ResponseEntity;

import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.response.GenericApiResponse;

public interface DeletePatientService {

	GenericApiResponse<PatientResponseDTO> deletePatient(Long patientId);

}
