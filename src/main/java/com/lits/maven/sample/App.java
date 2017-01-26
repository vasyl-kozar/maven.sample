package com.lits.maven.sample;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lits.maven.sample.Utility;

public class App {
	public static void main(String[] args) {
		List<Students> studentsList = null;
		// Calling parsing method
		try {
			studentsList = Utility.parseJsonFile();
		} catch (JsonParseException e) {
			System.out.println("Issue during parsing JSON file. Details: \n");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			System.out.println("Issue during mapping JSON. Details: \n");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Issue with file reading. Details: \n");
			e.printStackTrace();
		}

		if (studentsList != null) {
			// Displaying original list.
			System.out.println("\nStudens list: \n");
			for (Students item : studentsList) {
				System.out.println(item.getSurname() + " " + item.getAge() + " " + item.getYear());
			}
			// Sorting part
			Collections.sort(studentsList, Students.StuNameComparator);
			System.out.println("\nSorted list of students: \n");
			for (Students item : studentsList) {
				System.out.println(item.getSurname() + " " + item.getAge() + " " + item.getYear());
			}
		} else {
			System.out.println("Students list is empty");
		}
	}
}
