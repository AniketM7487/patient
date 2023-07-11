package com.cerner.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.mapper.ValueMapper;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.DeletePatientService;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class DeletePatientController used to delete patient
 * @author Aniket
 * @version 0.1
 * @since 2023
 */
@RestController
@RequestMapping("/api/v1/patient")

/** The Constant log. */
@Slf4j
public class DeletePatientController {
	
	/** The patient service. */
	@Autowired
	private DeletePatientService patientService;
	
	/**
	 * Delete patient.
	 *
	 * @param patientId the patient id
	 * @return the response entity
	 */
	@DeleteMapping("/{patientId}")
	public ResponseEntity<GenericApiResponse> deletePatient(@PathVariable Long patientId) {
		log.info("PatientController::deletePatient by id  {}", patientId);
		GenericApiResponse<PatientResponseDTO> responseDTO=patientService.deletePatient(patientId);

        log.info("PatientController::deletePatient response {}", ValueMapper.jsonAsString(responseDTO));

        return new ResponseEntity<>(responseDTO,HttpStatus.NO_CONTENT);
	}
	

}
