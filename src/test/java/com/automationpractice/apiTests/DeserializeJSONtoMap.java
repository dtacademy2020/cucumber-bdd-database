package com.automationpractice.apiTests;

import java.util.Random;

import org.testng.annotations.Test;

import com.automationpractice.pojos.VideoGame;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class DeserializeJSONtoMap {
	
	
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
		
		 VideoGame game = response.as(VideoGame.class);  // as(Type.class)
		
		 System.out.println(game); 
		 
		 assertEquals(game.getName(), "Half-Life: Alyx");
		 assertEquals(game.getRating(), "5.0");
		 assertEquals(game.getReleaseDate(), "2020-03-05");
		 assertEquals(game.getReviewScore(), new Integer(5));

}
	
}
