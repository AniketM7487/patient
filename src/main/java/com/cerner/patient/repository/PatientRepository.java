package com.cerner.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cerner.patient.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

	Patient findByFirstNameAndLastName(String firstName, String lastName);

}
