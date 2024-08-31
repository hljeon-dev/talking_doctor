package com.talking_doctor.TalkingDoctor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.talking_doctor.TalkingDoctor.repository")
class TalkingDoctorApplicationTests {

	@Test
	void contextLoads() {
	}

}
