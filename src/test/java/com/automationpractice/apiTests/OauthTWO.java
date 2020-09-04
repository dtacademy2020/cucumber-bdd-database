package com.automationpractice.apiTests;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;



public class OauthTWO {
	
	@Test
	public void verifyOAuth2() {
		
		baseURI = "http://coop.apps.symfonycasts.com";
		
		// Send client credentials to /token endpoint and receive the temporary token
		//Using the token send a request to a desired endpoint and get the response
		
		 JsonPath jp = given().
		      param("client_id", "ChickFarm").
		      param("client_secret", "a75d2828592d4fe49cc58cd74b7cc719").
		      param("grant_type", "client_credentials").
		 when().
		       post("/token").
		  then(). log().all().
		      statusCode(200).extract().response().jsonPath();
		     
		 
		 String token = jp.getString("access_token");
		 
		// /api/USER_ID/toiletseat-down
		 
		 given().
	           auth().oauth2(token).
	     when().
	       post("/api/1336/toiletseat-down").
	      then(). log().all().
	        statusCode(200).
	        body("success", equalTo(true));
		 
		 
		    
		
		
	}

}
