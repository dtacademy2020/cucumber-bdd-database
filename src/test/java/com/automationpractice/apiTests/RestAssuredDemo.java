package com.automationpractice.apiTests;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;





public class RestAssuredDemo {
	
	

	public static void main(String[] args) {
		
		
		//Send a post request to add resource
		//Verify the message body, status code
		
		
		baseURI = "http://3.6.24.244";
		
		//given()
		//when()
		//then()
		
		given(). 
				queryParam("key", "qaclick123").
				header("Content-Type", "application/json").
				body("{\r\n" + 
						" \"location\": {\r\n" + 
						"   \"lat\": -77.2273128,\r\n" + 
						"   \"lng\": 38.9151944\r\n" + 
						" },\r\n" + 
						" \"accuracy\": 50,\r\n" + 
						" \"name\": \"Olive Garden\",\r\n" + 
						" \"phone_number\": \"(571) 295-4555\",\r\n" + 
						" \"address\": \"8133 Leesburg Pike STE 100, Vienna, VA 22182\",\r\n" + 
						" \"types\": [\r\n" + 
						"   \"restaurant\",\r\n" + 
						"   \"italian\"\r\n" + 
						" ],\r\n" + 
						" \"website\": \"olivegarden.io\",\r\n" + 
						" \"language\": \"English\"\r\n" + 
						"}").
				
		when().
				post("maps/api/place/add/json").
		then().log().all().
				assertThat().
							statusCode(210).
							body("status", equalTo("OK")).and().
							body("scope", equalTo("APP")).and().
							header("Server", equalTo("Apache/2.4.18 (Ubuntu)")).
							time(lessThan(5000L));

		
		
		
		
		
		

	}

}
