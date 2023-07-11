package com.cerner.patient.service;

import java.util.List;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.exception.PatientBusinessException;
import com.cerner.patient.response.GenericApiResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface GetPatientService.
 * @author Aniket
 * @version 0.1
 * @since 2023
 */
public interface GetPatientService {

	/**
	 * Gets the patients.
	 *
	 * @return the patients
	 * @throws PatientBusinessException the patient business exception
	 */
	GenericApiResponse<List<PatientResponseDTO>> getPatients()throws PatientBusinessException;

	/**
	 * Gets the patient by id.
	 *
	 * @param patientId the patient id
	 * @return the patient by id
	 * @throws PatientBusinessException the patient business exception
	 */
	GenericApiResponse<PatientResponseDTO> getPatientById(Long patientId)throws PatientBusinessException;

}
