package com.cerner.patient.controller;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.cerner.patient.dto.AddressDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.DeletePatientService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@WebMvcTest(DeletePatientController.class)
public class DeletePatientControllerTest {

	@InjectMocks
	DeletePatientController deletePatientController;
	
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private DeletePatientService deletePatientService;

	@Test
	public void deletePatientByIdAPI() throws Exception 
	{
		PatientResponseDTO patientRes = PatientResponseDTO.builder().key(1l).firstName("Ramesh").lastName("Fadatare")
				.dob("1993-01-10")
				.address(AddressDTO.builder().address("Pune").city("Pune").state("MH").pinCode("411046").build())
				.gender("Male").mobileNumber("918446204748").build();
		GenericApiResponse<PatientResponseDTO> patient = buildResponse(patientRes);
		when(deletePatientService.deletePatient(1l)).thenReturn(patient);
		mockMvc.perform(MockMvcRequestBuilders
	  			.delete("/api/v1/patient/1")
	  			.accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isNoContent())
	      .andExpect(MockMvcResultMatchers.jsonPath("$.status").isNotEmpty());
//	      .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
	}

	public GenericApiResponse<PatientResponseDTO> buildResponse(PatientResponseDTO patientResponseDTO) {
		return GenericApiResponse
                .<PatientResponseDTO>builder()
                .status("SUCCESS")
                .data(patientResponseDTO)
                .build();
	}
}
