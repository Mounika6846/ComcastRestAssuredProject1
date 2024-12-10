package com.api.test1;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class APIChain {
	int extractedID;
	
	@Test(priority=1)
	
	public void createJsonApi()
		{
			JSONObject requestBody= new JSONObject();
			requestBody.put("name","mouni456123");
			requestBody.put("gender","female");
			requestBody.put("email","mou12we34@15789hjk1ce.com");
			requestBody.put("status","inactive");
			extractedID=given().
			header("Accept", "application/json").
			header("Content-Type", "application/json").
			header("Authorization", "Bearer 437594174f80db783282ad93f316a9f59daad5baaccbccec7a021e7b49e56bba").
			when().
			body(requestBody.toString()).
			post("https://gorest.co.in/public/v2/users").
			jsonPath().getInt("id");
			//then().
		//	statusCode(201).
			//header("Content-Type","application/json; charset=utf-8").
			//log().all();
		}
	@Test(priority=2,dependsOnMethods=("createJsonApi"))
	
	public void UpdateAPIUsingJson() {
		JSONObject resquestBody = new JSONObject();
		resquestBody.put("name","sandwweep123");
		resquestBody.put("email","yarrrraaa@hasma1p.com");
		resquestBody.put("status","active");
		
		given().
		header("Accept", "application/json").
		header("Content-Type", "application/json").
		header("Authorization", "Bearer 437594174f80db783282ad93f316a9f59daad5baaccbccec7a021e7b49e56bba").
		
		when().
		body(resquestBody.toString()).
		patch("https://gorest.co.in/public/v2/users/"+extractedID).
		
		then().
		statusCode(200).
		header("Content-Type","application/json; charset=utf-8").
		log().all();
		
	}
	@Test(priority=3,dependsOnMethods=("createJsonApi"))
	public void DeleteAPI() {
		given().
		header("Accept", "application/json").
		header("Content-Type", "application/json").
		header("Authorization", "Bearer 437594174f80db783282ad93f316a9f59daad5baaccbccec7a021e7b49e56bba").
		
		when().
		
		delete("https://gorest.co.in/public/v2/users/"+extractedID).
		
		then().
		statusCode(204);
		
		
		
	}

}
