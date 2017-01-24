package com.lits.maven.sample;

import java.util.Comparator;
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

	//Comparator for sorting the list by surname
	 public static Comparator<Students> StuNameComparator = new Comparator<Students>() {

	  public int compare(Students obj1, Students obj2) {
	   int byName = obj1.getSurname().compareTo(obj2.getSurname());
	   if (byName == 0) {
	    int byAge = Integer.compare(obj1.getAge(), obj2.getAge());
	    if (byAge == 0) {
	     return Integer.compare(obj1.getYear(), obj2.getYear());
	    } else
	     return byAge;
	   } else
	    return byName;
	  }
	 };
}
