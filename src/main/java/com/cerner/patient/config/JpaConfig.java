package com.cerner.patient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// TODO: Auto-generated Javadoc
/**
 * The Class JpaConfig used for JPA configuration
 * @author Aniket
 * @version 0.1
 * @since 2023
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfig {
    
    /**
     * Auditor aware.
     *
     * @return the auditor aware
     */
    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }
}
