package com.automationpractice.apiTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class End2EndApiTests {
	
	
	
	
	@Test
	public  void verifyUpdatePlace() throws IOException {
		
		RestAssured.baseURI = "http://3.6.24.244";
		
		//given() -> parameters, authorization, headers, body(PUT,POST,DELETE)
		//when() -> the request type, endpoint
		//then() -> response validation 
		
		//Create a place
		//Update the place with the new body
		//Verify the response
		
		
		JsonPath jp = given(). 
			queryParam("key", "qaclick123").
			header("Content-Type", "application/json").
			body(Payloads.getFromJsonFile("AddPlaceOG.json")).
		
		when().
				post("/maps/api/place/add/json").
		then().log().all().
				assertThat().
					statusCode(200).
					body("status", equalTo("OK")).extract().response().jsonPath();
		
		
		String placeid = jp.getString("place_id");
		
		given(). 
		queryParam("key", "qaclick123").
		header("Content-Type", "application/json").
		body("{\r\n" + 
				"\"place_id\":\""+placeid+"\",\r\n" + 
				"\"address\":\"70 Summer walk, Vienna, VA 22182 USA\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"").
	
	when().
			put("/maps/api/place/update/json").
			then().log().all().
			assertThat().
				statusCode(200).
				body("msg", equalTo("Address successfully updated"));
		
		
		
		
		
		
		
		
					
		


		
	}

}
