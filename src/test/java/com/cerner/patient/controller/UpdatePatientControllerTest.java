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
import static org.mockito.BDDMockito.*;
import com.cerner.patient.dto.AddressDTO;
import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.mapper.ValueMapper;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.UpdatePatientService;
import static org.mockito.Mockito.when;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdatePatientControllerTest.
 */
@WebMvcTest(UpdatePatientController.class)
public class UpdatePatientControllerTest {

	/** The update patient controller. */
	@InjectMocks
	UpdatePatientController updatePatientController;
	
	/** The mock mvc. */
	@Autowired
    private MockMvc mockMvc;
	
	/** The update patient service. */
	@MockBean
	private UpdatePatientService updatePatientService;
	
	/**
	 * Update patient test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void updatePatientTest() throws Exception 
	{
		PatientRequestDTO patientReq = PatientRequestDTO.builder().firstName("Ramesh").lastName("Fadatare")
				.dob("1993-01-10")
				.address(AddressDTO.builder().address("Pune").city("Pune").state("MH").pinCode("411046").build())
				.gender("Male").mobileNumber("918446204748").build();
		PatientResponseDTO patientRes = PatientResponseDTO.builder().firstName("Ramesh").lastName("Fadatare")
				.dob("1993-01-10")
				.address(AddressDTO.builder().address("Pune").city("Pune").state("MH").pinCode("411046").build())
				.gender("Male").mobileNumber("918446204748").build();
		GenericApiResponse<PatientResponseDTO> patient = buildResponse(patientRes);
		when(updatePatientService.updatePatient(1l, patientReq)).thenReturn(patient);
		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/patient/1").content(ValueMapper.jsonAsString(patientReq))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("SUCCESS"));
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
