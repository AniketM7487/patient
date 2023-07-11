package com.cerner.patient.service;

import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.exception.PatientBusinessException;
import com.cerner.patient.response.GenericApiResponse;

public interface DeletePatientService {

	GenericApiResponse<PatientResponseDTO> deletePatient(Long patientId)throws PatientBusinessException;

}
