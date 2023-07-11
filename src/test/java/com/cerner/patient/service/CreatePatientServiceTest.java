package com.cerner.patient.service;


import com.cerner.patient.dto.AddressDTO;
import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.entity.Address;
import com.cerner.patient.entity.Patient;
import com.cerner.patient.exception.PatientExistException;
import com.cerner.patient.mapper.CommonService;
import com.cerner.patient.repository.PatientRepository;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.impl.CreatePatientServiceImpl;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class CreatePatientServiceTest {

	@Mock
	private PatientRepository patientRepository;
	
	@Mock
	private CommonService commonService;
	@InjectMocks
	private CreatePatientServiceImpl createPatientService;
	
	private PatientRequestDTO patientRequestDTO;
	
	private Patient patient;
	
	@BeforeEach
    void setup() {
		patientRequestDTO = PatientRequestDTO.builder().firstName("Test").lastName("Test1")
				.dob("1993-01-10")
				 .address(AddressDTO.builder().address("Pune").city("Pune").state("Maharashtra").pinCode("411046").build())
				.gender("Male").mobileNumber("918888888888").build();
		patient=new Patient(1l, "Test", "Test1", new Address(1l,"Pune","Pune","Maharashtra","411046"), LocalDate.now(), "Male", "918888888888");
		when(patientRepository.save(ArgumentMatchers.any(Patient.class))).thenReturn(patient);
    }
	
	@Test
	public void addPatient_whenSavePatient_shouldReturnPatient() {
		when(patientRepository.findByFirstNameAndLastName("Ramesh","Ramesh")).thenReturn(null);
		when(commonService.isDuplicate(patientRequestDTO)).thenReturn(false);
		GenericApiResponse<PatientResponseDTO> created = createPatientService.addPatient(patientRequestDTO);
		assertThat(created.getStatus()).isSameAs("SUCCESS");
	}
	
	@Test
	public void addPatient_whenDuplicatePatient_shouldReturnPatientExistException() {
		when(commonService.isDuplicate(patientRequestDTO)).thenReturn(true);
		assertThrows(PatientExistException.class, () -> {
			createPatientService.addPatient(patientRequestDTO);
		});
	}
}
