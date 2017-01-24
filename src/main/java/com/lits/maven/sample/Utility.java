package com.lits.maven.sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class Utility {
	
	public static List<Students> parseJsonFile() throws JsonParseException, JsonMappingException, IOException{
	File input = new File("src/main/java/com/lits/maven/sample/Students.json");
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
	TypeFactory typeFactory = TypeFactory.defaultInstance();
	List<Students> students = objectMapper.readValue(input, typeFactory.constructCollectionType(ArrayList.class, Students.class));
	return students;
	}

}
