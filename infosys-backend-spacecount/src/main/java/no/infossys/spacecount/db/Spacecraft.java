package no.infossys.spacecount.db;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="spacecrafts")
public class Spacecraft {
	
	@Id
	@Column(name="spacecraft_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "spacecraft")
	private List<Astronaut> astronauts = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@JsonIgnore
	public List<Astronaut> getAustronauts() {
		return astronauts;
	}

	public void setAustronauts(List<Astronaut> austronauts) {
		this.astronauts = austronauts;
	}

	public Long getId() {
		return id;
	}

}