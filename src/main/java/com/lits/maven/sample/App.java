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
		try {
			studentsList = Utility.parseJsonFile();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (studentsList != null) {
			System.out.println("\nStudens list: \n");
			for (Students item : studentsList) {
				System.out.println(item.getSurname() + " " + item.getAge() + " " + item.getYear());
			}
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
