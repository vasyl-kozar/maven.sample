package com.lits.maven.sample;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Students {

	private String surname;
	private int age;
	private int year;
	
	@JsonCreator
	public Students(@JsonProperty("surname") String surname, @JsonProperty("age") int age, 
			@JsonProperty("year") int year) {
		this.surname = surname;
		this.age = age;
		this.year = year;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	
}
