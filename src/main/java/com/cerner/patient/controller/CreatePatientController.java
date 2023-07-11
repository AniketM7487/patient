package com.cerner.patient.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.mapper.ValueMapper;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.CreatePatientService;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class CreatePatientController used to create Patient
 * @author Aniket
 * @version 0.1
 * @since 2023
 */
@RestController
@RequestMapping("/api/v1/patient")

/** The Constant log. */
@Slf4j
public class CreatePatientController {
	
	/** The patient service. */
	@Autowired
	private CreatePatientService patientService;
	
	/**
	 * Adds the patient.
	 *
	 * @param patientRequestDTO the patient request DTO
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<GenericApiResponse> addPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO) {
		log.info("PatientController::addPatient request body {}", ValueMapper.jsonAsString(patientRequestDTO));
		GenericApiResponse<PatientResponseDTO> patientResponseDTO=patientService.addPatient(patientRequestDTO);

        log.info("PatientController::addPatient response {}", ValueMapper.jsonAsString(patientResponseDTO));

        return new ResponseEntity<>(patientResponseDTO, HttpStatus.CREATED);
	}
}
