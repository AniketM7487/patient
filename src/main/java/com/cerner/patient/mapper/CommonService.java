package com.cerner.patient.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.entity.Patient;
import com.cerner.patient.repository.PatientRepository;
import com.cerner.patient.response.GenericApiResponse;

@Service
public class CommonService {
	@Autowired
	private PatientRepository patientRepository;

	public static GenericApiResponse<PatientResponseDTO> buildResponse(PatientResponseDTO patientResponseDTO) {
		return GenericApiResponse
                .<PatientResponseDTO>builder()
                .status("SUCCESS")
                .data(patientResponseDTO)
                .build();
	}
	
	
	public static GenericApiResponse<List<PatientResponseDTO>> buildResponseForList(List<PatientResponseDTO> patients) {
		return GenericApiResponse
                .<List<PatientResponseDTO>>builder()
                .status("SUCCESS")
                .data(patients)
                .build();
	}


	public boolean isDuplicate(PatientRequestDTO patientRequestDTO) {
		Patient patient=patientRepository.findByFirstNameAndLastName(patientRequestDTO.getFirstName(),patientRequestDTO.getLastName());
		if(patient!=null) {
			return true;
		}else {
			return false;
		}
	}

}
