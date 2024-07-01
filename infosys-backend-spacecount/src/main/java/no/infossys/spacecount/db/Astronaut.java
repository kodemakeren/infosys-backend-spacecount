package no.infossys.spacecount.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Astronaut {
	
	@Id
	@Column
	private Long id;
	
	@Column
	private String name;

}