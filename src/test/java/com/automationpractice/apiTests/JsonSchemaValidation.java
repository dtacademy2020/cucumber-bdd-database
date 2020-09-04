package com.automationpractice.apiTests;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.module.jsv.JsonSchemaValidator.*;


public class JsonSchemaValidation {
	
	
	
	@Test
	public void validateJsonSchema() {
		
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
