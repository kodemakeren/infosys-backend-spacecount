package no.infossys.spacecount.db;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Spacecraft {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Astronaut> austronauts = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Astronaut> getAustronauts() {
		return austronauts;
	}

	public void setAustronauts(List<Astronaut> austronauts) {
		this.austronauts = austronauts;
	}

	public Long getId() {
		return id;
	}

}