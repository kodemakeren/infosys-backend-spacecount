package no.infossys.spacecount.repository;

import org.springframework.data.repository.CrudRepository;

import no.infossys.spacecount.db.Spacecraft;

public interface SpacecraftRepository extends CrudRepository<Spacecraft, Long> {

	Spacecraft findByName(String name);
}