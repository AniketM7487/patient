package com.cerner.patient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerner.patient.entity.Patient;
import com.cerner.patient.exception.PatientBusinessException;
import com.cerner.patient.exception.PatientNotFoundException;
import com.cerner.patient.repository.PatientRepository;
import com.cerner.patient.service.DeletePatientService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeletePatientServiceImpl implements DeletePatientService {
	
	@Autowired
	private PatientRepository patientRepository;

	public void deletePatient(Long patientId) {
		try {
			
            log.info("PatientService:deletePatient execution started.");
            Patient patient = patientRepository.findById(patientId)
            		.orElseThrow(() -> new PatientNotFoundException("Patient not found with id " + patientId));

            patientRepository.delete(patient);
            log.debug("PatientService:deletePatient deleting patient from database  {}",+patientId);

        } catch (Exception ex) {
            log.error("Exception occurred while deleting patient from database , Exception message {}", ex.getMessage());
            throw new PatientBusinessException("Exception occurred while delete patient from Database");
        }

        log.info("PatientService:deletePatient execution ended.");
		
	}

}
