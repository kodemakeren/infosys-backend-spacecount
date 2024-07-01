package no.infossys.spacecount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import no.infossys.spacecount.db.Astronaut;
import no.infossys.spacecount.db.Spacecraft;
import no.infossys.spacecount.repository.SpacecraftRepository;

@RestController
@RequestMapping("/astronauts")
public class SpacecraftController {

	@Autowired
	SpacecraftRepository spacecraftRepository;
	
	@GetMapping("/{craftname}")
	public ResponseEntity<List<Astronaut>> greeting(@PathVariable String craftname) {
    	Spacecraft spacecraft = spacecraftRepository.findByName(craftname);
    	
    	if (spacecraft == null) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	return ResponseEntity.ok(spacecraft.getAustronauts());
	}
}
