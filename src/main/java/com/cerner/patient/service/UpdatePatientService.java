package com.cerner.patient.service;

import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.exception.PatientBusinessException;
import com.cerner.patient.response.GenericApiResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface UpdatePatientService.
 * @author Aniket
 * @version 0.1
 * @since 2023
 */
public interface UpdatePatientService {

	/**
	 * Update patient.
	 *
	 * @param patientId the patient id
	 * @param patientRequestDTO the patient request DTO
	 * @return the generic api response
	 * @throws PatientBusinessException the patient business exception
	 */
	GenericApiResponse<PatientResponseDTO> updatePatient(Long patientId, PatientRequestDTO patientRequestDTO)throws PatientBusinessException;

}
