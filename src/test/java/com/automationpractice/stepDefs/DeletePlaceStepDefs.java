package com.automationpractice.stepDefs;

import java.util.List;
import java.util.Map;

import com.automationpractice.apiTests.Payloads;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.*;

public class DeletePlaceStepDefs {
	
	Response rs;
	String placeID;
	
	@Given("I send a post request to addPlace endpoint with a payload that contains the following")
	public void iSendAPostRequestToAddPlaceEndpointWithAPayloadThatContainsTheFollowing(List<Map<String,String>> dataTable) {
	    
		
		RestAssured.baseURI = "http://3.6.24.244/";
		
		 rs = given().
		      queryParam("key", "qaclick123").
		      contentType(ContentType.JSON).
		      body(Payloads.addPlace(dataTable.get(0).get("name"), dataTable.get(0).get("phone"), 
		    		  dataTable.get(0).get("address"))).
		 when().
		 	  post("/maps/api/place/add/json").
		 then().
		      assertThat().
		      statusCode(200).extract().response();
		      
//		 String responseBody = rs.asString();
	
//		 System.out.println(responseBody);
		 
		JsonPath jp =  rs.jsonPath();
		
		placeID = jp.getString("place_id");
		
		
	
	
	}

	@When("I retrieve the place using the place id")
	public void iRetrieveThePlaceUsingThePlaceId() {
	   
		rs = given().
	      queryParam("key", "qaclick123").
	      queryParam("place_id", placeID).
	      contentType(ContentType.JSON).
	      
	      when().
	 	  		get("/maps/api/place/get/json");
		
	    		
	}

	@Then("The payload should contain the following info")
	public void thePayloadShouldContainTheFollowingInfo(List<Map<String,String>> dataTable) {
	   
		rs.then(). log().all().
				assertThat().
				statusCode(Integer.parseInt(dataTable.get(0).get("response code"))).
				body("name", equalTo(dataTable.get(0).get("name"))).
				body("address", equalTo(dataTable.get(0).get("address"))).
				body("phone_number", equalTo(dataTable.get(0).get("phone")));
				
		
		
	}

	@When("I send delete request using the place id")
	public void iSendDeleteRequestUsingThePlaceId() {
		
		rs = given().
	      queryParam("key", "qaclick123").
	      contentType(ContentType.JSON).
	      body(Payloads.deletePlace(placeID)).
	      
	      when(). log().all().
	 	  		delete("/maps/api/place/delete/json");
		
	    
	}

	@Then("The place should be deleted successfully")
	public void thePlaceShouldBeDeletedSuccessfully() {
		
		rs.then().log().all().
			assertThat().
			    statusCode(200).
			    body("status", is("OK"));
	   
	}

}
