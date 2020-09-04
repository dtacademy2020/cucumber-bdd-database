package com.automationpractice.apiTests;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.testng.annotations.Test;

import com.automationpractice.pojos.VideoGame;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;

public class SerializingUsingPOJO {
	
	
	@Test
	public void serializingDemo() {
		
		
		/*
		 * Serializing -> Converting Java Object into JSON
		 * Deserializing -> Converting JSON to Java Object
		 */
		
		VideoGame game = new VideoGame(new Random().nextInt(1000), "Half-Life", "1999-06-06", 100, "FPS", "5.0");
		
		RestAssured.baseURI = "http://localhost:8080/app" ;
		
		given().log().all().
		      header("Accept" , "application/json"). // -> accept(ContentType.JSON)
		      header("Content-Type" , "application/json"). // -> contentType(ContentType.JSON).
		      
		     //Accept -> indicates in which format you want to receive your response
		     //Content-Type -> Accept -> indicates in which format you are sending your request
		      
		      body(game).
		 when(). log().all().
		 	post("/videogames"). prettyPeek().
		 then().log().all().
		 		assertThat().
		 		statusCode(200).
		 		body("status", containsString("Successfully"));
		 		
		
		
		
		
	}

}
