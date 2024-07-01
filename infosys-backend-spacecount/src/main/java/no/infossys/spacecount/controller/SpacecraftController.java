package no.infossys.spacecount.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import no.infossys.spacecount.db.Astronaut;
import no.infossys.spacecount.db.Spacecraft;
import no.infossys.spacecount.repository.AstronautRepository;

@RestController
@RequestMapping("/spacecraft")
public class SpacecraftController {

	@Autowired
	AstronautRepository astronautRepository;
	
	@GetMapping("/{astronautId}")
	public ResponseEntity<Spacecraft> greeting(@PathVariable Long astronautId) {
		Optional<Astronaut> astronaut = astronautRepository.findById(astronautId);
    	
    	if (astronaut.isEmpty()) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	Spacecraft spacecraft = astronaut.get().getSpacecraft();
		return ResponseEntity.ok(spacecraft);
	}
}
