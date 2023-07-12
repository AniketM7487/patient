package com.cerner.patient.config;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuditorAwareImplTest {

	@InjectMocks
	private AuditorAwareImpl auditorAwareImpl;
	
	@Test
	public void getCurrentAuditorTest() {
		Optional<String> result = auditorAwareImpl.getCurrentAuditor();
		assertThat(result.get()).isSameAs("Aniket");
	}
	
}
