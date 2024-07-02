package no.infossys.spacecount;


import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import no.infossys.spacecount.db.Spacecraft;
import no.infossys.spacecount.exception.MalformedAstroUrlException;
import no.infossys.spacecount.json.Person;
import no.infossys.spacecount.json.Root;

class SpacecountInitializationTest {

	SpacecountInitialization spacecountInitialization = new SpacecountInitialization();

	@Test
	void testFailingReadOfSpaceJson() {
		spacecountInitialization.setUrl("https://api.meteomatics.com/2023-12-06T00:00:00Z/t_2m:C/52.520551,13.461804/json");

		MalformedAstroUrlException exception = assertThrows(MalformedAstroUrlException.class,
				() -> spacecountInitialization.getRoot());
		assertTrue(exception.getMessage().contains("Fant ikke astronautdata på URL"));
	}

	@Test
	void TestSuccessReadOfSpaceJson() {
			spacecountInitialization.setUrl("http://api.open-notify.org/astros.json");
			Root root = spacecountInitialization.getRoot();
			assertTrue(root.getPeople().size() > 1);
	}
	
	@Test
	void testReadJsonToJsonObjects() {
		spacecountInitialization.setUrl("http://api.open-notify.org/astros.json");
		ArrayList<Person> people = spacecountInitialization.getRoot().getPeople();
		Map<String,Spacecraft> spacecraftsWithAstronauts = spacecountInitialization.createSpacecraftsWithAstronauts(people);
		assertTrue(spacecraftsWithAstronauts.keySet().size() != 0);
		
	}
}