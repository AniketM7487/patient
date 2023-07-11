package com.cerner.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cerner.patient.entity.Patient;

// TODO: Auto-generated Javadoc
/**
 * The Interface PatientRepository.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

	/**
	 * Find by first name and last name.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @return the patient
	 */
	Patient findByFirstNameAndLastName(String firstName, String lastName);

}
