package com.cerner.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.cerner.patient.config.AuditorAwareImpl;

@SpringBootApplication
public class PatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientApplication.class, args);
	}

}
