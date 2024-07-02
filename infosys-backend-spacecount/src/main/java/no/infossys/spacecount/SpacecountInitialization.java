package no.infossys.spacecount;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import no.infossys.spacecount.db.Astronaut;
import no.infossys.spacecount.db.Spacecraft;
import no.infossys.spacecount.exception.MalformedAstroUrlException;
import no.infossys.spacecount.json.Person;
import no.infossys.spacecount.json.Root;
import no.infossys.spacecount.repository.SpacecraftRepository;

@Component
public class SpacecountInitialization {

	@Autowired
	SpacecraftRepository spacecraftRepository;
	
	@Value("${spacecount.url}")
	String url;

	public void init() {
		Root root = getRoot();
		
		Map<String, Spacecraft> spacecrafts = createSpacecraftsWithAstronauts(root.getPeople());
		
		saveSpacecrafts(spacecrafts.values());
	}
	
	public void setSpacecountJson(String json) {
		
	}
	
	public Root getRoot() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			URL spacecountUrl = URI.create(url).toURL();
			return objectMapper.readValue(spacecountUrl, Root.class);
		} catch (IOException e) {
			throw new MalformedAstroUrlException("Fant ikke astronautdata på URL: " + url);
		}
	}
	
	public Map<String, Spacecraft> createSpacecraftsWithAstronauts(ArrayList<Person> people) {
		Set<Person> uniqueCrafts = getUniqueSpacecrafts(people);
		
		Map<String, Spacecraft> spacecrafts = new HashMap<>();
		
		for (Person uniqueSpacecraft : uniqueCrafts) {
			String spacecraftName = uniqueSpacecraft.getCraft();
			
			for (Person person : people) {
				if (spacecraftName.equals(person.getCraft())) {
					if (spacecrafts.containsKey(spacecraftName)) {
						Spacecraft spacecraft = spacecrafts.get(spacecraftName);
						Astronaut astronaut = new Astronaut();
						astronaut.setName(person.getName());
						astronaut.setSpacecraft(spacecraft);
						spacecraft.getAustronauts().add(astronaut);
					} else {
						Spacecraft spacecraft = new Spacecraft();
						spacecraft.setName(spacecraftName);
						Astronaut astronaut = new Astronaut();
						astronaut.setName(person.getName());
						astronaut.setSpacecraft(spacecraft);
						spacecraft.getAustronauts().add(astronaut);
						spacecrafts.put(spacecraftName, spacecraft);
					}
				}
			}
		}
		return spacecrafts;
	}

	public Set<Person> getUniqueSpacecrafts(ArrayList<Person> people) {
		Set<Person> uniqueCrafts = new HashSet<>(people);
		return uniqueCrafts;
	}
	
	public void saveSpacecrafts(Collection<Spacecraft> spacecrafts) {
		spacecraftRepository.saveAll(spacecrafts);
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}