package com.cerner.patient.service;

import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.exception.PatientBusinessException;
import com.cerner.patient.response.GenericApiResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface DeletePatientService.
 * @author Aniket
 * @version 0.1
 * @since 2023
 */
public interface DeletePatientService {

	/**
	 * Delete patient.
	 *
	 * @param patientId the patient id
	 * @return the generic api response
	 * @throws PatientBusinessException the patient business exception
	 */
	GenericApiResponse<PatientResponseDTO> deletePatient(Long patientId)throws PatientBusinessException;

}
