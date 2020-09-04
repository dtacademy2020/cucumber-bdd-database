package com.automationpractice.apiTests;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.testng.annotations.Test;

import com.automationpractice.PlacePojos.Candidate;
import com.automationpractice.PlacePojos.Place;
import com.automationpractice.pojos.VideoGame;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class DeserializeComplexNestedJSONtoPOJO {
	
	
	@Test
	public void deserializingcomplexJSONtoPOJO() {
		
		
		
			
			RestAssured.baseURI = "https://maps.googleapis.com";
			
		Response response = given(). 
			queryParam("input", "Duotech").
			queryParam("inputtype", "textquery").
			queryParam("fields", "photos,formatted_address,name,rating,opening_hours,geometry").
			queryParam("key", "AIzaSyCW1pMbqWsBrmZaZAgUQPwPuv7EOBcQ-Qc").
			
		
			when().
					get("/maps/api/place/findplacefromtext/json").
			then().log().all().
					assertThat().
								statusCode(200).extract().response();
		
		
		    Place place = response.as(Place.class);
		    
		    
		   assertEquals( place.getCandidates().get(0).getName(),
				   			"Duotech Academy");
		   
		   
		   assertEquals( place.getCandidates().get(0).getGeometry().getViewport().getNortheast().getLat(),
		   			new Double(38.91646782989272));
				         


		


		 
		
}
	
	
	@Test
	public void deserializingcomplexJSONtoPOJO2() {
		
		
		
			
			RestAssured.baseURI = "https://maps.googleapis.com";
			
		Response response = given(). 
			queryParam("input", "Peet's coffee").
			queryParam("inputtype", "textquery").
			queryParam("fields", "name,rating").
			queryParam("key", "AIzaSyCW1pMbqWsBrmZaZAgUQPwPuv7EOBcQ-Qc").
			
		
			when().
					get("/maps/api/place/findplacefromtext/json").
			then().log().all().
					assertThat().
								statusCode(200).extract().response();
		
		
		    Place place = response.as(Place.class);
		    
		    
		   assertEquals( place.getCandidates().get(0).getName(),
				   			"Peet's Coffee");
		   
		   
		   assertEquals( place.getCandidates().get(0).getRating(),
		   			new Double(4.4));
				         


		


		 
		
}
	
}
