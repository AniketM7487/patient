package com.cerner.patient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.entity.Patient;
import com.cerner.patient.exception.PatientBusinessException;
import com.cerner.patient.exception.PatientExistException;
import com.cerner.patient.exception.PatientNotFoundException;
import com.cerner.patient.mapper.CommonService;
import com.cerner.patient.mapper.ValueMapper;
import com.cerner.patient.repository.PatientRepository;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.UpdatePatientService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UpdatePatientServiceImpl implements UpdatePatientService {
	
	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private CommonService commonService;

	public GenericApiResponse<PatientResponseDTO> updatePatient(Long patientId, PatientRequestDTO patientRequestDTO)
			throws PatientBusinessException {
		GenericApiResponse<PatientResponseDTO> patientResponse = null;
		PatientResponseDTO patientResponseDTO = null;

		log.info("PatientService:updatePatient execution started.");
		if (commonService.isDuplicate(patientRequestDTO)) {
			throw new PatientExistException("Exception occurred while add a new Patient. Patient already exits.");
		} else {
			Patient patient = patientRepository.findById(patientId)
					.orElseThrow(() -> new PatientNotFoundException("Patient not found with id " + patientId));

			patient = ValueMapper.updateEntity(patient, patientRequestDTO);
			Patient patientResults = patientRepository.save(patient);
			patientResponseDTO = ValueMapper.convertToDTO(patientResults);
		}
		patientResponse = CommonService.buildResponse(patientResponseDTO);
		log.debug("PatientService:updatePatient retrieving patient from database  {}",
				ValueMapper.jsonAsString(patientResponse));

		log.info("PatientService:updatePatient execution ended.");
		return patientResponse;
	}
}
