package com.cerner.patient.service;

import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.exception.PatientBusinessException;
import com.cerner.patient.response.GenericApiResponse;

public interface CreatePatientService {

	GenericApiResponse<PatientResponseDTO> addPatient(PatientRequestDTO patientRequestDTO) throws PatientBusinessException;

}
