package com.automationpractice.apiTests;

import java.util.Map;
import java.util.Random;

import org.testng.annotations.Test;

import com.automationpractice.pojos.VideoGame;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class DeserializeJSONtoPOJO {
	
	
	@Test
	public void deserializingJSONtoPOJO() {
		
		
		
		
		
		RestAssured.baseURI = "http://localhost:8080/app" ;
		
		
		 Response response = given().
		       header("Accept", "application/json").
		       pathParam("videoGameId", 6).
		when().
				get("videogames/{videoGameId}").
		then(). log().all().
			assertThat(). //syntactic sugar
		      statusCode(200).extract().response();
		
		 
		//Deserialize the response into a POJO
		
		  Map<String, Object> videoGame = response.as(new TypeRef<Map<String,Object>> () {});  // as(Type.class)
		
		assertEquals(videoGame.get("name"), "Half-Life: Alyx");
		assertEquals(videoGame.get("rating"), "5.0");
		assertEquals(videoGame.get("releaseDate"), "2020-03-05");
}
	
}
