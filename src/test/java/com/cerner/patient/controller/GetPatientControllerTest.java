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
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.BDDMockito.*;
import com.cerner.patient.dto.AddressDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.GetPatientService;
import static org.mockito.Mockito.when;

@WebMvcTest(GetPatientController.class)
public class GetPatientControllerTest {

	@InjectMocks
	GetPatientController getPatientController;
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private GetPatientService getPatientService;

	@Test
	public void getPatientsTest() throws Exception 
	{
		List<PatientResponseDTO> patients = new ArrayList<>();
		PatientResponseDTO patientRes = PatientResponseDTO.builder().key(1l).firstName("Ramesh").lastName("Fadatare")
				.dob("1993-01-10")
				.address(AddressDTO.builder().address("Pune").city("Pune").state("MH").pinCode("411046").build())
				.gender("Male").mobileNumber("918446204748").build();
		patients.add(patientRes);
		GenericApiResponse<List<PatientResponseDTO>> patient = buildResponseForList(patients);
		when(getPatientService.getPatients()).thenReturn(patient);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/patient").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.status").isNotEmpty());
//	      .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
	}
	
	@Test
	public void getPatientTest() throws Exception 
	{
		PatientResponseDTO patientRes = PatientResponseDTO.builder().key(1l).firstName("Ramesh").lastName("Fadatare")
				.dob("1993-01-10")
				.address(AddressDTO.builder().address("Pune").city("Pune").state("MH").pinCode("411046").build())
				.gender("Male").mobileNumber("918446204748").build();
		GenericApiResponse<PatientResponseDTO> patient = buildResponse(patientRes);
		when(getPatientService.getPatientById(1l)).thenReturn(patient);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/patient/1").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").isNotEmpty());
//	      .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
	}
	
	public GenericApiResponse<List<PatientResponseDTO>> buildResponseForList(List<PatientResponseDTO> patients) {
		return GenericApiResponse
                .<List<PatientResponseDTO>>builder()
                .status("SUCCESS")
                .data(patients)
                .build();
	}
	public GenericApiResponse<PatientResponseDTO> buildResponse(PatientResponseDTO patientResponseDTO) {
		return GenericApiResponse
                .<PatientResponseDTO>builder()
                .status("SUCCESS")
                .data(patientResponseDTO)
                .build();
	}
}
