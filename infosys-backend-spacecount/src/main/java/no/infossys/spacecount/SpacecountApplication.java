package no.infossys.spacecount;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import no.infossys.spacecount.json.Person;
import no.infossys.spacecount.json.Root;

@SpringBootApplication
public class SpacecountApplication {

	@Autowired
	SpacecountDataFetcher spacecountDataFetcher;

	public static void main(String[] args) {
		SpringApplication.run(SpacecountApplication.class, args);
	}

	@PostConstruct
	public void test() {
		Root root = spacecountDataFetcher.getRoot();
		ArrayList<Person> people = root.getPeople();
		Set<Person> uniqueCrafts = new HashSet<>(people);
		System.out.println("unike=" + uniqueCrafts);
	}
}