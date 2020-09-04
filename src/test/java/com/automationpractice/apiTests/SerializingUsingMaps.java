package com.automationpractice.apiTests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
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

public class SerializingUsingMaps {
	
	
	@Test
	public void serializingUsingMaps() {
		
		
		/*
		 * Serializing -> Converting Java Object into JSON
		 * Deserializing -> Converting JSON to Java Object
		 */
		
		//Send the request body as map
		//Send PUT request to update the existing video game details
		
		Map<String,Object> videoGame = new HashMap<String, Object>();
		
		videoGame.put("id", 6);
		videoGame.put("name", "Half-Life: Alyx");
		videoGame.put("releaseDate", "2020-03-06");
		videoGame.put("reviewScore", 5);
		videoGame.put("category", "FPS");
		videoGame.put("rating", "5.0");
		
		
		RestAssured.baseURI = "http://localhost:8080/app" ;
		
		given().
		      header("Accept" , "application/json"). // -> accept(ContentType.JSON)
		      header("Content-Type" , "application/json"). // -> contentType(ContentType.JSON).
		      pathParam("videoGameId", 6).
		     
		      
		      body(videoGame). //sending the payload as MAP object
		 when(). log().all().
		 	put("/videogames/{videoGameId}"). prettyPeek().  //-. /videogames/6
		 then().log().all().
		 		assertThat().
		 		statusCode(200).
		 		body("name", equalTo("Half-Life: Alyx")).
		 		header("content-length", is("108")).
		 		header("content-type", equalTo("application/json")).
		 		header("date", containsString("Thu, 03 Sep 2020"));
		 		
		
		
		
		
	}

}
