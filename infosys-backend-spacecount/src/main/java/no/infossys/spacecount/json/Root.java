package no.infossys.spacecount.json;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {
	String message;
	ArrayList<Person> people;
	int number;
	
	@JsonProperty("people")
	public ArrayList<Person> getPeople() {
		return this.people;
	}

	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}

	@JsonProperty("number")
	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@JsonProperty("message")
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}