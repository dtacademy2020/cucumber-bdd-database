package com.automationpractice.apiTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ComplexParsing {
	
	@Test
	public void parseComplexResponse() {
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		JsonPath jp = given(). 
		queryParam("input", "Duotech").
		queryParam("inputtype", "textquery").
		queryParam("fields", "photos,formatted_address,name,rating,opening_hours,geometry").
		queryParam("key", "AIzaSyCW1pMbqWsBrmZaZAgUQPwPuv7EOBcQ-Qc").
		
	
		when().
				get("/maps/api/place/findplacefromtext/json").
		then().log().all().
				assertThat().
							statusCode(200).extract().response().jsonPath();
		
		//Groovy Gpath syntax
		String address = jp.getString("candidates[0].formatted_address");
		
		System.out.println(address);
		
		Float lat = jp.getFloat("candidates[0].geometry.location.lat");
		
		System.out.println(lat);
		
		System.out.println(jp.getInt("candidates[0].size()"));
				
	}
	
	
	@Test
	public void validateSize() {
		
		RestAssured.baseURI = "http://localhost:8080/app" ;
		
		JsonPath jp = given().
		      header("Accept" , "application/json").
		 when().
		 	get("/videogames"). prettyPeek().
		 then().log().all().
		 		assertThat().
		 		statusCode(200).extract().response().jsonPath();
		 		
		System.out.println(jp.getInt("$.size()"));
		
		List<Map<String,Object>> maps = jp.get("$");
		
		System.out.println(maps);
		
		
		Map<String,Object> firstJson = jp.get("[0]");
		
		System.out.println(firstJson);
		
		
		
		
		
	}

}
