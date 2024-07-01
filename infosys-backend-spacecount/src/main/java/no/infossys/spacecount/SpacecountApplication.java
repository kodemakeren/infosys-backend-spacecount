package no.infossys.spacecount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class SpacecountApplication {

	@Autowired
	SpacecountInitialization spacecountInitialization;
	
	public static void main(String[] args) {
		SpringApplication.run(SpacecountApplication.class, args);
	}

	@PostConstruct
	public void init() {
		spacecountInitialization.init();
	}

}