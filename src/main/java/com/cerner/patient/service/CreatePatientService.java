package com.cerner.patient.service;

import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.exception.PatientExistException;
import com.cerner.patient.response.GenericApiResponse;

public interface CreatePatientService {

	GenericApiResponse<PatientResponseDTO> addPatient(PatientRequestDTO patientRequestDTO);

}
