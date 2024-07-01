package no.infossys.spacecount.repository;

import org.springframework.data.repository.CrudRepository;

import no.infossys.spacecount.db.Astronaut;

public interface AstronautRepository extends CrudRepository<Astronaut, Long> {

}
