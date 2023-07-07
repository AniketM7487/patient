package com.cerner.patient.service;

import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;

public interface UpdatePatientService {

	PatientResponseDTO updatePatient(Long patientId, PatientRequestDTO patientRequestDTO);

}
