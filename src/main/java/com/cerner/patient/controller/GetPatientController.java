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

@RestController
@RequestMapping("/api/v1/patient")
@Slf4j
public class GetPatientController {
	
	@Autowired
	private GetPatientService patientService;
	
	@GetMapping
	public ResponseEntity<GenericApiResponse> getPatients() {
		List<PatientResponseDTO> patients = patientService.getPatients();
        //Builder Design pattern (to avoid complex object creation headache)
		GenericApiResponse<List<PatientResponseDTO>> responseDTO = GenericApiResponse
                .<List<PatientResponseDTO>>builder()
                .status("SUCCESS")
                .data(patients)
                .build();

        log.info("PatientController::getPatients response {}", ValueMapper.jsonAsString(responseDTO));

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
	
	@GetMapping("/{patientId}")
	public ResponseEntity<GenericApiResponse> getPatient(@PathVariable Long patientId) {
		log.info("PatientController::getPatient by id  {}", patientId);
		PatientResponseDTO patient = patientService.getPatientById(patientId);
		GenericApiResponse<PatientResponseDTO> responseDTO = GenericApiResponse
                .<PatientResponseDTO>builder()
                .status("SUCCESS")
                .data(patient)
                .build();

        log.info("PatientController::getPatients response {}", ValueMapper.jsonAsString(responseDTO));

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
}
