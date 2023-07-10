package com.cerner.patient.service;


import com.cerner.patient.dto.AddressDTO;
import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.entity.Address;
import com.cerner.patient.entity.Patient;
import com.cerner.patient.exception.PatientBusinessException;
import com.cerner.patient.exception.PatientExistException;
import com.cerner.patient.mapper.CommonService;
import com.cerner.patient.repository.PatientRepository;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.impl.CreatePatientServiceImpl;
import com.cerner.patient.service.impl.UpdatePatientServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
public class UpdatePatientServiceTest {

	@Mock
	private PatientRepository patientRepository;
	
	@Mock
	private CommonService commonService;
	@InjectMocks
	private UpdatePatientServiceImpl updatePatientService;
	
	@Test
	public void whenSavePatient_shouldReturnPatient() {
		PatientRequestDTO patientReq = PatientRequestDTO.builder().firstName("Ramesh").lastName("Fadatare")
				.dob("1993-01-10")
				 .address(AddressDTO.builder().address("Pune").city("Pune").state("MH").pinCode("411046").build())
				.gender("Male").mobileNumber("918446204748").build();
		Patient patient=new Patient(1l, "Ramesh", "Ramesh", new Address(1l,"test","test","test","Test"), LocalDate.now(), "Male", "844620474888");
		when(patientRepository.save(ArgumentMatchers.any(Patient.class))).thenReturn(patient);
		when(patientRepository.findByFirstNameAndLastName("Ramesh","Ramesh")).thenReturn(null);
		when(patientRepository.findById(1l)).thenReturn(Optional.of(patient));
		when(commonService.isDuplicate(patientReq)).thenReturn(false);
		GenericApiResponse<PatientResponseDTO> created = updatePatientService.updatePatient(1l,patientReq);
		assertThat(created.getStatus()).isSameAs("SUCCESS");
//		verify(patientRepository).save(patient);
//		verify(patientRepository, never()).save(any(Patient.class));
	}
	
}
