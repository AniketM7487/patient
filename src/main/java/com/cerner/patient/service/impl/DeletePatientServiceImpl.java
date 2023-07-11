package com.cerner.patient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.entity.Patient;
import com.cerner.patient.exception.PatientBusinessException;
import com.cerner.patient.exception.PatientNotFoundException;
import com.cerner.patient.mapper.CommonService;
import com.cerner.patient.repository.PatientRepository;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.DeletePatientService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeletePatientServiceImpl implements DeletePatientService {
	
	@Autowired
	private PatientRepository patientRepository;

	public GenericApiResponse<PatientResponseDTO> deletePatient(Long patientId) throws PatientBusinessException {
		GenericApiResponse<PatientResponseDTO> response = null;

		log.info("PatientService:deletePatient execution started.");
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found with id " + patientId));

		patientRepository.delete(patient);
		response = CommonService.buildResponse(null);
		log.debug("PatientService:deletePatient deleting patient from database  {}", +patientId);

		log.info("PatientService:deletePatient execution ended.");
		return response;

	}

}
