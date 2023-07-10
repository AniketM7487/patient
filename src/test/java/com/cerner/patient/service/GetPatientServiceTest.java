package com.cerner.patient.service;

import com.cerner.patient.dto.AddressDTO;
import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.entity.Address;
import com.cerner.patient.entity.Patient;
import com.cerner.patient.mapper.CommonService;
import com.cerner.patient.repository.PatientRepository;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.impl.CreatePatientServiceImpl;
import com.cerner.patient.service.impl.GetPatientServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
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
public class GetPatientServiceTest {

	@Mock
	private PatientRepository patientRepository;
	
	@InjectMocks
	private GetPatientServiceImpl getPatientService;
	
	@Test
    public void givenPatientList_whenGetAllPatient_thenReturnPatientList(){
		List<Patient> patientList = new ArrayList<Patient>();
		Patient patient=new Patient(1l, "Ramesh", "Ramesh", new Address(1l,"test","test","test","Test"), LocalDate.now(), "Male", "844620474888");
		Patient patient1=new Patient(1l, "Ramesh", "Ramesh", new Address(1l,"test","test","test","Test"), LocalDate.now(), "Male", "844620474888");
		patientList.add(patient);
		patientList.add(patient1);
		when(patientRepository.findAll()).thenReturn(patientList);
		GenericApiResponse<List<PatientResponseDTO>> patientResponse=getPatientService.getPatients();
		assertThat(patientList).isNotNull();
        assertThat(patientList.size()).isEqualTo(2);
	}
	
	@Test
    public void givenPatient_whenGetPatientById_thenReturnPatient(){
		Patient patient=new Patient(1l, "Ramesh", "Ramesh", new Address(1l,"test","test","test","Test"), LocalDate.now(), "Male", "844620474888");
		when(patientRepository.findById(1l)).thenReturn(Optional.of(patient));
		GenericApiResponse<PatientResponseDTO> patientResponse=getPatientService.getPatientById(1l);
		assertThat(patientResponse.getData().getFirstName()).isNotNull();
        assertThat(patientResponse.getStatus()).isEqualTo("SUCCESS");
	}
	
	
}
