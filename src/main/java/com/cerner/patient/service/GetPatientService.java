package com.cerner.patient.service;

import java.util.List;

import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.response.GenericApiResponse;

public interface GetPatientService {

	GenericApiResponse<List<PatientResponseDTO>> getPatients();

	GenericApiResponse<PatientResponseDTO> getPatientById(Long patientId);

}
