package com.automationpractice.apiTests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Payloads {
	
	
	public static String addPlace (String name, String phone, String address) {
		
		return "{\r\n" + 
				" \"location\": {\r\n" + 
				"   \"lat\": -77.2273128,\r\n" + 
				"   \"lng\": 38.9151944\r\n" + 
				" },\r\n" + 
				" \"accuracy\": 50,\r\n" + 
				" \"name\": \""+name+"\",\r\n" + 
				" \"phone_number\": \""+phone+"\",\r\n" + 
				" \"address\": \""+address+"\",\r\n" + 
				" \"types\": [\r\n" + 
				"   \"restaurant\",\r\n" + 
				"   \"italian\"\r\n" + 
				" ],\r\n" + 
				" \"website\": \"ogarden.io\",\r\n" + 
				" \"language\": \"English\"\r\n" + 
				"}" ;
	}
	
public static String deletePlace (String placeID) {
		
		return "{\r\n" + 
				"	    \"place_id\": \""+placeID+"\"\r\n" + 
				"	}" ;
	}


	public static String getFromJsonFile(String path) throws IOException {
	
		
		return new String(Files.readAllBytes(Paths.get(path)));
	}
	
	

}
