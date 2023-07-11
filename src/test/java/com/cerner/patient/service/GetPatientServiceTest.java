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

// TODO: Auto-generated Javadoc
/**
 * The Class GetPatientServiceTest.
 */
@SpringBootTest
public class GetPatientServiceTest {

	/** The patient repository. */
	@Mock
	private PatientRepository patientRepository;
	
	/** The get patient service. */
	@InjectMocks
	private GetPatientServiceImpl getPatientService;
	
	/** The patient. */
	private Patient patient;
	
	/**
	 * Setup.
	 */
	@BeforeEach
    void setup() {
		patient=new Patient(1l, "Test", "Test1", new Address(1l,"Pune","Pune","Maharashtra","411046"), LocalDate.now(), "Male", "918888888888");
    }
	
	/**
	 * Gets the patients when get all patient should return patient list.
	 *
	 * @return the patients when get all patient should return patient list
	 */
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
	
	/**
	 * Gets the patients when get all patient should return empty patient list.
	 *
	 * @return the patients when get all patient should return empty patient list
	 */
	@Test
    public void getPatients_whenGetAllPatient_shouldReturnEmptyPatientList(){
		List<Patient> patientList = new ArrayList<Patient>();
		when(patientRepository.findAll()).thenReturn(patientList);
		GenericApiResponse<List<PatientResponseDTO>> patientResponse=getPatientService.getPatients();
		assertThat(patientList).isEmpty();
	}
	
	
	/**
	 * Gets the patient by id when get patient by id should return patient.
	 *
	 * @return the patient by id when get patient by id should return patient
	 */
	@Test
    public void getPatientById_whenGetPatientById_shouldReturnPatient(){
		when(patientRepository.findById(1l)).thenReturn(Optional.of(patient));
		GenericApiResponse<PatientResponseDTO> patientResponse=getPatientService.getPatientById(1l);
		assertThat(patientResponse.getData().getFirstName()).isNotNull();
        assertThat(patientResponse.getStatus()).isEqualTo("SUCCESS");
	}
	
	/**
	 * Gets the patient by id when patient by id not found should return patient not found exception.
	 *
	 * @return the patient by id when patient by id not found should return patient not found exception
	 */
	@Test
    public void getPatientById_whenPatientByIdNotFound_shouldReturnPatientNotFoundException(){
		assertThrows(PatientNotFoundException.class,() ->  getPatientService.getPatientById(1l));
	}
}
