package com.cerner.patient.mapper;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.cerner.patient.dto.AddressDTO;
import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.entity.Address;
import com.cerner.patient.entity.Patient;
import com.cerner.patient.repository.PatientRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class CommonServiceTest.
 */
@SpringBootTest
public class CommonServiceTest {

	/** The patient repository. */
	@Mock
	private PatientRepository patientRepository;
	
	/** The common service. */
	@InjectMocks
	private CommonService commonService;
	
	private PatientRequestDTO patientRequestDTO;
	
	private Patient patient;
	/**
	 * Setup.
	 */
	@BeforeEach
    void setup() {
		patientRequestDTO = PatientRequestDTO.builder().firstName("Test").lastName("Test1")
				.dob("1993-01-10")
				 .address(AddressDTO.builder().address("Pune").city("Pune").state("Maharashtra").pinCode("411046").build())
				.gender("Male").mobileNumber("918888888888").build();
		patient=new Patient(1l, "Test", "Test1", new Address(1l,"Pune","Pune","Maharashtra","411046"), LocalDate.now(), "Male", "918888888888");
    }
	
	/**
	 * Checks if is duplicate patient already exist true.
	 */
	@Test
	public void isDuplicate_PatientAlreadyExist_True() {
		when(patientRepository.findByFirstNameAndLastName("Test","Test1")).thenReturn(patient);
		boolean result=commonService.isDuplicate(patientRequestDTO);
		assertEquals(true, result);
		
	}
	
	/**
	 * Checks if is duplicate patient already exist false.
	 */
	@Test
	public void isDuplicate_PatientAlreadyExist_False() {
		when(patientRepository.findByFirstNameAndLastName("Test","Test1")).thenReturn(null);
		boolean result=commonService.isDuplicate(patientRequestDTO);
		assertEquals(false, result);
		
	}
	
	/**
	 * Checks if is duplicate patient already exist true.
	 */
	@Test
	public void isDuplicateForUpdate_PatientAlreadyExist_True() {
		when(patientRepository.findByFirstNameAndLastName("Test","Test1")).thenReturn(patient);
		boolean result=commonService.isDuplicateForUpdate(2l,patientRequestDTO);
		assertEquals(true, result);
		
	}
	
	/**
	 * Checks if is duplicate patient already exist false.
	 */
	@Test
	public void isDuplicateForUpdate_PatientAlreadyExist_False() {
		when(patientRepository.findByFirstNameAndLastName("Test","Test1")).thenReturn(null);
		boolean result=commonService.isDuplicateForUpdate(1l,patientRequestDTO);
		assertEquals(false, result);
		
	}
}
