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

@RestController
@RequestMapping("/api/v1/patient")
@Slf4j
public class DeletePatientController {
	
	@Autowired
	private DeletePatientService patientService;
	
	@DeleteMapping("/{patientId}")
	public ResponseEntity<GenericApiResponse> deletePatient(@PathVariable Long patientId) {
		log.info("PatientController::deletePatient by id  {}", patientId);
		patientService.deletePatient(patientId);
		GenericApiResponse<PatientResponseDTO> responseDTO = GenericApiResponse
                .<PatientResponseDTO>builder()
                .status("SUCCESS")
                .data(null)
                .build();

        log.info("PatientController::deletePatient response {}", ValueMapper.jsonAsString(responseDTO));

        return new ResponseEntity<>(responseDTO,HttpStatus.NO_CONTENT);
	}
	

}