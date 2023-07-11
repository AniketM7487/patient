package com.cerner.patient.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.BDDMockito.*;
import com.cerner.patient.dto.AddressDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.DeletePatientService;
import static org.mockito.Mockito.when;

// TODO: Auto-generated Javadoc
/**
 * The Class DeletePatientControllerTest.
 */
@WebMvcTest(DeletePatientController.class)
public class DeletePatientControllerTest {

	/** The delete patient controller. */
	@InjectMocks
	DeletePatientController deletePatientController;
	
	/** The mock mvc. */
	@Autowired
    private MockMvc mockMvc;
	
	/** The delete patient service. */
	@MockBean
	private DeletePatientService deletePatientService;

	/**
	 * Delete patient test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void deletePatientTest() throws Exception 
	{
		PatientResponseDTO patientRes = PatientResponseDTO.builder().key(1l).firstName("Ramesh").lastName("Fadatare")
				.dob("1993-01-10")
				.address(AddressDTO.builder().address("Pune").city("Pune").state("MH").pinCode("411046").build())
				.gender("Male").mobileNumber("918446204748").build();
		GenericApiResponse<PatientResponseDTO> patient = buildResponse(patientRes);
		when(deletePatientService.deletePatient(1l)).thenReturn(patient);
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/patient/1").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isNoContent())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").isNotEmpty());
	}

	/**
	 * Builds the response.
	 *
	 * @param patientResponseDTO the patient response DTO
	 * @return the generic api response
	 */
	public GenericApiResponse<PatientResponseDTO> buildResponse(PatientResponseDTO patientResponseDTO) {
		return GenericApiResponse
                .<PatientResponseDTO>builder()
                .status("SUCCESS")
                .data(patientResponseDTO)
                .build();
	}
}
