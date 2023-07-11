package com.cerner.patient.service;

import java.util.List;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.exception.PatientBusinessException;
import com.cerner.patient.response.GenericApiResponse;

public interface GetPatientService {

	GenericApiResponse<List<PatientResponseDTO>> getPatients()throws PatientBusinessException;

	GenericApiResponse<PatientResponseDTO> getPatientById(Long patientId)throws PatientBusinessException;

}
