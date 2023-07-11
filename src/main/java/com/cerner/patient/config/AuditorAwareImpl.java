package com.cerner.patient.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

// TODO: Auto-generated Javadoc
/**
 * The Class AuditorAwareImpl used for JPA audit enabling configuration.
 * @author Aniket
 * @version 0.1
 * @since 2023
 */
public class AuditorAwareImpl implements AuditorAware<String> {

    /* (non-Javadoc)
     * @see org.springframework.data.domain.AuditorAware#getCurrentAuditor()
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Aniket");
    }
}
