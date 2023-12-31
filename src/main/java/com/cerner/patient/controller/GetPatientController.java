package com.cerner.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.mapper.ValueMapper;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.GetPatientService;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class GetPatientController used to get Patient Details
 * @author Aniket
 * @version 0.1
 * @since 2023
 */
@RestController
@RequestMapping("/api/v1/patient")

/** The Constant log. */
@Slf4j
public class GetPatientController {
	
	/** The patient service. */
	@Autowired
	private GetPatientService patientService;
	
	/**
	 * Gets the patients.
	 *
	 * @return the patients
	 */
	@GetMapping
	public ResponseEntity<GenericApiResponse> getPatients() {
		GenericApiResponse<List<PatientResponseDTO>> responseDTO = patientService.getPatients();

        log.info("PatientController::getPatients response {}", ValueMapper.jsonAsString(responseDTO));

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
	
	/**
	 * Gets the patient by patient ID
	 *
	 * @param patientId the patient id
	 * @return the patient
	 */
	@GetMapping("/{patientId}")
	public ResponseEntity<GenericApiResponse> getPatient(@PathVariable Long patientId) {
		log.info("PatientController::getPatient by id  {}", patientId);
		GenericApiResponse<PatientResponseDTO> patientResponseDTO= patientService.getPatientById(patientId);

        log.info("PatientController::getPatient by id response {}", ValueMapper.jsonAsString(patientResponseDTO));

        return new ResponseEntity<>(patientResponseDTO, HttpStatus.OK);
	}
}
