package com.cerner.patient.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.entity.Patient;
import com.cerner.patient.repository.PatientRepository;
import com.cerner.patient.response.GenericApiResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class CommonService.
 */
@Service
public class CommonService {
	
	/** The patient repository. */
	@Autowired
	private PatientRepository patientRepository;

	/**
	 * Builds the response.
	 *
	 * @param patientResponseDTO the patient response DTO
	 * @return the generic api response
	 */
	public static GenericApiResponse<PatientResponseDTO> buildResponse(PatientResponseDTO patientResponseDTO) {
		return GenericApiResponse
                .<PatientResponseDTO>builder()
                .status("SUCCESS")
                .data(patientResponseDTO)
                .build();
	}
	
	
	/**
	 * Builds the response for list.
	 *
	 * @param patients the patients
	 * @return the generic api response
	 */
	public static GenericApiResponse<List<PatientResponseDTO>> buildResponseForList(List<PatientResponseDTO> patients) {
		return GenericApiResponse
                .<List<PatientResponseDTO>>builder()
                .status("SUCCESS")
                .data(patients)
                .build();
	}


	/**
	 * Checks if is duplicate.
	 *
	 * @param patientRequestDTO the patient request DTO
	 * @return true, if is duplicate
	 */
	public boolean isDuplicate(PatientRequestDTO patientRequestDTO) {
		Patient patient=patientRepository.findByFirstNameAndLastName(patientRequestDTO.getFirstName(),patientRequestDTO.getLastName());
		if(patient!=null) {
			return true;
		}else {
			return false;
		}
	}

}
