package com.cerner.patient.service;

import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.exception.PatientBusinessException;
import com.cerner.patient.response.GenericApiResponse;

public interface UpdatePatientService {

	GenericApiResponse<PatientResponseDTO> updatePatient(Long patientId, PatientRequestDTO patientRequestDTO)throws PatientBusinessException;

}
