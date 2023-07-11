package com.cerner.patient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.entity.Patient;
import com.cerner.patient.exception.PatientBusinessException;
import com.cerner.patient.exception.PatientExistException;
import com.cerner.patient.mapper.CommonService;
import com.cerner.patient.mapper.ValueMapper;
import com.cerner.patient.repository.PatientRepository;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.CreatePatientService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CreatePatientServiceImpl implements CreatePatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private CommonService commonService;

	public GenericApiResponse<PatientResponseDTO> addPatient(PatientRequestDTO patientRequestDTO)
			throws PatientBusinessException {
		GenericApiResponse<PatientResponseDTO> patientResponse;
		PatientResponseDTO patientResponseDTO = null;
		log.info("PatientService:addPatient execution started.");
		if (commonService.isDuplicate(patientRequestDTO)) {
			throw new PatientExistException("Exception occurred while add a new Patient. Patient already exits.");
		} else {

			Patient patient = ValueMapper.convertToEntity(patientRequestDTO);
			log.debug("PatientService:addPatient request parameters {}", ValueMapper.jsonAsString(patientRequestDTO));

			Patient patientResults = patientRepository.save(patient);
			patientResponseDTO = ValueMapper.convertToDTO(patientResults);
			patientResponse = CommonService.buildResponse(patientResponseDTO);
			log.debug("PatientService:addPatient received response from Database {}",
					ValueMapper.jsonAsString(patientRequestDTO));

		}
		log.info("PatientService:addPatient execution ended.");
		return patientResponse;
	}
}
