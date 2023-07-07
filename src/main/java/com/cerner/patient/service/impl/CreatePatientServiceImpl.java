package com.cerner.patient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.entity.Patient;
import com.cerner.patient.exception.PatientBusinessException;
import com.cerner.patient.mapper.ValueMapper;
import com.cerner.patient.repository.PatientRepository;
import com.cerner.patient.service.CreatePatientService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CreatePatientServiceImpl implements CreatePatientService{
	
	@Autowired
	private PatientRepository patientRepository;

	
	public PatientResponseDTO addPatient(PatientRequestDTO patientRequestDTO) {
		PatientResponseDTO patientResponseDTO;
		try {
            log.info("PatientService:addPatient execution started.");
            Patient patient = ValueMapper.convertToEntity(patientRequestDTO);
            log.debug("PatientService:addPatient request parameters {}", ValueMapper.jsonAsString(patientRequestDTO));

            Patient patientResults = patientRepository.save(patient);
            patientResponseDTO = ValueMapper.convertToDTO(patientResults);
            log.debug("PatientService:addPatient received response from Database {}", ValueMapper.jsonAsString(patientRequestDTO));

        } catch (Exception ex) {
            log.error("Exception occurred while persisting Patient to database , Exception message {}", ex.getMessage());
            throw new PatientBusinessException("Exception occurred while add a new Patient");
        }
        log.info("PatientService:addPatient execution ended.");
        return patientResponseDTO;
	}
}
