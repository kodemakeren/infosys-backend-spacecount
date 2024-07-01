package no.infossys.spacecount.json;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	String name;
	String craft;
	
	@JsonProperty("craft")
	public String getCraft() {
		return this.craft;
	}

	@Override
	public int hashCode() {
		return Objects.hash(craft);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(craft, other.craft);
	}

	public void setCraft(String craft) {
		this.craft = craft;
	}

	@JsonProperty("name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}