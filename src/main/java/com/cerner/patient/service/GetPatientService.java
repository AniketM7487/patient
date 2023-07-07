package com.cerner.patient.service;

import java.util.List;

import com.cerner.patient.dto.PatientResponseDTO;

public interface GetPatientService {

	List<PatientResponseDTO> getPatients();

	PatientResponseDTO getPatientById(Long patientId);

}
