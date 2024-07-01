package no.infossys.spacecount.db;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import jakarta.persistence.Entity;

@Entity
public class Spacecraft {
	
	@Id
	@Column
	private Long id;
	
	@Column
	private String name;
	
	@OneToMany
	private List<Astronaut> austronauts;

}