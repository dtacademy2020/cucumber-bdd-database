package com.automationpractice.apiTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class HamcrestLibrary {
	
	
	@Test
	public void hamcrestDemo() {
	RestAssured.baseURI = "http://localhost:8080/app" ;
	
	given().
	      header("Accept" , "application/json").
	 when().
	 	get("/videogames"). prettyPeek().
	 then().log().all().
	 		assertThat().
	 		statusCode(200).
	 		header("content-length",  not("2027")).
	 		header("content-type",  is("application/json")).
	 		//cookie(cookieName, detailedCookieMatcher)
	 		body("[0]" , hasKey("name")).
	 		body("[0]" , hasEntry("id", 1)).
			body("[0]" , hasValue("Shoote"));
	
	}

}
