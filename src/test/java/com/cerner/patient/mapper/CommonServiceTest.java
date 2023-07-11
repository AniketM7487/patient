package com.cerner.patient.mapper;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.cerner.patient.dto.AddressDTO;
import com.cerner.patient.dto.PatientRequestDTO;
import com.cerner.patient.entity.Address;
import com.cerner.patient.entity.Patient;
import com.cerner.patient.repository.PatientRepository;

@SpringBootTest
public class CommonServiceTest {

	@Mock
	private PatientRepository patientRepository;
	
	@InjectMocks
	private CommonService commonService;
	
	@Test
	public void isDuplicate_PatientAlreadyExist_True() {
		PatientRequestDTO patientReq = PatientRequestDTO.builder().firstName("Ramesh").lastName("Ramesh")
				.dob("1993-01-10")
				 .address(AddressDTO.builder().address("Pune").city("Pune").state("MH").pinCode("411046").build())
				.gender("Male").mobileNumber("918446204748").build();
		Patient patient=new Patient(1l, "Ramesh", "Ramesh", new Address(1l,"test","test","test","Test"), LocalDate.now(), "Male", "844620474888");
		when(patientRepository.findByFirstNameAndLastName("Ramesh","Ramesh")).thenReturn(patient);
		boolean result=commonService.isDuplicate(patientReq);
		assertEquals(true, result);
		
	}
	
	@Test
	public void isDuplicate_PatientAlreadyExist_False() {
		PatientRequestDTO patientReq = PatientRequestDTO.builder().firstName("Ramesh").lastName("Ramesh")
				.dob("1993-01-10")
				 .address(AddressDTO.builder().address("Pune").city("Pune").state("MH").pinCode("411046").build())
				.gender("Male").mobileNumber("918446204748").build();
		when(patientRepository.findByFirstNameAndLastName("Ramesh","Ramesh")).thenReturn(null);
		boolean result=commonService.isDuplicate(patientReq);
		assertEquals(false, result);
		
	}
}
