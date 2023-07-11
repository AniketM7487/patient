package com.cerner.patient.service;

import com.cerner.patient.dto.PatientResponseDTO;
import com.cerner.patient.entity.Address;
import com.cerner.patient.entity.Patient;
import com.cerner.patient.exception.PatientNotFoundException;
import com.cerner.patient.repository.PatientRepository;
import com.cerner.patient.response.GenericApiResponse;
import com.cerner.patient.service.impl.GetPatientServiceImpl;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
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
	
	private Patient patient;
	
	@BeforeEach
    void setup() {
		patient=new Patient(1l, "Test", "Test1", new Address(1l,"Pune","Pune","Maharashtra","411046"), LocalDate.now(), "Male", "918888888888");
    }
	
	@Test
    public void getPatients_whenGetAllPatient_shouldReturnPatientList(){
		List<Patient> patientList = new ArrayList<Patient>();
		Patient patient1=new Patient(1l, "Test", "Test1", new Address(1l,"Pune","Pune","Maharashtra","411046"), LocalDate.now(), "Male", "918888888888");
		patientList.add(patient);
		patientList.add(patient1);
		when(patientRepository.findAll()).thenReturn(patientList);
		GenericApiResponse<List<PatientResponseDTO>> patientResponse=getPatientService.getPatients();
		assertThat(patientList).isNotNull();
        assertThat(patientList.size()).isEqualTo(2);
	}
	
	@Test
    public void getPatients_whenGetAllPatient_shouldReturnEmptyPatientList(){
		List<Patient> patientList = new ArrayList<Patient>();
		when(patientRepository.findAll()).thenReturn(patientList);
		GenericApiResponse<List<PatientResponseDTO>> patientResponse=getPatientService.getPatients();
		assertThat(patientList).isEmpty();
	}
	
	
	@Test
    public void getPatientById_whenGetPatientById_shouldReturnPatient(){
		when(patientRepository.findById(1l)).thenReturn(Optional.of(patient));
		GenericApiResponse<PatientResponseDTO> patientResponse=getPatientService.getPatientById(1l);
		assertThat(patientResponse.getData().getFirstName()).isNotNull();
        assertThat(patientResponse.getStatus()).isEqualTo("SUCCESS");
	}
	
	@Test
    public void getPatientById_whenPatientByIdNotFound_shouldReturnPatientNotFoundException(){
		assertThrows(PatientNotFoundException.class,() ->  getPatientService.getPatientById(1l));
	}
}
