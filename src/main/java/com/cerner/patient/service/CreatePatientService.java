package com.cerner.patient.service;

import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.exception.PatientBusinessException;
import com.cerner.patient.response.GenericApiResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface CreatePatientService.
 * @author Aniket
 * @version 0.1
 * @since 2023
 */
public interface CreatePatientService {

	/**
	 * Adds the patient.
	 *
	 * @param patientRequestDTO the patient request DTO
	 * @return the generic api response
	 * @throws PatientBusinessException the patient business exception
	 */
	GenericApiResponse<PatientResponseDTO> addPatient(PatientRequestDTO patientRequestDTO) throws PatientBusinessException;

}
