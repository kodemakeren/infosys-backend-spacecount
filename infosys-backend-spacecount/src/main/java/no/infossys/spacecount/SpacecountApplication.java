package no.infossys.spacecount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import no.infossys.spacecount.db.Astronaut;
import no.infossys.spacecount.db.Spacecraft;
import no.infossys.spacecount.json.Person;
import no.infossys.spacecount.json.Root;
import no.infossys.spacecount.repository.SpacecraftRepository;

@SpringBootApplication
public class SpacecountApplication {

	@Autowired
	SpacecountDataFetcher spacecountDataFetcher;

	@Autowired
	SpacecraftRepository spacecraftRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpacecountApplication.class, args);
	}

	@PostConstruct
	public void test() {
		Root root = spacecountDataFetcher.getRoot();
		ArrayList<Person> people = root.getPeople();
		Set<Person> uniqueCrafts = new HashSet<>(people);
		System.out.println("unike=" + uniqueCrafts);
		
		Map<String, Spacecraft> spacecrafts = new HashMap<>();
		
		for (Person uniqueSpacecraft : uniqueCrafts) {
			String spacecraftName = uniqueSpacecraft.getCraft();
			
			for (Person person : people) {
				if (spacecraftName.equals(person.getCraft())) {
					if (spacecrafts.containsKey(spacecraftName)) {
						Spacecraft spacecraft = spacecrafts.get(spacecraftName);
						Astronaut astronaut = new Astronaut();
						astronaut.setName(person.getName());
						spacecraft.getAustronauts().add(astronaut);
					} else {
						Spacecraft spacecraft = new Spacecraft();
						spacecraft.setName(spacecraftName);
						Astronaut astronaut = new Astronaut();
						astronaut.setName(person.getName());
						spacecraft.getAustronauts().add(astronaut);
						spacecrafts.put(spacecraftName, spacecraft);
					}
				}
			}
		}
		
		spacecraftRepository.saveAll(spacecrafts.values());
		
	}
}