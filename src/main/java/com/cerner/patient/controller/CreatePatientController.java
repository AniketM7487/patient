package com.cerner.patient.controller;

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

@RestController
@RequestMapping("/api/v1/patient")
@Slf4j
public class CreatePatientController {
	
	@Autowired
	private CreatePatientService patientService;
	
	@PostMapping
	public ResponseEntity<GenericApiResponse> addPatient(@RequestBody PatientRequestDTO patientRequestDTO) {
		log.info("PatientController::addPatient request body {}", ValueMapper.jsonAsString(patientRequestDTO));
		PatientResponseDTO patientResponseDTO=patientService.addPatient(patientRequestDTO);

		GenericApiResponse<PatientResponseDTO> responseDTO = GenericApiResponse
                .<PatientResponseDTO>builder()
                .status("SUCCESS")
                .data(patientResponseDTO)
                .build();

        log.info("PatientController::addPatient response {}", ValueMapper.jsonAsString(responseDTO));

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
	}
}