package com.cerner.patient.service;

import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;

public interface CreatePatientService {

	PatientResponseDTO addPatient(PatientRequestDTO patientRequestDTO);

}
