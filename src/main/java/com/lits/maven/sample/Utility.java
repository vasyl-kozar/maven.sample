package com.lits.maven.sample;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class Utility {
	
	public static List<Student> parseJsonFile() throws JsonParseException, JsonMappingException, IOException{
	InputStream input = Utility.class.getResourceAsStream("/com/lits/maven/sample/Students.json");
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
	TypeFactory typeFactory = TypeFactory.defaultInstance();
	List<Student> students = objectMapper.readValue(input, typeFactory.constructCollectionType(ArrayList.class, Student.class));
	return students;
	}

}
