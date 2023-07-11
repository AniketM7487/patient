package com.cerner.patient.service;

import com.cerner.patient.dto.AddressDTO;
import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.entity.Address;
import com.cerner.patient.entity.Patient;
import com.cerner.patient.exception.PatientExistException;
import com.cerner.patient.exception.PatientNotFoundException;
import com.cerner.patient.mapper.CommonService;
import com.cerner.patient.repository.PatientRepository;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.impl.CreatePatientServiceImpl;
import com.cerner.patient.service.impl.DeletePatientServiceImpl;
import com.cerner.patient.service.impl.GetPatientServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class DeletePatientServiceTest {

	@Mock
	private PatientRepository patientRepository;
	
	@InjectMocks
	private DeletePatientServiceImpl deletePatientService;
	
	private Patient patient;
	
	@BeforeEach
    void setup() {
		patient=new Patient(1l, "Test", "Test1", new Address(1l,"Pune","Pune","Maharashtra","411046"), LocalDate.now(), "Male", "918888888888");
    }
	
	@Test
    public void deletePatient_whenDeletePatient_shouldReturnSuccess(){
		when(patientRepository.findById(1l)).thenReturn(Optional.of(patient));
		GenericApiResponse<PatientResponseDTO> patientResponse=deletePatientService.deletePatient(1l);
        assertThat(patientResponse.getStatus()).isEqualTo("SUCCESS");
	}
	
	@Test
    public void deletePatient_whenPatientIdNotExist_shouldReturnPatientNotFoundException(){
		assertThrows(PatientNotFoundException.class,() ->  deletePatientService.deletePatient(1l));
	}
	
	
}
