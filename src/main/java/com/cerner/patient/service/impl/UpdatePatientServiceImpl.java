package com.cerner.patient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.entity.Patient;
import com.cerner.patient.exception.PatientBusinessException;
import com.cerner.patient.exception.PatientNotFoundException;
import com.cerner.patient.mapper.ValueMapper;
import com.cerner.patient.repository.PatientRepository;
import com.cerner.patient.service.UpdatePatientService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UpdatePatientServiceImpl implements UpdatePatientService {
	
	@Autowired
	private PatientRepository patientRepository;


	public PatientResponseDTO updatePatient(Long patientId, PatientRequestDTO patientRequestDTO) {
		PatientResponseDTO patientResponseDTO = null;
		try {
			
            log.info("PatientService:updatePatient execution started.");
            Patient patient = patientRepository.findById(patientId)
            		.orElseThrow(() -> new PatientNotFoundException("Patient not found with id " + patientId));

            patient = ValueMapper.updateEntity(patient,patientRequestDTO);
            Patient patientResults = patientRepository.save(patient);
            patientResponseDTO=ValueMapper.convertToDTO(patientResults);
            log.debug("PatientService:updatePatient retrieving patient from database  {}", ValueMapper.jsonAsString(patientResponseDTO));

        } catch (Exception ex) {
            log.error("Exception occurred while retrieving patient from database , Exception message {}", ex.getMessage());
            throw new PatientBusinessException("Exception occurred while fetch patient from Database");
        }

        log.info("PatientService:updatePatient execution ended.");
        return patientResponseDTO;
	}
}
