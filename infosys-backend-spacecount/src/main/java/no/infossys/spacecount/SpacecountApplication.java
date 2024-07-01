package no.infossys.spacecount;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;


@SpringBootApplication
public class SpacecountApplication {

	@Autowired
	SpacecountDataFetcher spacecountDataFetcher;
	
	public static void main(String[] args) {
		SpringApplication.run(SpacecountApplication.class, args);
	}

	@PostConstruct
	public void test() {
		try {
			String spacecount = spacecountDataFetcher.getSpacecount();
			System.out.println("space=" + spacecount);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
