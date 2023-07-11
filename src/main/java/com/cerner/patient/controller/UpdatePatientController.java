package com.cerner.patient.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.mapper.ValueMapper;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.UpdatePatientService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/patient")
@Slf4j
public class UpdatePatientController {
	
	@Autowired
	private UpdatePatientService patientService;
	
	@PutMapping("/{patientId}")
	public ResponseEntity<GenericApiResponse> updatePatient(@PathVariable Long patientId,@Valid @RequestBody PatientRequestDTO patientRequestDTO) {
		log.info("PatientController::updatePatient by id  {}", patientId);
		GenericApiResponse<PatientResponseDTO> patientResponseDTO = patientService.updatePatient(patientId,patientRequestDTO);

        log.info("PatientController::updatePatient response {}", ValueMapper.jsonAsString(patientResponseDTO));

        return new ResponseEntity<>(patientResponseDTO, HttpStatus.OK);
	}
	
}
