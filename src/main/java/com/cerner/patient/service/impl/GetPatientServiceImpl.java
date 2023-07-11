package com.cerner.patient.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.entity.Patient;
import com.cerner.patient.exception.PatientBusinessException;
import com.cerner.patient.exception.PatientNotFoundException;
import com.cerner.patient.mapper.CommonService;
import com.cerner.patient.mapper.ValueMapper;
import com.cerner.patient.repository.PatientRepository;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.GetPatientService;
import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class GetPatientServiceImpl.
 * @author Aniket
 * @version 0.1
 * @since 2023
 */
@Service

/** The Constant log. */
@Slf4j
public class GetPatientServiceImpl implements GetPatientService {
	
	/** The patient repository. */
	@Autowired
	private PatientRepository patientRepository;

	/* (non-Javadoc)
	 * @see com.cerner.patient.service.GetPatientService#getPatients()
	 */
	public GenericApiResponse<List<PatientResponseDTO>> getPatients() throws PatientBusinessException {
		List<PatientResponseDTO> patientResponseDTOS = null;
		GenericApiResponse<List<PatientResponseDTO>> patientResponse = null;
		log.info("PatientService:getPatients execution started.");

		List<Patient> patientList = patientRepository.findAll();

		if (!patientList.isEmpty()) {
			patientResponseDTOS = patientList.stream().map(ValueMapper::convertToDTO).collect(Collectors.toList());
		} else {
			patientResponseDTOS = Collections.emptyList();
		}
		patientResponse = CommonService.buildResponseForList(patientResponseDTOS);
		log.debug("PatientService:getPatients retrieving patients from database  {}",
				ValueMapper.jsonAsString(patientResponse));

		log.info("PatientService:getPatients execution ended.");
		return patientResponse;

	}
	
	/* (non-Javadoc)
	 * @see com.cerner.patient.service.GetPatientService#getPatientById(java.lang.Long)
	 */
	public GenericApiResponse<PatientResponseDTO> getPatientById(Long patientId) throws PatientBusinessException {
		GenericApiResponse<PatientResponseDTO> patientResponse = null;

		log.info("PatientService:getPatientById execution started.");

		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found with id " + patientId));
		PatientResponseDTO patientResponseDTO = ValueMapper.convertToDTO(patient);
		patientResponse = CommonService.buildResponse(patientResponseDTO);
		log.debug("PatientService:getPatientById retrieving patient from database  {}",
				ValueMapper.jsonAsString(patientResponse));

		log.info("PatientService:getPatientById execution ended.");
		return patientResponse;
	}
}
