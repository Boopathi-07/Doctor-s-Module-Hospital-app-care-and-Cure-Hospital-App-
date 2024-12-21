package com.cac.main;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EntityScan("com.cac.model")
@ComponentScan(basePackages={"com.*"})
@EnableJpaRepositories("com.cac.repository")
@SpringBootApplication
public class DoctorAutomationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorAutomationSystemApplication.class, args);
	}

}
