package com.cerner.patient.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.entity.Patient;
import com.cerner.patient.exception.PatientBusinessException;
import com.cerner.patient.exception.PatientNotFoundException;
import com.cerner.patient.mapper.ValueMapper;
import com.cerner.patient.repository.PatientRepository;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.GetPatientService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GetPatientServiceImpl implements GetPatientService {
	
	@Autowired
	private PatientRepository patientRepository;

	public List<PatientResponseDTO> getPatients() {
		List<PatientResponseDTO> patientResponseDTOS = null;

        try {
            log.info("PatientService:getPatients execution started.");

            List<Patient> patientList = patientRepository.findAll();

            if (!patientList.isEmpty()) {
            	patientResponseDTOS = patientList.stream()
                        .map(ValueMapper::convertToDTO)
                        .collect(Collectors.toList());
            } else {
            	patientResponseDTOS = Collections.emptyList();
            }

            log.debug("PatientService:getPatients retrieving patients from database  {}", ValueMapper.jsonAsString(patientResponseDTOS));

        } catch (Exception ex) {
            log.error("Exception occurred while retrieving patients from database , Exception message {}", ex.getMessage());
            throw new PatientBusinessException("Exception occurred while fetch all patients from Database");
        }

        log.info("PatientService:getPatients execution ended.");
        return patientResponseDTOS;
		
	}
	
	public PatientResponseDTO getPatientById(Long patientId) {
		PatientResponseDTO patientResponseDTO = null;

        try {
            log.info("PatientService:getPatientById execution started.");

            Patient patient = patientRepository.findById(patientId)
            		.orElseThrow(() -> new PatientNotFoundException("Patient not found with id " + patientId));
            patientResponseDTO=ValueMapper.convertToDTO(patient);
           
            log.debug("PatientService:getPatientById retrieving patient from database  {}", ValueMapper.jsonAsString(patientResponseDTO));

        } catch (Exception ex) {
            log.error("Exception occurred while retrieving patient from database , Exception message {}", ex.getMessage());
            throw new PatientBusinessException("Exception occurred while fetch patient from Database");
        }

        log.info("PatientService:getPatientById execution ended.");
        return patientResponseDTO;
	}
}
