package com.cerner.patient.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cerner.patient.entity.Patient;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.PatientService;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping
	public ResponseEntity<GenericApiResponse<Patient>> getPatients() {
		return new ResponseEntity<>(patientService.getPatients(),HttpStatus.OK);
	}
	

}
